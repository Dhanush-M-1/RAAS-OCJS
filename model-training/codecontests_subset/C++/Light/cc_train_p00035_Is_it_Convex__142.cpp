#include <iostream>

using namespace std;

class Point{
public:
	double x;
	double y;
};


int isTriangleOutside(Point p1, Point p2, Point p3, Point p4){
	  double r1,r2,r3;
	  
   	  r1 = (p2.x-p1.x)*(p4.y-p1.y) - (p4.x-p1.x)*(p2.y-p1.y);
   	  r2 = (p3.x-p2.x)*(p4.y-p2.y) - (p4.x-p2.x)*(p3.y-p2.y);
   	  r3 = (p1.x-p3.x)*(p4.y-p3.y) - (p4.x-p3.x)*(p1.y-p3.y);
   
   	  if(r1>0&&r2>0&&r3>0 || r1<0&&r2<0&&r3<0){
   	      return 0;
   	  }else{
   	  	  return 1;
   	  }
}


int main(void){
   
   Point pa,pb,pc,pd;
   char c;
   int r1,r2,r3,r4;
   
   while(cin>>pa.x>>c>>pa.y>>c>>pb.x>>c>>pb.y>>c>>pc.x>>c>>pc.y>>c>>pd.x>>c>>pd.y){
   	
   	  r1 = 	isTriangleOutside(pa,pb,pc,pd);
   	  r2 = 	isTriangleOutside(pb,pc,pd,pa);
   	  r3 = 	isTriangleOutside(pc,pd,pa,pb);
   	  r4 = 	isTriangleOutside(pa,pb,pd,pc);
   	  
	  if(r1==1 && r2==1 && r3==1 &&r4==1){
   	      cout<<"YES"<<endl;
   	  }else{
   	  	  cout<<"NO"<<endl;
   	  }

   }
   
   return 0;
}
