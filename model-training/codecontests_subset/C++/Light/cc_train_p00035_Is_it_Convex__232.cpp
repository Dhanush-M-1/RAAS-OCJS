#include<iostream>
#include<stdio.h>

using namespace std;
typedef struct point{
	double x,y;
} point;


double cross(point p1, point p2, point p3, point p4){  
    return ( (p1.x-p2.x)*(p3.y-p1.y) + (p1.y-p2.y)*(p1.x-p3.x)) * ((p1.x-p2.x)*(p4.y-p1.y) + (p1.y-p2.y)*(p1.x-p4.x));  
}

int main(){
	char a;
	double l[4];
	while(1){
	bool ans = true;
	point p[4]; 
		for(int i=0;i<4;i++)
	if(scanf("%lf,%lf,",&p[i].x,&p[i].y) == EOF) return 0;
	
    if(cross(p[0],p[2],p[1],p[3]) > 0.0 || cross(p[1],p[3],p[0],p[2] ) > 0.0) ans = false;
	
	
	if(ans == true) {cout << "YES" << endl;} else {cout << "NO" << endl; }
}


}