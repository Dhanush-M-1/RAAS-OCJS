#include <bits/stdc++.h>
using namespace std;
#define MAXN 59
#define LL long long
int main(){
	int n,m;
	cin>>n>>m;
	LL a[MAXN], b[MAXN], c[MAXN], d[MAXN];
	for(int i=1;i<=n;i++){
		cin>>a[i]>>b[i];
	}
	for(int i=1;i<=m;i++){
		cin>>c[i]>>d[i];
	}
	for(int i=1;i<=n;i++){
		LL dist;
		LL min=abs(a[i]-c[1])+abs(b[i]-d[1]);
		int ind=1;
		for(int j=1;j<=m;j++){
			dist=abs(a[i]-c[j])+abs(b[i]-d[j]);
			if(dist<min){
				min=dist;
				ind=j;
			}
		}
		cout<<ind<<endl;
	}
	return 0;
}