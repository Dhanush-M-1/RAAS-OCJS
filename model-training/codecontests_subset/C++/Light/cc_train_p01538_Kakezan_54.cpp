#include <stdio.h>
#define max(a,b) a > b ? a : b

int main(void){
	int max, t, i, k, n, count, m;
	scanf("%d",&m);
	for(k = 0;k < m;k++){
		scanf("%d",&n);
		count = 0;
		while(n / 10){
			max = 0x80000000;
			for(i = 10;n / i != 0;i*=10){
				t = (n / i) * (n - (n / i) * i);
				max = max(t,max);
			}
			n = max;
			count++;
		}
		printf("%d\n",count);
	}
	return 0;
}