#include<cstdio>
#include<cmath>

int main(){
	double a[4][2];
	double d[4];
	bool f = 0;
	int count;
	while(1 + scanf("%lf,%lf,", &a[0][0], &a[0][1])){
		count = 0;
		for(int i = 1; i < 4; i++){
			scanf("%lf,%lf,", &a[i][0], &a[i][1]);
		}
		for(int i = 0; i < 4; i++){
			d[i] = atan2(a[i][0] - a[(i+1)%4][0],a[i][1] - a[(i+1)%4][1]);
		}
		for(int i = 0; i < 4; i++){
			if(0 < sin(d[i] - d[(i+1)%4])){
				count++;
			}else{
				count--;
			}
		}
		if(count / 3){
			printf("YES\n");
		}else{
			printf("NO\n");
		}
	}
	return 0;
}