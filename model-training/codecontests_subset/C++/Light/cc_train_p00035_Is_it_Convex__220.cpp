#include <stdio.h>

bool is_up(const float x1, const float y1,
			const float x2, const float y2,
			const float xp, const float yp){
	float y = 0.0;
	y = (y2 - y1)/(x2 - x1)*(xp - x1) + y1;
	return yp > y;
}

int main(void){
	float x[4];
	float y[4];
	while(scanf("%f,%f,%f,%f,%f,%f,%f,%f",
		x, y, x+1, y+1, x+2, y+2, x+3, y+3) != EOF){
		if(is_up(x[0], y[0], x[2], y[2], x[1], y[1]) ^
			is_up(x[0], y[0], x[2], y[2], x[3], y[3]) == 0){
			puts("NO");
		}else if(is_up(x[1], y[1], x[3], y[3], x[2], y[2]) ^
			is_up(x[1], y[1], x[3], y[3], x[0], y[0]) == 0){
			puts("NO");
		}else{
			puts("YES");
		}
	}
	return 0;
}