#include <bits/stdc++.h>
using namespace std;
void __print(int x) { cout << x; }
void __print(long x) { cout << x; }
void __print(long long x) { cout << x; }
void __print(unsigned x) { cout << x; }
void __print(unsigned long x) { cout << x; }
void __print(unsigned long long x) { cout << x; }
void __print(float x) { cout << x; }
void __print(double x) { cout << x; }
void __print(long double x) { cout << x; }
void __print(char x) { cout << '\'' << x << '\''; }
void __print(const char *x) { cout << '\"' << x << '\"'; }
void __print(const string &x) { cout << '\"' << x << '\"'; }
void __print(bool x) { cout << (x ? "true" : "false"); }
template <typename T, typename V>
void __print(const pair<T, V> &x) {
  cout << '{';
  __print(x.first);
  cout << ',';
  __print(x.second);
  cout << '}';
}
template <typename T>
void __print(const T &x) {
  int f = 0;
  cout << '{';
  for (auto &i : x) cout << (f++ ? "," : ""), __print(i);
  cout << "}";
}
void _print() { cout << "]\n"; }
template <typename T, typename... V>
void _print(T t, V... v) {
  __print(t);
  if (sizeof...(v)) cout << ", ";
  _print(v...);
}
long long mod = 1e9 + 7;
int main() {
  cin.sync_with_stdio(0);
  cin.tie(0);
  int T = 1;
  cin >> T;
  while (T--) {
    long long n, k;
    cin >> n >> k;
    vector<long long> a(n);
    vector<pair<long long, long long> > b(n);
    for (int i = 0; i < (n); i++) {
      b[i].second = i;
      cin >> a[i] >> b[i].first;
    }
    sort(b.begin(), b.end());
    long long dp[n + 1][k + 1];
    memset(dp, -1, sizeof(dp));
    dp[0][0] = 0;
    for (int i = (1); i <= (n); i++) {
      dp[i][0] = dp[i - 1][0] + (k - 1) * b[i - 1].first;
      for (int j = (1); j <= (k); j++) {
        if (dp[i - 1][j] != -1)
          dp[i][j] = dp[i - 1][j] + (k - 1) * b[i - 1].first;
        if (dp[i - 1][j - 1] != -1)
          dp[i][j] = max(dp[i][j], dp[i - 1][j - 1] + (j - 1) * b[i - 1].first +
                                       a[b[i - 1].second]);
      }
    }
    long long i = n, j = k;
    vector<int> final, vis(n + 1, 0);
    while (j > 0) {
      if (dp[i][j] ==
          dp[i - 1][j - 1] + (j - 1) * b[i - 1].first + a[b[i - 1].second]) {
        final.push_back(b[i - 1].second + 1);
        vis[b[i - 1].second + 1] = 1;
        j--;
      }
      i--;
    }
    cout << k + (n - k) * 2 << '\n';
    for (int i = 0; i < (k - 1); i++) cout << final[k - 1 - i] << " ";
    for (int i = (1); i <= (n); i++)
      if (!vis[i]) cout << i << " " << -i << " ";
    cout << final[0] << '\n';
  }
  return 0;
}
