#include <bits/stdc++.h>
using namespace std;
int main() {
  ios::sync_with_stdio(false);
  int n;
  cin >> n;
  int a[n];
  for (int i = 0; i < n; i++) {
    cin >> a[i];
  }
  int l = 0, r = 1e6;
  while (r - l > 1) {
    int m = (r + l) / 2;
    bool flag = true;
    for (int i = 0; i < n; i++) {
      if (!(a[i] <= 1 + m || a[i] >= 1e6 - m)) {
        flag = false;
        break;
      }
    }
    if (flag)
      r = m;
    else
      l = m;
  }
  cout << r;
}
