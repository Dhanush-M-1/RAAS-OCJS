#include <bits/stdc++.h>
using namespace std;
const long long int MOD = 1000000007;
const long long BIG = 1446803456761533460LL;
const int Big = 336860180;
const long long int INF = LONG_LONG_MAX;
const vector<vector<long long int> > adj4({{0, 1}, {0, -1}, {1, 0}, {-1, 0}});
const vector<vector<long long int> > adj8(
    {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {-1, -1}, {1, -1}, {-1, 1}, {1, 1}});
long long int gcd(long long int a, long long int b) {
  return b == 0 ? a : gcd(b, a % b);
}
bool isprime(long long int n) {
  if (n == 2 || n == 3) return true;
  if (n < 2 || n % 2 == 0 || n % 3 == 0) return false;
  for (long long int i = 6; (i - 1) * (i - 1) <= n; i += 6) {
    if (n % (i - 1) == 0 || n % (i + 1) == 0) {
      return false;
    }
  }
  return true;
}
vector<bool> sprime;
void genPrime(long long int sz) {
  sprime = vector<bool>(sz, true);
  sprime[0] = false;
  sprime[1] = false;
  for (long long int i = (2); i < (sz); ++i) {
    if (sprime[i]) {
      for (long long int j = i * i; j < sz; j += i) {
        sprime[j] = false;
      }
    }
  }
}
long long int powMod(long long int a, long long int b, long long int mod) {
  long long int n = 1;
  long long int p = a;
  while (b > 0) {
    if (b % 2 == 1) {
      n *= p;
      n %= mod;
    }
    p *= p;
    p %= mod;
    b /= 2;
  }
  return n;
}
long long int modularInverse(long long int a, long long int mod) {
  return powMod(a, mod - 2, mod);
}
long long int binarysearch(long long int l, long long int r,
                           bool (*bsfunction)(long long int)) {
  while (r - l > 1) {
    long long int mid = (l + r) / 2;
    bool val = bsfunction(mid);
    if (val) {
      r = mid;
    } else {
      l = mid;
    }
  }
  return l;
}
stringstream sss;
const long long int maxn = 1000010;
vector<long long int> out[maxn];
vector<long long int> in[maxn];
long long int vis[maxn];
vector<long long int> p;
long long int k;
vector<long long int> stk;
long long int scc[maxn];
set<long long int> gg[maxn];
long long int islf[maxn];
long long int lf[maxn];
long long int dp[maxn];
void dfs(long long int step) {
  p.push_back(step);
  for (auto x : out[step]) {
    dfs(x);
  }
  p.pop_back();
  if (out[step].empty()) {
    islf[step] = 1;
    long long int up = max(0LL, (long long int)p.size() - k);
    out[step].push_back(p[up]);
    in[p[up]].push_back(step);
  }
}
void dfs2(long long int step) {
  for (auto x : out[step]) {
    if (vis[x] == 0) {
      vis[x] = 1;
      dfs2(x);
    }
  }
  stk.push_back(step);
}
void dfs3(long long int step) {
  for (auto x : in[step]) {
    if (vis[x] == 1) {
      vis[x] = 2;
      scc[x] = scc[step];
      dfs3(x);
    }
  }
}
void solve(long long int step) {
  if (dp[step] != -1) return;
  dp[step] = 0;
  for (auto x : gg[step]) {
    solve(x);
    dp[step] = max(dp[step], (dp[x]));
  }
  dp[step] += lf[step];
}
void MAIN() {
  long long int n;
  cin >> n;
  cin >> k;
  for (long long int i = 0; i < (n - 1); ++i) {
    long long int x;
    cin >> x;
    out[x - 1].push_back(i + 1);
    in[i + 1].push_back(x - 1);
  }
  vis[0] = 1;
  dfs(0);
  dfs2(0);
  long long int t = 0;
  for (long long int i = (n)-1; i >= 0; --i) {
    long long int x = stk[i];
    if (vis[x] == 1) {
      vis[x] = 2;
      scc[x] = t++;
      dfs3(x);
    }
  }
  for (long long int i = 0; i < (n); ++i) {
    for (auto x : out[i]) {
      gg[scc[i]].insert(scc[x]);
    }
    gg[scc[i]].erase(scc[i]);
    lf[scc[i]] += islf[i];
  }
  memset(dp, -1, sizeof dp);
  solve(scc[0]);
  cout << (dp[scc[0]]) << endl;
}
const long long int TESTCASEN = 1;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cout << fixed << setprecision(10);
  sss << R"(
8 2
1 1 2 3 4 5 5
7 1
1 1 3 3 4 4
    )";
  for (long long int i = 0; i < (TESTCASEN); ++i) {
    MAIN();
  }
  return 0;
}
