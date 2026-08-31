#include<bits/stdc++.h>
#define rep(i,n) for(int i=0;i<n;i++)
#define int long long
using namespace std;
int a[55],b[55],c[55],d[55];
signed main(){
	int n,m;cin>>n>>m;
	rep(i,n)cin>>a[i]>>b[i];
	rep(i,m)cin>>c[i]>>d[i];
	
	rep(i,n){
		int dis=1145141919,num=-1;
		rep(j,m){
			int di=abs(a[i]-c[j])+abs(b[i]-d[j]);
			if(dis>di){
				dis=di;
				num=j;
				}
			}
			cout<<num+1<<endl;
		}
	}
