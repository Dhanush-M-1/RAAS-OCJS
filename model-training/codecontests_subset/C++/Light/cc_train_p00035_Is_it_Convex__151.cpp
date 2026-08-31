#include <cstdio>
using namespace std;

int main(){
	double x[4], y[4];
	double vx, vy, v1x, v1y, v2x, v2y;
	double s, t;
	bool convex;
	
	while((scanf("%lf,%lf,%lf,%lf,%lf,%lf,%lf,%lf", &x[0], &y[0], &x[1], &y[1], &x[2], &y[2], &x[3], &y[3])) != EOF){
		convex = true;
		for(int i = 0; i < 4; i++){
			vx = x[i] - x[(i + 1) % 4];
			vy = y[i] - y[(i + 1) % 4];
			v1x = x[(i + 2) % 4] - x[(i + 1) % 4];
			v1y = y[(i + 2) % 4] - y[(i + 1) % 4];
			v2x = x[(i + 3) % 4] - x[(i + 1) % 4];
			v2y = y[(i + 3) % 4] - y[(i + 1) % 4];
			
			s = (double)(vx*v2y - vy*v2x) / (v1x*v2y - v1y*v2x);
			t = (double)(vx*v1y - vy*v1x) / (v2x*v1y - v2y*v1x);
			if(0 <= s && s <= 1 && 0 <= t && t <= 1){
				convex = false;
				printf("NO\n");
				break;
			}
		}
		if(convex){
			printf("YES\n");
		}
	}
	
	return 0;
}