#include <bits/stdc++.h>
using namespace std;
int i, k, j, x, n, m, a[1000];
int main() {
  cin >> n >> m;
  for (i = 0; i < n; i++) {
    cin >> x;
    for (j = 0; j < x; j++) {
      cin >> k;
      a[k] = 1;
    }
  }
  for (i = 1; i <= m; i++)
    if (a[i] == 0) return cout << "NO", 0;
  cout << "YES";
}
