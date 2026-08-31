#include <bits/stdc++.h>
using namespace std;
const long long inf = 998244353;
bool cmp(pair<int, pair<int, int>> a, pair<int, pair<int, int>> b) {
  if (a.first >= b.first) return false;
  return true;
}
int main() {
  long long n, i = 0, j, k, m, q, l, r = 0, w, x, y, z = 0;
  string t, s;
  cin >> n;
  vector<vector<long long>> a(n);
  for (int i = 0; i < int(n - 1); i++) {
    cin >> x >> y;
    a[x - 1].push_back(y);
    a[y - 1].push_back(x);
  }
  for (int i = 0; i < int(n); i++) {
    if (int(a[i].size()) == 2) z = 1;
  }
  if (z == 1)
    cout << "NO";
  else
    cout << "YES";
}
