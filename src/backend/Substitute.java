package backend;

public class Substitute 
{
    private int medicineId, substituteId;
    
    public Substitute(int medicineId, int substituteId)
    {
        this.medicineId = medicineId;
        this.substituteId = substituteId;
    }
    public int getMedicineId()
    {
        return medicineId;
    }
    public int getSubstituteId()
    {
        return substituteId;
    }
}
