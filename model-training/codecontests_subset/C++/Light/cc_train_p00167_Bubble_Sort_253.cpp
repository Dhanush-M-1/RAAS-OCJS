#include<stdio.h>

int main(){
	int num[100];
	int i,j,k;
	int ch;
	int cnt = 0;
	int n;


while(scanf("%d",&n),n){
	for(i = 0; i < n; i++)
			scanf("%d",&num[i]);
	
	for(j = 0; j < n-1; j++){
		for(k = 0; k < n-1-j; k++){
			if(num[k] > num[k+1]){
				ch = num[k];
				num[k] = num[k+1];
				num[k+1] = ch;
				cnt++;
			}
		}
	}
	
		printf("%d\n",cnt);
		cnt = 0;
	}

	return 0;
}