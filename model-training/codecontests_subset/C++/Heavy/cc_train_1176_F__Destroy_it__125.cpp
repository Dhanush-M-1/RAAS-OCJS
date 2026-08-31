#include <bits/stdc++.h>
using namespace std;
const int MOD = 10;
string to_string(string s) { return '"' + s + '"'; }
string to_string(char s) { return string(1, s); }
string to_string(const char *s) { return to_string((string)s); }
string to_string(bool b) { return (b ? "true" : "false"); }
template <typename A>
string to_string(A);
template <typename A, typename B>
string to_string(pair<A, B> p) {
  return "(" + to_string(p.first) + ", " + to_string(p.second) + ")";
}
template <typename A>
string to_string(A v) {
  bool f = 1;
  string r = "{";
  for (const auto &x : v) {
    if (!f) r += ", ";
    f = 0;
    r += to_string(x);
  }
  return r + "}";
}
void debug_out() { cout << endl; }
template <typename Head, typename... Tail>
void debug_out(Head H, Tail... T) {
  cout << " " << to_string(H);
  debug_out(T...);
}
inline long long add(long long a, long long b) {
  a += b;
  if (a >= MOD) a -= MOD;
  return a;
}
inline long long sub(long long a, long long b) {
  a -= b;
  if (a < 0) a += MOD;
  return a;
}
inline long long mul(long long a, long long b) {
  return (long long)((long long)a * b % MOD);
}
inline long long binpow(long long a, long long b) {
  long long res = 1;
  while (b > 0) {
    if (b & 1) res = mul(res, a);
    a = mul(a, a);
    b /= 2;
  }
  return res;
}
inline long long inv(long long a) { return binpow(a, MOD - 2); }
long long gcd(long long a, long long b, long long &x, long long &y) {
  if (a == 0) {
    x = 0, y = 1;
    return b;
  }
  long long x1, y1;
  long long d = gcd(b % a, a, x1, y1);
  x = y1 - (b / a) * x1;
  y = x1;
  return d;
}
const long long N = 2e5 + 5, INF = 1e16;
long long n, dp[N][10], two[N], three[N];
vector<long long> one[N];
long long find(long long id, long long d) {
  if (id == 0) return (d == 0) ? 0 : -INF;
  if (dp[id][d] != -1) return dp[id][d];
  long long val;
  dp[id][d] = find(id - 1, d);
  if (three[id] != 0) {
    val = three[id];
    if (d == 0) val += three[id];
    dp[id][d] = max(dp[id][d], val + find(id - 1, sub(d, 1)));
  }
  if (two[id] != 0) {
    if (!one[id].empty()) {
      val = one[id][0] + two[id];
      if (d == 0 || d == 1) val += max(one[id][0], two[id]);
      dp[id][d] = max(dp[id][d], val + find(id - 1, sub(d, 2)));
    }
    val = two[id];
    if (d == 0) val += two[id];
    dp[id][d] = max(dp[id][d], val + find(id - 1, sub(d, 1)));
  }
  if (!one[id].empty()) {
    val = 0;
    for (long long j = 0; j < one[id].size() && j < 3; ++j) {
      if (d == j) val += one[id][0];
      val += one[id][j];
      dp[id][d] = max(dp[id][d], val + find(id - 1, sub(d, j + 1)));
    }
  }
  return dp[id][d];
}
int32_t main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  cin >> n;
  memset(dp, -1, sizeof dp);
  for (long long i = 1; i <= n; ++i) {
    long long k;
    cin >> k;
    vector<long long> vec;
    for (long long j = 1; j <= k; ++j) {
      long long c, d;
      cin >> c >> d;
      if (c == 2)
        two[i] = max(two[i], d);
      else if (c == 3)
        three[i] = max(three[i], d);
      else
        one[i].push_back(d);
    }
    sort((one[i]).begin(), (one[i]).end(), greater<long long>());
  }
  long long ans = 0;
  for (long long i = 0; i < 10; ++i) ans = max(ans, find(n, i));
  cout << ans << "\n";
  return 0;
}
