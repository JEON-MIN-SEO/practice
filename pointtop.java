    public class pointtop {
        public static void main(String[] args) {
            point3D p = new point3D(1, 2, 3);
            System.out.println(p.get());
        }
    }
class point{
            int x;
            int y;

            // point(){
            // }

            // point(int x, int y){
            //     this.x = x;
            //     this.y = y;
            // }

            String get(){
                return "x =" + x + "y =" + y;
            }
        }    

        class point3D extends point{
            int z;

            point3D(int x, int y, int z){
                this.x = x;
                this.y = y;
                this.z = z;
            }

            String get(){
                return "x =" + x + "y =" + y + "z =" + z;
            }
        }