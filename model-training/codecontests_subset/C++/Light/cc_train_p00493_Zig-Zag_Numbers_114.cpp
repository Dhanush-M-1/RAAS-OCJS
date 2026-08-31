#include <bits/stdc++.h>
using namespace std;

using VI = vector<int>;
using VVI = vector<VI>;
using PII = pair<int, int>;
using LL = long long;
using VL = vector<LL>;
using VVL = vector<VL>;
using PLL = pair<LL, LL>;
using VS = vector<string>;

#define ALL(a)  begin((a)),end((a))
#define RALL(a) (a).rbegin(), (a).rend()
#define PB push_back
#define EB emplace_back
#define MP make_pair
#define SZ(a) int((a).size())
#define SORT(c) sort(ALL((c)))
#define RSORT(c) sort(RALL((c)))
#define UNIQ(c) (c).erase(unique(ALL((c))), end((c)))

#define FOR(i,a,b) for(int i=(a);i<(b);++i)
#define REP(i,n)  FOR(i,0,n)

#define FF first
#define SS second
template<class S, class T>
istream& operator>>(istream& is, pair<S,T>& p){
  return is >> p.FF >> p.SS;
}
template<class S, class T>
ostream& operator<<(ostream& os, const pair<S,T>& p){
  return os << p.FF << " " << p.SS;
}
template<class T>
void maxi(T& x, T y){
  if(x < y) x = y;
}
template<class T>
void mini(T& x, T y){
  if(x > y) x = y;
}


const double EPS = 1e-10;
const double PI  = acos(-1.0);
const LL MOD = 10000;

int N;
int M;
int dp[505][505][3][2][10];

int solve(string& s, int i, int m, int udh, int full, int x){
  int& res = dp[i][m][udh][full][x];
  if(res != -1) return res;
  if(i == N){
	return res = (m == 0? 1: 0);
  }

  res = 0;
  int ub = (full? s[i] - '0' + 1: 10);
  int c = s[i] - '0';
  REP(nx, ub){
	int nfull = full && nx == c;
	int nm = (m * 10 + nx) % M;
	if(udh == 0 && x < nx)
	  (res += solve(s, i+1, nm, 1, nfull, nx)) %= MOD;
	else if(udh == 1 && x > nx)
	  (res += solve(s, i+1, nm, 0, nfull, nx)) %= MOD;
	else if(udh == 2){
	  if(x == 0)
		(res += solve(s, i+1, nm, 2, nfull, nx)) %= MOD;
	  if(x > 0 && nx != x)
		(res += solve(s, i+1, nm, (x<nx?1:0), nfull, nx)) %= MOD;
	}
  }

  return res;
}

void pre(string& s){
  for(int i=SZ(s)-1;i>=0;--i){
	if(s[i] != '0'){
	  s[i]--;
	  break;
	}
	else s[i] = '9';
  }

  if(s[0] == '0' && SZ(s) > 1){
	s.erase(begin(s));
  }
}

int main(){
  cin.tie(0);
  ios_base::sync_with_stdio(false);

  string A, B;
  cin >> A >> B;
  cin >> M;
  pre(A);

  fill((int*)dp, (int*)dp+505*505*3*2*10, -1);
  N = SZ(A);
  int fa = solve(A, 0, 0, 2, 1, 0);
  fill((int*)dp, (int*)dp+505*505*3*2*10, -1);
  N = SZ(B);
  int fb = solve(B, 0, 0, 2, 1, 0);
  cout << (fb + MOD - fa) % MOD << endl;

  return 0;
}