#include<iostream>
using namespace std;
int main(){
	int n;
	while(cin>>n){
		int a[n];
		for(int i=0;i<n;i++){
			cin>>a[i];
		}
		int ans=0;
		for(int i=0;i<n-1;i++){
			int min=i;
			for(int j=i;j<n;j++){
				if(a[j]<a[min])
					min=j;
			}
			int temp=a[i];
			a[i]=a[min];
			a[min]=temp;
			if(i!=min)
				ans++;
		}
		cout<<a[0];
		for(int i=1;i<n;i++)
			cout<<' '<<a[i];
		cout<<endl;
		cout<<ans<<endl;
	}
	return 0;
} 
