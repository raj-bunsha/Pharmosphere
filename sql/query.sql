SELECT e1.medicine_name as "name",quantity,expiry_date,price,manufacturer_name FROM Inventory i,Medicine me,Manufacturer ma
    WHERE i.manufacturer_id=ma.id and i.medicine_id=me.id and i.status="T" ORDER BY e1.expiry_date 


