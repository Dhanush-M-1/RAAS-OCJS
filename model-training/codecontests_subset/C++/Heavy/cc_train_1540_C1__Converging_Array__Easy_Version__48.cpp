#include <bits/stdc++.h>
using namespace std;

const int Mod = 1e9 + 7;
int n, x, ans, a[105], b[105], c[105], s1[105], s2[105], dp[105][10005];

int main(){
	scanf("%d", &n);
	for(int i=1; i<=n; ++i){
		scanf("%d", &c[i]);
		s1[i] = s1[i-1] + c[i];
	}
	for(int i=1, s=0; i<n; ++i) scanf("%d", &b[i]);
	scanf("%*d%d", &x);
	s2[1] = x;
	for(int i=1, s=x; i<n; ++i){
		s += b[i];
		s2[i+1] = s2[i] + s;
	}
	dp[0][0] = 1;
	for(int i=0; i<n; ++i){
		for(int j=0; j<=s1[i]; ++j){
			for(int k=max(0, s2[i+1]-j); k<=c[i+1]; ++k){
				dp[i+1][j+k] = (dp[i+1][j+k]+dp[i][j]) % Mod;
			}
		}
	}
	for(int i=max(0, s2[n]); i<=s1[n]; ++i) ans = (ans+dp[n][i]) % Mod;
	printf("%d\n", ans);
	return 0;
}