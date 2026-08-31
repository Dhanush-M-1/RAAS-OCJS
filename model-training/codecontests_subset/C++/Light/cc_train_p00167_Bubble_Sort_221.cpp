#include<iostream>
#include<string>
using namespace std;
int a[100];
int main(){
	int n;
	while(true){
	cin>>n;
	if(n==0)
		break;
	for(int i=0;i<n;i++)
		cin>>a[i];
	int ans=0;
	for(int i=0;i<n-1;i++){
		for(int j=n-1;j>i;j--){
			if(a[j]<a[j-1]){
				int tmp=a[j];
				a[j]=a[j-1];
				a[j-1]=tmp;
				ans++;
			}
		}
	}
	cout<<ans<<endl;
	}
	return 0;
}