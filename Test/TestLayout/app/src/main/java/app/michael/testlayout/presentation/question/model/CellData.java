package app.michael.testlayout.presentation.question.model;

/**
 * Created by michael on 11/28/15.
 */

enum eCellDataType {
    TEXT,
    IMAGE,
    AUDIO,
    VIDEO,
    RADIOBOX,
    CHECKBOX,
    THREE_DOTS,
    UNDER_LINE,
    GRAY_BOX,
    WHITE_BOX

}
public class CellData {
    private eCellDataType displayType;
    private String data;
    private String audioUrl;
    private String description;

    public CellData() {

    }

    public CellData(String audioUrl, String data, String description, eCellDataType displayType) {
        this.setAudioUrl(audioUrl);
        this.setData(data);
        this.setDescription(description);
        this.setDisplayType(displayType);
    }

    public static CellData makeShortText() {
        CellData cellData = new CellData();
        cellData.setDisplayType(eCellDataType.TEXT);
        cellData.setData("<p>Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas.</p>");

        return  cellData;
    }
    public static CellData makeLongText() {
        CellData cellData = new CellData();
        cellData.setDisplayType(eCellDataType.TEXT);
        cellData.setData("<p>Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Vestibulum tortor quam, feugiat vitae, ultricies eget, tempor sit amet, ante. Donec eu libero sit amet quam egestas semper. Aenean ultricies mi vitae est. Mauris placerat eleifend leo. Quisque sit amet est et sapien ullamcorper pharetra. Vestibulum erat wisi, condimentum sed, commodo vitae, ornare sit amet, wisi. Aenean fermentum, elit eget tincidunt condimentum, eros ipsum rutrum orci, sagittis tempus lacus enim ac dui. Donec non enim in turpis pulvinar facilisis. Ut felis. Praesent dapibus, neque id cursus faucibus, tortor neque egestas augue, eu vulputate magna eros eu erat. Aliquam erat volutpat. Nam dui mi, tincidunt quis, accumsan porttitor, facilisis luctus, metus</p>");

        return  cellData;
    }
    public static CellData makeImage() {
        CellData cellData = new CellData();
        return  cellData;
    }
    public static CellData makeAudio() {
        CellData cellData = new CellData();
        return  cellData;
    }
    public static CellData makeVideo() {
        CellData cellData = new CellData();
        return  cellData;
    }
    public static CellData makeRadioBox() {
        CellData cellData = new CellData();
        return  cellData;
    }
    public static CellData makeCheckBox() {
        CellData cellData = new CellData();
        return  cellData;
    }
    public static CellData makeThreeDots() {
        CellData cellData = new CellData();
        return  cellData;
    }
    public static CellData makeUnderline() {
        CellData cellData = new CellData();
        return  cellData;
    }
    public static CellData makeGrayBox() {
        CellData cellData = new CellData();
        return  cellData;
    }
    public static CellData makeWhiteBox() {
        CellData cellData = new CellData();
        return  cellData;
    }

    public eCellDataType getDisplayType() {
        return displayType;
    }

    public void setDisplayType(eCellDataType displayType) {
        this.displayType = displayType;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getAudioUrl() {
        return audioUrl;
    }

    public void setAudioUrl(String audioUrl) {
        this.audioUrl = audioUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

