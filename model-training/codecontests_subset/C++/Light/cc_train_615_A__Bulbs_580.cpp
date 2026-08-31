#include <bits/stdc++.h>
using namespace std;
int main() {
  int m, n;
  bool reachable_bulb[102] = {0};
  cin >> n >> m;
  for (int i = 0; i < n; i++) {
    int x;
    cin >> x;
    for (int j = 0; j < x; j++) {
      int k;
      cin >> k;
      reachable_bulb[k - 1] = 1;
    }
  }
  bool flag = true;
  for (int i = 0; i < m; i++) {
    if (reachable_bulb[i] == 0) {
      flag = false;
      break;
    }
  }
  if (flag)
    cout << "YES";
  else
    cout << "NO";
  return 0;
}
