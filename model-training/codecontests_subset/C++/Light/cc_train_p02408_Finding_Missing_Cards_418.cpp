#include <stdio.h>

int main(void){

	int n;
	int i,j,k;
	scanf("%d", &n);
	
	char suit[n];
	int num[n];
	char suitlib[]="SHCD";
	char space;
	int exist;
	
	for(i=0;i<n;i++){
		scanf("\n%c",&suit[i]);
		scanf("%c",&space);
		scanf("%d",&num[i]);
	}

	for(j=0;j<4;j++){
		for(k=1;k<14;k++){
			exist=1;
			for(i=0;i<n;i++){
				if(suit[i]==suitlib[j]&&num[i]==k){
					exist=0;
				}
			}
			if(exist==1){
				printf("%c %d\n",suitlib[j],k);
			}
		}
	}
	return 0;
}