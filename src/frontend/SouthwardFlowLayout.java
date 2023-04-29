package frontend;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Insets;

public class SouthwardFlowLayout extends FlowLayout {
    public SouthwardFlowLayout() {
        super();
    }

    public SouthwardFlowLayout(int align) {
        super(align);
    }

    public SouthwardFlowLayout(int align, int hgap, int vgap) {
        super(align, hgap, vgap);
    }

    @Override
    public Dimension preferredLayoutSize(Container target) {
        synchronized (target.getTreeLock()) {
            int maxPreferredWidth = 0;
            int totalPreferredHeight = 0;

            int n = target.getComponentCount();
            for (int i = 0; i < n; i++) {
                Component c = target.getComponent(i);
                if (c.isVisible()) {
                    Dimension d = c.getPreferredSize();
                    maxPreferredWidth = Math.max(maxPreferredWidth, d.width);
                    totalPreferredHeight += d.height;
                }
            }

            Insets insets = target.getInsets();
            int totalWidth = maxPreferredWidth + insets.left + insets.right + getHgap() * 2;
            int totalHeight = totalPreferredHeight + insets.top + insets.bottom + getVgap() * (n - 1);
            return new Dimension(totalWidth, totalHeight);
        }
    }

    @Override
    public Dimension minimumLayoutSize(Container target) {
        synchronized (target.getTreeLock()) {
            int maxMinimumWidth = 0;
            int totalMinimumHeight = 0;

            int n = target.getComponentCount();
            for (int i = 0; i < n; i++) {
                Component c = target.getComponent(i);
                if (c.isVisible()) {
                    Dimension d = c.getMinimumSize();
                    maxMinimumWidth = Math.max(maxMinimumWidth, d.width);
                    totalMinimumHeight += d.height;
                }
            }

            Insets insets = target.getInsets();
            int totalWidth = maxMinimumWidth + insets.left + insets.right + getHgap() * 2;
            int totalHeight = totalMinimumHeight + insets.top + insets.bottom + getVgap() * (n - 1);
            return new Dimension(totalWidth, totalHeight);
        }
    }

    @Override
    public void layoutContainer(Container target) {
        synchronized (target.getTreeLock()) {
            Insets insets = target.getInsets();
            int maxWidth = target.getWidth() - insets.left - insets.right - getHgap() * 2;
            int maxHeight = target.getHeight() - insets.top - insets.bottom - getVgap() * (target.getComponentCount() - 1);

            int x = insets.left + getHgap();
            int y = target.getHeight() - insets.bottom;

            for (int i = target.getComponentCount() - 1; i >= 0; i--) {
                Component c = target.getComponent(i);
                if (c.isVisible()) {
                    Dimension d = c.getPreferredSize();
                    int width = Math.min(d.width, maxWidth);
                    int height = Math.min(d.height, maxHeight - (insets.top + target.getHeight() - y));

                    c.setBounds(x, y - height, width, height);
                    y -= height + getVgap();
                }
            }
        }
    }
}
