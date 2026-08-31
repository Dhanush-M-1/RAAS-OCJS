#include <bits/stdc++.h>
using namespace std;
long long Min(long long a, long long b) { return (a < b) ? a : b; }
long long Max(long long a, long long b) { return (a < b) ? b : a; }
long long gcd(long long m, long long n) {
  if (n == 0) return m;
  return gcd(n, m % n);
}
long long lcm(long long m, long long n) { return m * n / gcd(m, n); }
long long dx[6] = {-1, 0, 1, 0, 0, 0}, dy[6] = {0, 1, 0, -1, 0, 0},
          dz[6] = {0, 0, 0, 0, 1, -1};
void solve() {
  long long n;
  cin >> n;
  vector<string> v(n);
  for (int i = 0; i < n; i++) {
    cin >> v[i];
  }
  char c[5] = {v[0][1], v[1][0], v[n - 1][n - 2], v[n - 2][n - 1]};
  char ch[2][5] = {"0011", "1100"};
  for (int i = 0; i < 2; i++) {
    long long cnt = 0;
    for (int j = 0; j < 4; j++) {
      if (c[j] != ch[i][j]) cnt++;
    }
    if (cnt <= 2) {
      vector<pair<long long, long long> > a;
      for (int j = 0; j < 4; j++) {
        if (c[j] != ch[i][j]) {
          if (j == 0)
            a.push_back({1, 2});
          else if (j == 1)
            a.push_back({2, 1});
          else if (j == 2)
            a.push_back({n, n - 1});
          else
            a.push_back({n - 1, n});
        }
      }
      cout << a.size() << "\n";
      for (auto t : a) cout << t.first << " " << t.second << "\n";
      return;
    }
  }
}
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  ;
  long long tc = 1;
  cin >> tc;
  while (tc--) solve();
  exit(0);
}
