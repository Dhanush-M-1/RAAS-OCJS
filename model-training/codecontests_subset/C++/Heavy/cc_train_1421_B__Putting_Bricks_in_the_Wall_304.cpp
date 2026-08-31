#include <bits/stdc++.h>
using namespace std;
const long long N = 205;
char a[N][N];
void Main() {
  long long n;
  cin >> n;
  for (long long i = 1; i <= n; i++)
    for (long long j = 1; j <= n; j++) {
      cin >> a[i][j];
    }
  vector<pair<long long, long long> > res;
  if (a[1][2] == a[2][1]) {
    char c = a[1][2];
    if (a[n - 1][n] == c) {
      res.push_back(pair<long long, long long>(n - 1, n));
    }
    if (a[n][n - 1] == c) {
      res.push_back(pair<long long, long long>(n, n - 1));
    }
    cout << res.size() << '\n';
    for (auto &i : res) cout << i.first << ' ' << i.second << '\n';
    return;
  }
  if (a[n - 1][n] == a[n][n - 1]) {
    char c = a[n - 1][n];
    if (a[1][2] == c) {
      res.push_back(pair<long long, long long>(1, 2));
    }
    if (a[2][1] == c) {
      res.push_back(pair<long long, long long>(2, 1));
    }
    cout << res.size() << '\n';
    for (auto &i : res) cout << i.first << ' ' << i.second << '\n';
    return;
  }
  char c = a[1][2];
  res.push_back(pair<long long, long long>(2, 1));
  if (a[n - 1][n] == c) {
    res.push_back(pair<long long, long long>(n - 1, n));
  }
  if (a[n][n - 1] == c) {
    res.push_back(pair<long long, long long>(n, n - 1));
  }
  cout << res.size() << '\n';
  for (auto &i : res) cout << i.first << ' ' << i.second << '\n';
}
signed main() {
  cin.tie(0)->sync_with_stdio(0);
  long long T = 1;
  cin >> T;
  while (T--) Main();
}
