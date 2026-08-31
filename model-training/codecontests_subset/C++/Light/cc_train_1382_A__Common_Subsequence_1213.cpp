#include <bits/stdc++.h>
using namespace std;
long long t, n, i, j, k, a, b, c, m, l, r, p, q, s;
void dihan() {
  cin >> n >> m;
  vector<long long> x(n);
  for (auto &i : x) cin >> i;
  vector<long long> y(m);
  for (auto &i : y) cin >> i;
  vector<long long> z(1001);
  for (i = 0; i < n; i++) z[x[i]] = 1;
  for (i = 0; i < m; i++)
    if (z[y[i]] == 1) break;
  (i < m) ? cout << "YES" << endl
                 << 1 << " " << y[i] << endl
          : cout << "NO" << endl;
}
int main() {
  ios::sync_with_stdio(0);
  cin.tie(nullptr);
  cin >> t;
  while (t--) dihan();
}
