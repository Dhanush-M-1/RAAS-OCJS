#include<bits/stdc++.h>
int i,j,d[50],p,n,q,a[5]={5,7,5,7,7};
char s[15];
int main(){
	for(n=1;n;){
		scanf("%d",&n);
		for(i=0;i<n;i++){
			scanf("%s",s);
			d[i]=strlen(s);
		}
		for(i=0;n;i++){
			p=i;
			for(j=0;j<5;j++){
				q=a[j];
				while(q>0){
					q-=d[p];p++;
				}
				if(q<0)break;
			}
			if(j>4){
				printf("%d\n",i+1);
				break;
			}
		}
	}
}