#include <bits/stdc++.h>
using namespace std;
int main() {
  long long int t, n, m, k;
  cin >> n;
  vector<int> v[n + 1];
  vector<long long int> s;
  for (int i = 0; i < n; i++) {
    cin >> t;
    v[n].push_back(t);
    s.push_back(t);
  }
  sort(s.begin(), s.end());
  int l = n - 1, x = 0, y;
  while (l > 0) {
    for (int i = v[l + 1].size() - 1; i >= 0; i--) {
      if (v[l + 1][i] == s[x]) {
        y = i;
        break;
      }
    }
    for (int i = 0; i < v[l + 1].size(); i++) {
      if (i == y) continue;
      v[l].push_back(v[l + 1][i]);
    }
    x++;
    l--;
  }
  cin >> m;
  for (int i = 0; i < m; i++) {
    cin >> x >> y;
    cout << v[x][y - 1] << endl;
  }
}
