#include <bits/stdc++.h>
typedef long long ll;
using namespace std;

ll inf=1ll<<60;

int main()
{
	//freopen("input.txt","r",stdin);freopen("output.txt","w",stdout);
	ll n,m,i,j,a[50],b[50],c[50],d[50],t1,t;
	cin>>n>>m;
	for (i=0;i<n;i++){
		cin>>a[i]>>b[i];
	}
	for (i=0;i<m;i++){
		cin>>c[i]>>d[i];
	}
	for (i=0;i<n;i++){
		t1=inf;
		for (j=0;j<m;j++){
			if (t1>abs(c[j]-a[i])+abs(d[j]-b[i])){
				t=j+1;
				t1=abs(c[j]-a[i])+abs(d[j]-b[i]);
			}
		}
		cout<<t<<"\n";
	}
	return 0;
}