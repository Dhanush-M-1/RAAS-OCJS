#include <bits/stdc++.h>
using namespace std;
int main(){
	int n,tmp;
	while(cin>>n,n){
		int a[100],r=n-1,cnt=0;
		for(int i=0;i<n;i++)cin>>a[i];
		for(int i=0;i<n-1;i++){
			for(int j=0;j<r;j++){
				if(a[j]>a[j+1]){
					tmp=a[j];a[j]=a[j+1];a[j+1]=tmp;
					cnt++;
				}
			}
			r--;
		}
		cout<<cnt<<endl;
	}
}