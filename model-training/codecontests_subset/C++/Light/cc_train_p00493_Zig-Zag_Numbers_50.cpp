#include <bits/stdc++.h> // {{{

#define ARG4(_1, _2, _3, _4, ...) _4
#define rep(...) ARG4(__VA_ARGS__, FOR, REP)(__VA_ARGS__)
#define REP(i, a) FOR(i, 0, a)
#define FOR(i, a, b) for (int i = (a); i < (int)(b); ++i)
#define rrep(...) ARG4(__VA_ARGS__, RFOR, RREP)(__VA_ARGS__)
#define RREP(i, a) RFOR(i, 0, a)
#define RFOR(i, a, b) for (int i = (b)-1; i >= (int)(a); --i)
#define ALL(c) (c).begin(), (c).end()
#define TEN(n) ((ll)(1e##n))
#define pb emplace_back
#define mp make_pair
#define fst first
#define snd second
#define let const auto
#define USE1(T) template <typename T>
#define USE2(T, U) template <typename T, typename U>
#define I_ inline
#define mygc(c) (c) = getchar_unlocked()
#define mypc(c) putchar_unlocked(c)

USE1(T) using duo = std::pair<T, T>;
USE1(T) using vec = std::vector<T>;
using ll = long long;
// clang-format off
USE2(T,U) I_ bool chmax(T&x,U a){return x<a&&(x=a,1);}
USE2(T,U) I_ bool chmin(T&x,U a){return a<x&&(x=a,1);}
USE1(T=int) I_ T in(){T x;std::cin>>x;return x;}
USE1(T=int) I_ vec<T> in(int n){vec<T> v;v.reserve(n);rep(i,n)v.pb(in<T>());return v;}
USE1(T) vec<T> ndvec(T v,int n){return vec<T>(n, v);}
USE2(T,...Ts) auto ndvec(T v,int n,Ts...ns)->vec<decltype(ndvec(v,ns...))>{return ndvec(ndvec(v,ns...),n);}
USE1(T) I_ void pr(T x){std::cout<<x<<'\n';}
USE2(T,...Ts) I_ void pr(T x,Ts...xs){std::cout<<x<<' ';pr(xs...);}
I_ int re(){int x=0,m=0,k;for(;;){mygc(k);if(k=='-'){m=1;break;}if('0'<=k&&k<='9'){x=k-'0';break;}}for(;;){mygc(k);if(k<'0'||'9'<k)break;x=x*10+k-'0';}return x;}
I_ void wr(int x,char c='\n'){int s=0,m=0;char b[32];if(x<0)m=1,x=-x;for(;x;x/=10)b[s++]=x%10;if(!s)b[s++]=0;if(m)mypc('-');for(;s--;)mypc(b[s]+'0');mypc(c);}
struct IoSetup {
  IoSetup(){
    std::ios::sync_with_stdio(0);
    std::cin.tie(0);
    std::cout.precision(10);
    std::cerr.precision(10);
  }
} iosetup;
// clang-format on
// }}}
using namespace std;
const int inf = 1001001001;
const ll infll = 1001001001001001001ll;
const int dd[] = {0, 1, 0, -1, 0};

const int MOD = TEN(4);

int memo[501][10][2][2][500];

struct ZigZagNumber {
  const string S;
  const int N;
  const int M;
  ZigZagNumber(const string& S, int M) : S(S), N(S.size()), M(M) {}
  int dfs(int i, int pre, bool high, bool tight, int tot) {
    if (i == N) { return tot == 0; }
    int& ret = memo[i][pre][high][tight][tot];
    if (ret != -1) return ret;

    int x = S[i] - '0';
    int l = 0, r = 10;
    if (high) {
      l = pre + 1;
    } else {
      r = pre;
    }
    if (tight) chmin(r, x + 1);

    ret = 0;
    rep(j, l, r) { ret += dfs(i + 1, j, !high, tight && j == x, (10 * tot + j) % M); }
    return ret %= MOD;
  }
  int solve() {
    memset(memo, -1, sizeof(memo));
    int ret = 0;
    rep(k, N) {
      int x = S[k] - '0';
      int l = 1, r = 10;
      if (k == 0) chmin(r, x + 1);

      rep(i, l, r) {
        bool tight = k == 0 && i == x;
        ret += dfs(k + 1, i, true, tight, i % M);
        if (k < N - 1) { ret += dfs(k + 1, i, false, tight, i % M); }
      }
      ret %= MOD;
    }
    return ret;
  }
};

string decr(string s) {
  rrep(i, s.size()) {
    if (s[i]-- != '0') break;
    s[i] = '9';
  }
  return s.substr(s.size() > 1 && s[0] == '0');
}

signed main() {
  auto A = decr(in<string>());
  auto B = in<string>();
  int M = in();

  pr((ZigZagNumber(B, M).solve() + MOD - ZigZagNumber(A, M).solve()) % MOD);

  return 0;
}