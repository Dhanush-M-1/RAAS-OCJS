#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, m;
  cin >> n >> m;
  int a[200];
  for (int i = 1; i <= m; i++) a[i] = 0;
  for (int i = 1; i <= n; i++) {
    int t;
    cin >> t;
    for (int j = 1; j <= t; j++) {
      int x;
      cin >> x;
      a[x] = 1;
    }
  }
  int f = 0;
  for (int i = 1; i <= m; i++) {
    if (a[i] == 0) {
      f = 1;
      break;
    }
  }
  if (f == 0)
    cout << "YES" << endl;
  else
    cout << "NO" << endl;
}
