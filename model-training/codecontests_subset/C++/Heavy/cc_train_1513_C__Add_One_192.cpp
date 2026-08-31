// Problem: C. Add One
// Contest: Codeforces - Divide by Zero 2021 and Codeforces Round #714 (Div. 2)
// URL: https://codeforces.com/contest/1513/problem/C
// Memory Limit: 256 MB
// Time Limit: 1000 ms
// 
// Powered by CP Editor (https://cpeditor.org)

#include<iostream>
#include<cstring> 
#include<cmath>
#include<stack>
#include<algorithm>
#include<map>
#include<vector> 
#include<queue>
#include<set>

using namespace std;
const int N = 2e5+10;
const int mod = 1e9+7;
long long a[15];
long long b[N];

void init(){
	for(int i = 0; i <= 8; i ++) b[i] = 2;
	b[9]=3;
	for(int i = 10; i <=200005;i++) b[i] = (b[i-9]+b[i-10])%mod;
	
} 
void solve(long long m,long long n){
	for(int i = 0; i <=9;i ++) a[i] = 0;
	// long long n, m;
	// cin >> n >> m;
	long long ans = 0;
	if(n==0) {
		a[0]++;
	}
	while(n){
		a[n%10]++;
		n/=10;
	}
	
	
	for(int i = 0; i <=9; i ++){
		long long x;
		if(m-10+i<0) x = 1;
		else x = b[m-10+i];
		long long temp = (a[i]*x)%mod;
		ans+=temp;
		ans%=mod;
	}
	printf("%lld\n",ans);
	return;
}
int main(){
	int T;
	cin >> T;
	init();
	while (T--){
		long long n, m;
		scanf("%lld %lld",&n,&m);
		solve(m,n);
	}
	// for(int i = 0; i <= 100; i ++){
		// cout <<"i="<<i<<"----";
		// solve(i,10);
	// }
	return 0;
}

