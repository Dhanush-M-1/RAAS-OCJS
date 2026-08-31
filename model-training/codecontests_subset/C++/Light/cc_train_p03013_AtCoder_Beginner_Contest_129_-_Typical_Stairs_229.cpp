#include<bits/stdc++.h>
using namespace std;
#define int long long
#define mod 1000000007
int d[100005],a[100005],n,m;
void add(int &a,int b){
	a = (a + b)%mod;
}
signed main(){
	d[0] = 1;
	cin >> n >> m;
	for(int i = 0 ; i < m ; i ++){
		int x; cin >> x;
		a[x] = 1;
	}
	for(int i = 0 ; i < n ; i ++){
		if(!a[i + 1]) add(d[i + 1], d[i]);
		if(!a[i + 2]) add(d[i + 2], d[i]);
	}
	cout << d[n];
}