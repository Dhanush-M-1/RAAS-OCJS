#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, m, t, i, c = 0, d = 0, j;
  cin >> n >> m;
  int b[m];
  for (i = 1; i <= m; i++) b[i] = i;
  while (n--) {
    cin >> t;
    int a[t];
    int i;
    for (i = 0; i < t; i++) cin >> a[i];
    for (i = 0; i < t; i++) {
      for (j = 1; j <= m; j++) {
        if (a[i] == b[j]) {
          ++c;
          b[j] = 0;
        }
      }
    }
  }
  if (c == m)
    cout << "YES" << endl;
  else
    cout << "NO" << endl;
}
