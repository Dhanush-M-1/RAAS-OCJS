#include "bits/stdc++.h"
using namespace std;

#define ll long long
#define ld long double
#define F first
#define S second
#define all(v) v.begin(),v.end()
#define sz(v) (int)v.size()
#define precision cout << fixed << setprecision(15);

const int inf = 1e9;
const long long INF = 1e18;
const int mod = 1e9 + 7;
const int bit32 = log2(inf) + 3;
const int bit64 = log2(INF) + 3;

mt19937_64 rng(chrono::steady_clock::now().time_since_epoch().count());
clock_t time_p = clock();

void ktj() {
  time_p = clock() - time_p;
  cerr << "Time elapsed : " << (float)(time_p)/CLOCKS_PER_SEC << "\n";
}

inline int add(int a, int b){
  a %= mod; b %= mod; 
  a += b; 
  if(a >= mod) a -= mod; 
  return a;
}

inline int sub(int a, int b){
  a %= mod; b %= mod; 
  a -= b; 
  if(a < 0) a += mod; 
  return a;
}

inline int mul(int a, int b){
  int64_t c = (int64_t)a * (int64_t)b;
  c %= mod;
  return (int)(c);
}

inline int power(int a, int b) {
  int res = 1;
  while (b > 0) {
    if (b & 1) {
      res = mul(res, a);
    }
    a = mul(a, a);
    b >>= 1;
  }
  return res;
}

inline int inv(int a) {
  a %= mod;
  if (a < 0) a += mod;
  int b = mod, u = 0, v = 1;
  while (a) {
    int t = b / a;
    b -= t * a; swap(a, b);
    u -= t * v; swap(u, v);
  }
  assert(b == 1);
  if (u < 0) u += mod;
  return u;
}

const int N = 2e5 + 5;
int dp[N];

void pre() {
  for (int i = 0; i < 9; i++)
    dp[i] = 2;
  dp[9] = 3;
  for (int i = 10; i < N; i++)
    dp[i] = add(dp[i - 9], dp[i - 10]);
}

void solve() {
  int n, m;
  cin >> n >> m;
  int len = 0;
  while (n) {
    int d = n % 10; n /= 10;
    if (d + m < 10)
      len = add(len, 1);
    else
      len = add(len, dp[m - (10 - d)]);
  }
  cout << len << '\n';
}

#define GOOGLE 0
#define MULTIPLE_TC 1

int32_t main() {

  ios_base::sync_with_stdio(false);
  cin.tie(NULL);cout.tie(NULL); 

  pre();

  int t = 1, T;

  if (MULTIPLE_TC)
    cin >> t;

  for (T = 1; T <= t; T++) {
    if (GOOGLE)
      cout << "Case #" << T << ": ";
    solve();
  }

  ktj();
}