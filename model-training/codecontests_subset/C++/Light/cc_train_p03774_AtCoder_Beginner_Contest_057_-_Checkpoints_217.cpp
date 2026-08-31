#include<bits/stdc++.h>
const int inf=1145141919;
const int dd[]={0,-1,0,1,0};
using namespace std;
int a[50],b[50],c[50],d[50],e[50];
signed main(){
	int n,m;
	int i,j;
	cin>>n>>m;
	for(i=0;i<n;i++)
		cin>>a[i]>>b[i];
	for(i=0;i<m;i++)
		cin>>c[i]>>d[i];
	for(i=0;i<n;i++){
		int u=inf,v=-1;
		for(j=0;j<m;j++){
			int x=abs(a[i]-c[j])+abs(b[i]-d[j]);
			if(x<u){
				u=x;
				v=j;
			}
		}
		e[i]=v;
	}
	for(i=0;i<n;i++)
		cout<<e[i]+1<<endl;
}
