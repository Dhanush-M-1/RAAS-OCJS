#include <iostream>
#include <iomanip>
#include <string>
#include <vector>
#include <queue>
#include <algorithm>
#include <utility>
#include <cmath>
#include <map>
#include <set>
#include <stack>
#include <cstdio>
#include <cstdlib>
#include <cstring>

#define INF_LL 1e18
#define INF 1e9

#define REP(i, n) for(int i = 0;i < (n);i++)
#define FOR(i, a, b) for(int i = (a);i < (b);i++)
#define all(x) x.begin(),x.end()

#define fst first
#define snd second

using namespace std;

using ll = long long;
using PII = pair<int, int>;
using PLL = pair<ll, ll>;

ll MOD = 1e9+7;
int M;
string s, s1;
int dp[510][501][2][3][10];

void dec1(){
	for(int i = s1.size()-1;i >= 0;i--){
		if(s1[i] == 0) s1[i] = 9;
		else{
			s1[i]--;
			break;
		}
	}
}

const int up = 1, down = 2, stay = 0;

int dfs(int dig, int md, bool tight, int ud, int be){
	if(dig == s.size()) return ud ? md ? 0 : 1 : 0;
	if(~dp[dig][md][tight][ud][be]) return dp[dig][md][tight][ud][be];

	int lim = tight ? s[dig] : 9;
	ll res =0;
	REP(i, lim+1){
		if(ud == stay){
			if(dig < s.size()-1 && be == i){
				res += dfs(dig+1, (md*10)%M, tight & (i==lim), stay, i);
			}else if(be != i){
				res += dfs(dig+1, (md*10+i)%M, tight & (i==lim), up, i);
				if(dig < s.size()-1)
					res += dfs(dig+1, (md*10+i)%M, tight & (i==lim), down, i);
			}

		}else if(ud == up){
			if(be > i)
				res += dfs(dig+1, (md*10+i)%M, tight & (lim==i), down, i);
		}else{
			if(be < i)
				res += dfs(dig+1, (md*10+i)%M, tight & (lim==i), up, i);
		}
	}
	res %= 10000;

	return dp[dig][md][tight][ud][be] = res;
}

int main(void){
	cin >> s1 >> s >> M;
	REP(i, s.size()) s[i] -='0';
	REP(i, s1.size()) s1[i] -= '0';
	dec1();

	memset(dp, -1, sizeof dp);
	ll res1 = dfs(0,0,1,0,0);
	memset(dp, -1, sizeof dp);
	s = s1;
	ll res2 = dfs(0,0,1,0,0);
	cout << (res1-res2+10000)%10000 << endl;
}