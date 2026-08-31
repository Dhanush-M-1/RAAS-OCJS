#include<bits/stdc++.h> 
using namespace std;

int main(){
	int n,m,a[50],b[50],c[50],d[50];
	cin>>n>>m;
	for(int i=0;i<n;i++){
		cin>>a[i]>>b[i];
	}
	for(int i=0;i<m;i++){
		cin>>c[i]>>d[i];
	}
	for(int i=0;i<n;i++){
		int ans;
		int cnt=2100000000;
		for(int j=m-1;j>=0;j--){
			if(cnt>=abs(a[i]-c[j])+abs(b[i]-d[j])){
				ans=j+1;
				cnt=abs(a[i]-c[j])+abs(b[i]-d[j]);
			}
		}
		cout<<ans<<endl;
	}
}
