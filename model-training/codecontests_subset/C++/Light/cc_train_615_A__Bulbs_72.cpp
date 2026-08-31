#include <bits/stdc++.h>
using namespace std;
long long a, b, c, d, e, g, f, h, i, j, k, l, m, n;
int x[101];
int y[101];
int main() {
  cin >> n >> m;
  for (i = 0; i < n; i++) {
    cin >> x[i];
    for (j = 0; j < x[i]; j++) {
      cin >> a;
      y[a - 1]++;
    }
  }
  for (i = 0; i < m; i++) {
    if (y[i] == 0) {
      cout << "NO";
      return 0;
    }
  }
  cout << "YES";
}
