#include<bits/stdc++.h>
using namespace std;
long long n,m,a[101],b[101],c[101],d[101],cnt,sum;
int main(){
	scanf("%lld%lld",&n,&m);
	for(register int i=1;i<=n;++i)
		cin>>a[i]>>b[i];
	for(register int i=1;i<=m;++i)
		cin>>c[i]>>d[i];
	for(register int i=1;i<=n;++i){
		long long ans=999999999;
		for(register int j=1;j<=m;++j){
			cnt=abs(a[i]-c[j])+abs(b[i]-d[j]);
			if(cnt<ans) {
				ans=cnt;
				sum=j;
			}
		}
		cout<<sum<<endl;
	}
	return 0;
}