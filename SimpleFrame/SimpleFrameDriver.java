package SimpleFrame;

public class SimpleFrameDriver
{
 public static void main(String[] args)
  {
    SimpleFrame sFrame1 = new SimpleFrame();/*@\label{frame1:line}@*/
    SimpleFrame sFrame2 = new SimpleFrame();/*@\label{frame2:line}@*/
    sFrame1.showIt("SimpleFrame 1");        /*@\label{framevis1:line}@*/
    sFrame2.showIt("SimpleFrame 2",300,300);/*@\label{framevis2:line}@*/
  }
}
