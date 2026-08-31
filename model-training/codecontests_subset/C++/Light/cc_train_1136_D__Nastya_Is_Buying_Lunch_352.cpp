#include <bits/stdc++.h>
using namespace std;
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  long long n, m;
  cin >> n >> m;
  vector<long long> a(n), r(n + 1), f(n + 1);
  for (long long i = 0; i < n; i++) cin >> a[i];
  vector<vector<long long>> w(n + 1);
  for (long long i = 0; i < m; i++) {
    long long g, q;
    cin >> g >> q;
    w[q].push_back(g);
    if (q == a.back()) f[g] = 1;
  }
  long long kf = 0, knf = 0;
  for (long long i = n - 2; i >= 0; i--) {
    if (f[a[i]] && r[a[i]] == knf)
      kf++;
    else {
      for (long long g : w[a[i]]) r[g]++;
      knf++;
    }
  }
  cout << (kf) << "\n";
  return 0;
}
