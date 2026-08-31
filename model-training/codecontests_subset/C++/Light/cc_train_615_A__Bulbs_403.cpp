#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, m, cnt, x, sum = 0, t = 0;
  int tt[1000];
  cin >> n >> m;
  int a[1000];
  while (n--) {
    cnt = 0;
    cin >> x;
    for (int i = 0; i < x; i++) {
      cin >> a[i];
      t = a[i];
      tt[t] = 1;
    }
    for (t = 1; t <= m; t++) {
      if (tt[t] == 1) {
        cnt++;
      }
    }
  }
  if (cnt == m)
    cout << "YES" << endl;
  else
    cout << "NO" << endl;
  return 0;
}
