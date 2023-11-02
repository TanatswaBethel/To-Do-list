import java.awt.*;

public class CommonConstants  {

  //color config
  public static final Color PRIMARY_COLOR = Color.decode("#d5a6bd");
  public static final Color SECONDARY_COLOR = Color.decode("#ead1dc");
  public static final Color BACKGROUND_COLOR = Color.decode("#ffffff");

  public static final Dimension GUI_SIZE = new Dimension(540, 760);

  // banner config
  public static final Dimension BANNER_SIZE = new Dimension(GUI_SIZE.width, 50);

  // task panel config
  public static final Dimension TASKPANEL_SIZE = new Dimension(GUI_SIZE.width - 30, GUI_SIZE.height - 175);

  // add task button config
  public static final Dimension ADDTASK_BUTTON_SIZE = new Dimension(GUI_SIZE.width,40);

  // taskcomponent configs
  public static final Dimension TASKFIELD_SIZE = new Dimension((int)(TASKPANEL_SIZE.width * 0.80), 50);
  public static final Dimension CHECKBOX_SIZE = new Dimension((int)(TASKFIELD_SIZE.width * 0.05), 50);
  public static final Dimension DELETE_BUTTON_SIZE = new Dimension((int)(TASKFIELD_SIZE.width * 0.11), 35);







}
