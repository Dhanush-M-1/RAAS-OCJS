#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, m, x, j;
  cin >> n >> m;
  bool b[m];
  for (int i = 0; i < m; i++) b[i] = false;
  for (int i = 0; i < n; i++) {
    cin >> x;
    while (x--) {
      cin >> j;
      b[j - 1] = true;
    }
  }
  for (bool t : b) {
    if (!t) {
      cout << "NO" << endl;
      return 0;
    }
  }
  cout << "YES" << endl;
  return 0;
}
