#include<stdio.h>
int main(void)
{
	int n;
	int a[101];
	int cnt;
	int i,j,temp;
	
	scanf("%d",&n);
	while(n!=0){
		cnt=0;
		for(i=0;i<n;i++){
			scanf("%d",&a[i]);
		}
		for(i=0;i<n;i++){
			for(j=0;j<n-1;j++){
				if(a[j]>a[j+1]){
					cnt++;
					temp=a[j];
					a[j]=a[j+1];
					a[j+1]=temp;
				}
			}
		}
		printf("%d\n",cnt);
		scanf("%d",&n);
	}
	return 0;
}