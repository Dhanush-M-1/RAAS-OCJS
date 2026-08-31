#include<bits/stdc++.h>
using namespace std;

int main(){
	int n,m;	cin>>n>>m;
	int a[n],b[n];	for(int i=0;i<n;i++)cin>>a[i]>>b[i];

	int c[m],d[m];	for(int i=0;i<m;i++)cin>>c[i]>>d[i];

	int xl,yl,sum,ans;
	for(int i=0;i<n;i++){
		xl=200000000,yl=200000000;
		sum=xl+yl;

		for(int j=0;j<m;j++){
			if(abs(a[i]-c[j]) + abs(b[i]-d[j])<sum){
				sum=abs(a[i]-c[j]) + abs(b[i]-d[j]);
				ans=j+1;
			}
		}

		cout<<ans<<endl;
	}

	return 0;
}
