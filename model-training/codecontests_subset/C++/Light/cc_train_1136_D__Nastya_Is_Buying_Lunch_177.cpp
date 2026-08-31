#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, m;
  int x, y, s = 0, k = 1;
  cin >> n >> m;
  vector<vector<int>> ma(n + 1);
  vector<int> a(n, 0), b(n + 1, 0), c(n + 1, 0);
  for (int i = 0; i < n; i++) {
    cin >> a[i];
    c[a[i]] = i;
  }
  for (int i = 0; i < m; i++) {
    cin >> x >> y;
    ma[y].push_back(x);
    if (c[x] < c[y]) b[x]++;
  }
  for (int i = n - 2; i >= 0; i--) {
    if (b[a[i]] == k) {
      s++;
      for (int j = 0; j < ma[a[i]].size(); j++) b[ma[a[i]][j]]--;
    } else
      k++;
  }
  cout << s;
}
