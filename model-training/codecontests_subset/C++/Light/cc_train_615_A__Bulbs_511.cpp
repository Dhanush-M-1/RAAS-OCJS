#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, m;
  cin >> m >> n;
  vector<int> v(n);
  while (m--) {
    int k;
    cin >> k;
    vector<int> vv(k);
    for (auto &y : vv) {
      cin >> y;
      v[y - 1]++;
    }
  }
  for (auto &x : v) {
    if (x <= 0) {
      cout << "NO" << endl;
      return 0;
    }
  }
  cout << "YES" << endl;
}
