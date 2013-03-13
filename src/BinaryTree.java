
public class BinaryTree implements BinaryTreeADT{
 protected  BTNode  root;
 protected  int  size;
 protected Queue queue; //used to keep track of last node.

 public BinaryTree(){
  root = null;
  size = 0;
  queue = new Queue();
 }

 public BTNode root(){
  if(!isEmpty())
   return  root;
  else return null;
 }

 public boolean isEmpty() {
  return (root == null);        
 }

 public int size() {return  size;}

 public boolean isRoot(BTNode v) {
  if(root == null)
   return false;
  else
   return  (v == root);
 } 

 public boolean hasParent(BTNode v) {
  if(v.getParent() == null)
   return false;
  else return true;
 }

 public BTNode parent(BTNode v){
  if(hasParent(v))
   return v.getParent();
  else return null;
 }

 public boolean isLeaf(BTNode v) {
  return (!hasLeft(v) && !hasRight(v));
 }

 public boolean hasLeft(BTNode v) {
  return  (v.getLeft() != null);
 }

 public BTNode left(BTNode v){
  if(hasLeft(v))
   return v.getLeft();
  else return null;
 }

 public boolean hasRight(BTNode v) {
  return  (v.getRight() != null);
 }

 public BTNode right(BTNode v){
  if(hasRight(v))
   return v.getRight();
  else return null;
 }

 public boolean isFull(BTNode v){
  return (hasLeft(v) && hasRight(v));
 }

 public void addNode(int value) { 
  BTNode node = new BTNode(value);
  Queue queueCopy = new Queue();
  int oldSize = size;
  
  //finish the rest
  if(size == 0){
   root = node;
   size++;
   node.setLevel(0);
   node.setInQueue(true);
   queue.enque(node);
  }else{
   
   for(int i = 0; i<oldSize; i++){
    BTNode queueNode = (BTNode) queue.deque();
    queueCopy.enque(queueNode);
    
    if(queueNode != null && !node.isInQueue()){
     if(!isFull(queueNode)){
      if(hasLeft(queueNode)){
       queueNode.setRight(node);
       size++;
       node.setParent(queueNode);
       node.setLevel(getLevel());
       node.setInQueue(true);
      }else{
       queueNode.setLeft(node);
       size++;
       node.setParent(queueNode);
       node.setLevel(getLevel());
       node.setInQueue(true);       
      }
     }
    }
   }
   queue = queueCopy;
   queue.enque(node);
  }  
 }

 private int getLevel(){
  return (int)(Math.log(size)/Math.log(2));
 }
 
}
