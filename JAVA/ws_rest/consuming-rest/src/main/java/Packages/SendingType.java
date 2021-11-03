package Packages;

public abstract class SendingType {
    private String type;

    public SendingType(String type)
    {
        this.type = type;
    }

    public String getType(){
        return type;
    }
}
