#include<bits/stdc++.h>
using namespace std;

long long n,m,a[100005],f[100005];

int main()
{
	ios::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);
	cin >> n >> m;
	for(int i = 1; i <= m; i++){
		int x;
		cin >> x;
		a[x]=1;
	}
	f[0]=1;
	if(!a[1])f[1]=1;

	for(int i = 2; i <= n; i++){
		if(a[i]==0) f[i]=(f[i-1]+f[i-2]) % 1000000007;
	}
	cout << f[n] << "\n";
	return 0;
}