#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, m;
  cin >> n >> m;
  vector<bool> ans(m + 1, false);
  for (int l, i = 1; i <= n; i++) {
    cin >> l;
    for (int k, j = 1; j <= l; j++) {
      cin >> k;
      ans[k] = true;
    }
  }
  for (int i = 1; i <= m; i++) {
    if (ans[i] == false) {
      cout << "NO";
      return 0;
    }
  }
  cout << "YES";
  return 0;
}
