package homework6;

import java.net.CookieHandler;

public class Laptop {
    // stock keeping unit - Артикул
    String SKU;
    String firm;
    String model;
    Integer ramMB;
    Integer volumeStorage;
    String CPU;
    String screenResolution;
    String operationalSystem;
    String color;
    Double price;
    public Laptop(){

    }

    public Laptop(String firm, String model, Integer ramMB, Integer volumeStorage, String cPU, String screenResolution,
            String operationalSystem, String color, Double price) {
        this.firm = firm;
        this.model = model;
        this.ramMB = ramMB;
        this.volumeStorage = volumeStorage;
        CPU = cPU;
        this.screenResolution = screenResolution;
        this.operationalSystem = operationalSystem;
        this.color = color;
        this.price = price;
    }
    public Laptop(String sKU, String firm, String model, Integer ramMB, Integer volumeStorage, String cPU,
            String screenResolution, String operationalSystem, String color, Double price) {
        SKU = sKU;
        this.firm = firm;
        this.model = model;
        this.ramMB = ramMB;
        this.volumeStorage = volumeStorage;
        CPU = cPU;
        this.screenResolution = screenResolution;
        this.operationalSystem = operationalSystem;
        this.color = color;
        this.price = price;
    }
    public String getSKU() {
        return SKU;
    }
    public void setSKU(String sKU) {
        SKU = sKU;
    }
    public String getFirm() {
        return firm;
    }
    public void setFirm(String firm) {
        this.firm = firm;
    }
    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }
    public Integer getRamMB() {
        return ramMB;
    }
    public void setRamMB(Integer ramMB) {
        this.ramMB = ramMB;
    }
    public Integer getVolumeStorage() {
        return volumeStorage;
    }
    public void setVolumeStorage(Integer volumeStorage) {
        this.volumeStorage = volumeStorage;
    }
    public String getCPU() {
        return CPU;
    }
    public void setCPU(String cPU) {
        CPU = cPU;
    }
    public String getScreenResolution() {
        return screenResolution;
    }
    public void setScreenResolution(String screenResolution) {
        this.screenResolution = screenResolution;
    }
    public String getOperationalSystem() {
        return operationalSystem;
    }
    public void setOperationalSystem(String operationalSystem) {
        this.operationalSystem = operationalSystem;
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public Double getPrice() {
        return price;
    }
    public void setPrice(Double price) {
        this.price = price;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((SKU == null) ? 0 : SKU.hashCode());
        result = prime * result + ((firm == null) ? 0 : firm.hashCode());
        result = prime * result + ((model == null) ? 0 : model.hashCode());
        result = prime * result + ((ramMB == null) ? 0 : ramMB.hashCode());
        result = prime * result + ((volumeStorage == null) ? 0 : volumeStorage.hashCode());
        result = prime * result + ((CPU == null) ? 0 : CPU.hashCode());
        result = prime * result + ((screenResolution == null) ? 0 : screenResolution.hashCode());
        result = prime * result + ((operationalSystem == null) ? 0 : operationalSystem.hashCode());
        result = prime * result + ((color == null) ? 0 : color.hashCode());
        result = prime * result + ((price == null) ? 0 : price.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Laptop other = (Laptop) obj;
        if (SKU == null) {
            if (other.SKU != null)
                return false;
        } else if (!SKU.equals(other.SKU))
            return false;
        if (firm == null) {
            if (other.firm != null)
                return false;
        } else if (!firm.equals(other.firm))
            return false;
        if (model == null) {
            if (other.model != null)
                return false;
        } else if (!model.equals(other.model))
            return false;
        if (ramMB == null) {
            if (other.ramMB != null)
                return false;
        } else if (!ramMB.equals(other.ramMB))
            return false;
        if (volumeStorage == null) {
            if (other.volumeStorage != null)
                return false;
        } else if (!volumeStorage.equals(other.volumeStorage))
            return false;
        if (CPU == null) {
            if (other.CPU != null)
                return false;
        } else if (!CPU.equals(other.CPU))
            return false;
        if (screenResolution == null) {
            if (other.screenResolution != null)
                return false;
        } else if (!screenResolution.equals(other.screenResolution))
            return false;
        if (operationalSystem == null) {
            if (other.operationalSystem != null)
                return false;
        } else if (!operationalSystem.equals(other.operationalSystem))
            return false;
        if (color == null) {
            if (other.color != null)
                return false;
        } else if (!color.equals(other.color))
            return false;
        if (price == null) {
            if (other.price != null)
                return false;
        } else if (!price.equals(other.price))
            return false;
        return true;
    }
    @Override
    public String toString() {
        return "Notebook [SKU=" + SKU + ", firm=" + firm + ", model=" + model + ", ramMB=" + ramMB + ", volumeStorage="
                + volumeStorage + ", CPU=" + CPU + ", screenResolution=" + screenResolution + ", operationalSystem="
                + operationalSystem + ", color=" + color + ", price=" + price + "]";
    }
    public boolean partialEquals(Laptop laptop) {
        return this.ramMB.equals(laptop.getRamMB()) && this.volumeStorage.equals(laptop.getVolumeStorage()) 
            && this.operationalSystem.equals(laptop.getOperationalSystem()) && this.color.equals(laptop.getColor());
    }
    public boolean moreEquals(Laptop laptop) {
        return this.ramMB.intValue() <= laptop.getRamMB().intValue() && this.volumeStorage <= laptop.getVolumeStorage() 
            && this.operationalSystem.equals(laptop.getOperationalSystem()) && this.color.equals(laptop.getColor());
    }

    
}
