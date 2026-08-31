#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, i, j, k, k1, a[11][11];
  vector<int> c;
  cin >> n;
  for (i = 1; i < n; i++)
    for (j = 1; j < n; j++) {
      a[i][j] = 0;
      k = i * j;
      while (k >= n) {
        c.push_back(k % n);
        k /= n;
      }
      c.push_back(k);
      for (int x = c.size() - 1; x >= 0; x--) a[i][j] = a[i][j] * 10 + c[x];
      c.clear();
    }
  for (i = 1; i < n; i++) {
    for (j = 1; j < n; j++) cout << a[i][j] << ' ';
    cout << '\n';
  }
  return 0;
}
