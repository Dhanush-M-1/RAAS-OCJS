#include <bits/stdc++.h>
using namespace std;
long long INF = 1e6;
long long M = 1e9 + 7;
void solve() {
  long long n;
  cin >> n;
  vector<int> a(n), b(n - 1), c(n - 2);
  for (int i = 0; i < n; i++) cin >> a[i];
  for (int i = 0; i < n - 1; i++) cin >> b[i];
  for (int i = 0; i < n - 2; i++) cin >> c[i];
  sort((a).begin(), (a).end());
  sort((b).begin(), (b).end());
  sort((c).begin(), (c).end());
  long long x, y;
  bool f1 = true, f2 = true;
  for (int i = 0; i < n - 1; i++) {
    if (i < n - 2 && f2) {
      if (b[i] != c[i]) {
        y = b[i];
        f2 = false;
      }
    }
    if (a[i] != b[i] && f1) {
      x = a[i];
      f1 = false;
    }
  }
  if (f1) x = a[n - 1];
  if (f2) y = b[n - 2];
  cout << x << "\n" << y << "\n";
}
int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  long long t = 1;
  while (t--) solve();
  return 0;
}
