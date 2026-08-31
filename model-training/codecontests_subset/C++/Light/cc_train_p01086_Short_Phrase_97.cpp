#include <stdio.h>
#include <string.h>

int main(){
	while(1){
		LOOP:
		int n;
		scanf("%d",&n);
		if(!n) break;
		char w[40][11];
		int c[40];
		for(int i=0;i<n;i++){
			scanf("%s",w[i]);
			c[i]=strlen(w[i]);
		}
		int f[]={5,7,5,7,7};
		int k;
		int tmp;
		for(int i=0;i<n;i++){
			k=0;
			tmp=0;
			for(int j=i;j<n;j++){
				if(f[k]<tmp+c[j])
					break;
				tmp+=c[j];
				if(tmp==f[k]){
					k++;
					tmp=0;
				}
				if(k==5){
					printf("%d\n",i+1);
					goto LOOP;
				}
			}
		}
	}
	return 0;
}