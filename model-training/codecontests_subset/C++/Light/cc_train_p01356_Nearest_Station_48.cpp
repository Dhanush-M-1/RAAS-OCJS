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
const LL MOD = 1e9+7;
const LL INF = 1e17;

int main(){
  cin.tie(0);
  ios_base::sync_with_stdio(false);

  long long n_, m_, a_, b_, p_, q_;
  cin >> n_ >> m_ >> a_ >> b_ >> p_ >> q_;
  LL n, m, a, b, p, q;
  n = n_;
  m = m_;
  a = a_;
  b = b_;
  p = p_;
  q = q_;

  LL ans = INF;
  if(a == 1 && b == 1){
	LL k = min(n, m / (p+q));
	mini(ans, abs(k*(p+q) - m));
	if(k+1 < n)
	  mini(ans, abs((k+1)*(p+q) - m));
  }
  else{
	LL M = min((LL)40, n);
	LL M2 = M / 2;
	vector<LL> as(M+1), bs(M+1);
	as[0] = bs[0] = 1;
	REP(i,M){
	  as[i+1] = (as[i]>=INF/a? INF: as[i] * a);
	  bs[i+1] = (bs[i]>=INF/b? INF: bs[i] * b);
	}
	
	vector<LL> xs = {0}, ys = {0};
	for(int bb=0;bb<1<<M2;++bb){
	  LL sum = 0;
	  REP(i,M2)
		if(bb>>i&1){
		  if(as[i] < INF/p)
			sum += as[i]*p;
		  else
			sum = INF;
		  if(bs[i] < INF/p)
			sum += bs[i]*q;
		  else
			sum = INF;
		}
	  xs.PB(sum);
	}
	for(int bb=0;bb<1<<(M-M2);++bb){
	  LL sum = 0;
	  REP(i,M-M2)
		if(bb>>i&1){
		  if(as[i+M2] < INF/p)
			sum += as[i+M2]*p;
		  else
			sum = INF;
		  if(bs[i+M2] < INF/p)
			sum += bs[i+M2]*q;
		  else
			sum = INF;
		}
	  ys.PB(sum);
	}

	for(auto x: xs){
	  auto it = upper_bound(ALL(ys), m - x);
	  if(it != end(ys))
		mini(ans, abs(x + *it - m));
	  if(it != begin(ys)){
		--it;
		mini(ans, abs(x + *it - m));
	  }
	}
  }

  long long ans_ = ans;
  cout << ans_ << endl;

  return 0;
}