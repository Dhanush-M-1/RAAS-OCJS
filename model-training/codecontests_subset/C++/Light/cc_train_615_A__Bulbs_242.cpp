#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, m, x, y, a[1000] = {}, cnt = 0;
  cin >> n >> m;
  for (int i = 0; i < n; i++) {
    cin >> x;
    for (int j = 0; j < x; j++) {
      cin >> y;
      if (!a[y]) {
        cnt++;
        a[y] = 1;
      }
    }
  }
  if (cnt == m)
    cout << "YES\n";
  else
    cout << "NO\n";
  return 0;
}
