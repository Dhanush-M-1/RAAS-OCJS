#include <bits/stdc++.h>
using namespace std;
long n, m, x, y, a[10000] = {0};
int main() {
  cin >> n >> m;
  for (long i = 0; i < n; i++) {
    cin >> x;
    for (long i = 0; i < x; i++) {
      cin >> y;
      a[y - 1] = 1;
    }
  }
  bool KT = true;
  for (long i = 0; i < m; i++)
    if (!a[i]) {
      KT = false;
    }
  if (KT == true)
    cout << "YES";
  else
    cout << "NO";
}
