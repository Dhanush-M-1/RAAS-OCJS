#include <bits/stdc++.h>
using namespace std;
long long n, a[10000000], i, g, m, ans, k, x, y[1000000];
int main() {
  cin >> n >> m;
  for (i = 1; i <= n; i++) {
    cin >> a[i];
    for (g = 1; g <= a[i]; g++) {
      cin >> x;
      y[x]++;
    }
  }
  for (i = 1; i <= m; i++) {
    if (y[i] == 0) {
      cout << "NO";
      return 0;
    }
  }
  cout << "YES";
}
