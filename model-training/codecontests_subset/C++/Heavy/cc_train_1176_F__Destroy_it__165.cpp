#include <bits/stdc++.h>
const long long md = 1e9 + 7;
const long long Inf = 1e9;
const long long Inf64 = 1e18;
const long long MaxN = 1e5 + 100;
const long long LogN = 20;
const long long MaxM = 5e5 + 10;
const double eps = 1e-3;
const int dx[8] = {1, -1, 2, 2, -1, 1, -2, -2};
const int dy[8] = {2, 2, 1, -1, -2, -2, 1, -1};
const int ddx[4] = {1, 1, -1, -1};
const int ddy[4] = {1, -1, 1, -1};
const double Pi = acos(-1);
using namespace std;
template <typename T>
istream &operator>>(istream &in, pair<T, T> &a) {
  in >> a.first >> a.second;
  return in;
}
template <typename T>
ostream &operator<<(ostream &out, pair<T, T> a) {
  out << a.first << ' ' << a.second;
  return out;
}
template <typename T>
istream &operator>>(istream &in, vector<T> &Mt) {
  for (T &a : Mt) in >> a;
  return in;
}
template <typename T>
ostream &operator<<(ostream &out, vector<T> Mt) {
  for (int i = 0; i < (int)Mt.size(); i++) {
    out << Mt[i];
    if (i != (int)Mt.size()) out << ' ';
  }
  out << '\n';
  return out;
}
inline long long Mod(long long &a, long long m = md) {
  while (a >= m) a -= m;
  return a;
}
inline long long gcd(long long a, long long b) {
  while (a) {
    b %= a;
    swap(a, b);
  }
  return b;
}
inline long long gcdex(long long a, long long mod = md) {
  long long g = mod, r = a, x = 0, y = 1;
  while (r != 0) {
    long long q = g / r;
    g %= r;
    swap(g, r);
    x -= q * y;
    swap(x, y);
  }
  return x < 0 ? x + mod : x;
}
inline long long binpow(long long a, long long n, long long m = md) {
  long long res = 1;
  while (n) {
    if (n & 1) {
      res *= a;
      res %= m;
    }
    a *= a;
    a %= m;
    n >>= 1;
  }
  return res % md;
}
signed main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  {
    long long N, a, b, x, t, c, d, dmax, id;
    cin >> N;
    vector<vector<tuple<long long, long long, long long>>> Mt(N + 1);
    for (int i = 1; i <= N; i++) {
      cin >> x;
      vector<vector<long long>> Kt(4);
      for (int j = 0; j < x; j++) {
        cin >> c >> d;
        Kt[c].push_back(d);
      }
      for (int j = 1; j <= 3; j++) sort(Kt[j].rbegin(), Kt[j].rend());
      Mt[i].push_back({0, 0, 0});
      if (Kt[1].size() > 0) Mt[i].push_back({1, Kt[1][0], Kt[1][0]});
      if (Kt[2].size() > 0) Mt[i].push_back({1, Kt[2][0], Kt[2][0]});
      if (Kt[3].size() > 0) Mt[i].push_back({1, Kt[3][0], Kt[3][0]});
      if ((Kt[1].size() > 0) && (Kt[2].size() > 0))
        Mt[i].push_back({2, Kt[1][0] + Kt[2][0], max(Kt[1][0], Kt[2][0])});
      if (Kt[1].size() > 1)
        Mt[i].push_back({2, Kt[1][0] + Kt[1][1], max(Kt[1][0], Kt[1][1])});
      if (Kt[1].size() > 2)
        Mt[i].push_back({3, Kt[1][0] + Kt[1][1] + Kt[1][2],
                         max(Kt[1][0], max(Kt[1][1], Kt[1][2]))});
    }
    vector<vector<long long>> dp(N + 1, vector<long long>(10, -Inf64));
    dp[0][0] = 0;
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < 10; j++) {
        for (auto p : Mt[i + 1]) {
          tie(c, d, dmax) = p;
          x = dp[i][j] + d;
          if (j + c >= 10) x += dmax;
          id = (j + c) % 10;
          dp[i + 1][id] = max(dp[i + 1][id], x);
        }
      }
    }
    long long Ans = 0;
    for (int i = 0; i < 10; i++) Ans = max(Ans, dp[N][i]);
    cout << Ans << "\n";
  }
END:
  return 0;
}
