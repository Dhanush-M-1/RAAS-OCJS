#include <stdio.h>

int main(void)
{
	int n;
	int in[100];
	int i, j;
	int ans;
	
	while (1){
		scanf("%d", &n);
		
		if (n == 0)break;
		
		for (i = 0; i < n; i++){
			scanf("%d", &in[i]);
		}
		
		ans = 0;
		for (i = 0; i < n - 1; i++){
			for (j = 0; j < n - i - 1; j++){
				if (in[j] > in[j + 1]){
					in[j] += in[j + 1];
					in[j + 1] = in[j] - in[j + 1];
					in[j] -= in[j + 1];
					
					ans++;
				}
			}
		}
		
		printf("%d\n", ans);
	}
	
	return (0);
}