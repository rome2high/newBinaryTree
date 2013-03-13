import javax.swing.*;
import java.awt.*;


public class TreePanel extends JPanel {

 /**
  * 
  */
 private static final long serialVersionUID = 1L;
 private final int WIDTH = 440;
 private final int HEIGHT = 380;
 private int yInc=70;
 protected BinaryTree binaryTree;
 
 public TreePanel() {
  binaryTree = new BinaryTree();
  setPreferredSize(new Dimension(WIDTH, HEIGHT));
  setBackground(Color.ORANGE);
 }
 
 public void insertNode(int e) {
  binaryTree.addNode(e);
 }
 
 public void clear() {
  binaryTree = new BinaryTree();
 }
 
 //help method that is used by addNode method.
 private int maxNodesInLevel(int level){
  return (int)Math.pow(2.0, level);
 }
 
 public void paintComponent(Graphics g) {
  super.paintComponent(g);
  int boundingBox = 24, level = 0;
  int nNodes, e, x, y, px, py, xInc, xText, yText;
  BTNode root, child, n;
  Queue outputQueue = new Queue();
  Queue oddQueue = new Queue();
  Queue evenQueue = new Queue();
  if (!binaryTree.isEmpty()) {
   root = binaryTree.root();
   root.setX(WIDTH/2);
   root.setY(yInc);
   root.setLevel(++level);
   oddQueue.enque(root);
   outputQueue.enque(root);
  }
  while (!oddQueue.isEmpty() || !evenQueue.isEmpty()) {
   nNodes = maxNodesInLevel(level++);
   xInc = WIDTH/(nNodes + level);
   if (!oddQueue.isEmpty()) {
    while (!oddQueue.isEmpty()) {
     root = (BTNode)oddQueue.deque();
     if (root.getLeft()!= null) {
      child = root.getLeft();
      x = root.getX() - xInc;
      y = root.getY() + yInc;
      child.setX(x);
      child.setY(y);
      child.setPX(root.getX());
      child.setPY(root.getY());
      child.setLevel(level);
      evenQueue.enque(child);
      outputQueue.enque(child);
     }
     if (root.getRight()!= null) {
      child = root.getRight();
      x = root.getX() + xInc;
      y = root.getY() + yInc;
      child.setX(x);
      child.setY(y);
      child.setPX(root.getX());
      child.setPY(root.getY());
      child.setLevel(level);
      evenQueue.enque(child);
      outputQueue.enque(child);
     }
    }
   } else if (!evenQueue.isEmpty()) {
    while (!evenQueue.isEmpty()) {
     root = (BTNode)evenQueue.deque();
     if (root.getLeft()!= null) {
      child = root.getLeft();
      x = root.getX() - xInc;
      y = root.getY() + yInc;
      child.setX(x);
      child.setY(y);
      child.setPX(root.getX());
      child.setPY(root.getY());
      child.setLevel(level);
      oddQueue.enque(child);
      outputQueue.enque(child);
     }
     if (root.getRight()!= null) {
      child = root.getRight();
      x = root.getX() + xInc;
      y = root.getY() + yInc;
      child.setX(x);
      child.setY(y);
      child.setPX(root.getX());
      child.setPY(root.getY());
      child.setLevel(level);
      oddQueue.enque(child);
      outputQueue.enque(child);
     }
    }
   }
  }
  while (!outputQueue.isEmpty()) {
   n = (BTNode)outputQueue.deque();
   e = n.element();
   x = n.getX();
   x = x - boundingBox/2;
   y = n.getY();
   px = n.getPX();
   py = n.getPY();
   g.setColor(Color.black);
   g.fillOval(x, y, boundingBox, boundingBox);
   xText = x + boundingBox/3 - 5;
   yText = y + boundingBox/2 + 5;
   g.setColor(Color.white);
   g.drawString(e + "", xText, yText);
   if (px != -1) {
    g.setColor(Color.black);
    g.drawLine(px, py + boundingBox - 1,
      x + boundingBox/2, y);
   }
  }
 }



}
