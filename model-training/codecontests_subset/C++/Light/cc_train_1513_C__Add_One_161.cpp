#include<bits/stdc++.h>
using namespace std;
const int N = 300005;
const int mod = 1e9 + 7;
#define ll long long
#define rep(i, a, b) for(int i=(a);i<=(b);++i)
#define per(i, a, b) for(int i=(a);i>=(b);--i)
#define ms(a, b) memset(a, b, sizeof a) 
int n, T, m;
ll f[N + 100];
int main(){
	for(int i=0;i<=9;i++)f[i]=1;
	for(int i=10;i<N;i++)f[i]=(f[i-10]+f[i-9])%mod;
	scanf("%d", &T);
	while(T--){
		scanf("%d%d", &n, &m);
		int ans = 0;
		while(n)ans=(ans+f[m+n%10])%mod, n /= 10;
		printf("%d\n", ans);
	}
}