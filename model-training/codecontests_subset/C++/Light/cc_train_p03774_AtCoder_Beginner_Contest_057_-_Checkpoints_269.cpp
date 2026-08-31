#include<bits/stdc++.h>
#define lp3(i,a,b) for(int i=a;i<b;i++)
#define lp2(i,n) for(int i=0;i<n;i++)
using namespace std;
int main(){
	int a[51],b[51],c[51],d[51],n,m;
	cin>>n>>m;
	lp3(i,1,n+1){
		cin>>a[i]>>b[i];
	}
	lp3(i,1,m+1){
		cin>>c[i]>>d[i];
	}
	lp3(i,1,n+1){
		int an = INT_MAX,ans=0;
		lp3(j,1,m+1){
			if(abs(a[i]-c[j])+abs(b[i]-d[j])<an){
				ans=j;
				an = abs(a[i]-c[j])+abs(b[i]-d[j]);
			}
		}
		cout<<ans<<endl;
	}
	return 0;
}
