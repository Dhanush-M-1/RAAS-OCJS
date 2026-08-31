#include<iostream>
using namespace std;

long long int a[500],n;

int main(void){
	while(1){
		scanf("%d",&n);
		if(n==0)break;
		long long int ans=0;
		for(int i=0;i<n;i++){
			cin >> a[i];
		}
		for(int i=0;i<n;i++){
			for(int j=0;j<n-i-1;j++){
				if(a[j]>a[j+1]){
					swap(a[j],a[j+1]);
					ans++;
				}
			}
		}
		printf("%d\n",ans);
	}
	return 0;
}