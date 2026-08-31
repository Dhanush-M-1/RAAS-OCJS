#include <bits/stdc++.h>
using namespace std;
int main() {
  int a[10001], i, j, k, p, n, m;
  cin >> n >> m;
  int c = 0;
  for (int t = 1; t <= n; t++) {
    cin >> p;
    for (i = 0; i < p; i++) {
      cin >> a[c];
      c++;
    }
  }
  sort(a, a + c);
  k = 1;
  for (i = 0; i < c; i++) {
    if (a[i] == k) {
      k++;
    }
  }
  if (k - 1 == m)
    cout << "YES\n";
  else
    cout << "NO\n";
  return 0;
}
