#include <bits/stdc++.h>
long long a[1000000],f[1000000];
using namespace std;
int main(){
	long long n,m,num,base=1000000007;
	cin>>n>>m;
	for (int i=0;i<=n;i++) a[i]=0;
	for (int i=0;i<m;i++){
		cin>>num;
		a[num]=1;
	}
	f[0]=1;
	if (a[1]==0) f[1]=1;
	else f[1]=0;
	for (int i=2;i<=n;i++)
		if (a[i]==0)
			f[i]=(f[i-1]+f[i-2])%base;
	cout<<f[n];
	return 0;
}