#include <bits/stdc++.h>
using namespace std;
long long n, m, x, y, d[100005];
vector<long long> a[100005];
void solve() {
  cin >> n;
  m = n - 1;
  while (m--) {
    cin >> x >> y;
    a[x].push_back(y);
    a[y].push_back(x);
    d[x]++, d[y]++;
  }
  for (__typeof((n + 1)) i = (1); i < (n + 1); i++) {
    if (d[i] == 2) {
      cout << "NO"
           << "\n";
      return;
    };
  }
  {
    cout << "YES"
         << "\n";
    return;
  };
}
void prep() {}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  long long t = 1;
  prep();
  cout << fixed << setprecision(12);
  while (t--) solve();
  return 0;
}
