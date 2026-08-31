#include <stdio.h>
#include <math.h>

using namespace std;


int main(){
	double x1,x2,x3,x4,y1,y2,y3,y4,dist1,dist2,dist3,dist4,dist5,dist6;

	while(scanf("%lf,%lf,%lf,%lf,%lf,%lf,%lf,%lf",&x1,&y1,&x2,&y2,&x3,&y3,&x4,&y4)!=EOF){
		dist1 = sqrt((x1-x3)*(x1-x3)+(y1-y3)*(y1-y3));
		dist2 = sqrt((x2-x4)*(x2-x4)+(y2-y4)*(y2-y4));
		dist3 = fabs((y2-y4)*x1+(x4-x2)*y1+y2*(x2-x4)-x2*(y2-y4))/(sqrt((y2-y4)*(y2-y4)+(x4-x2)*(x4-x2)));
		dist4 = fabs((y1-y3)*x2+(x3-x1)*y2+y1*(x1-x3)-x1*(y1-y3))/(sqrt((y1-y3)*(y1-y3)+(x3-x1)*(x3-x1)));
		dist5 = fabs((y2-y4)*x3+(x4-x2)*y3+y2*(x2-x4)-x2*(y2-y4))/(sqrt((y2-y4)*(y2-y4)+(x4-x2)*(x4-x2)));
		dist6 = fabs((y1-y3)*x4+(x3-x1)*y4+y1*(x1-x3)-x1*(y1-y3))/(sqrt((y1-y3)*(y1-y3)+(x3-x1)*(x3-x1)));

		if(dist1 < dist3 || dist2 < dist4 || dist1 < dist5 || dist2 < dist6){
			printf("NO\n");
		}else{
			printf("YES\n");
		}
	}

	return 0;
}