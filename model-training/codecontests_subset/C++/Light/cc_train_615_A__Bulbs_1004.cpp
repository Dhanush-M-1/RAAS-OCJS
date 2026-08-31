#include <bits/stdc++.h>
using namespace std;
int n, m, a[105], b[1000], c, f[105];
int main() {
  cin >> n >> m;
  for (int i = 1; i <= n; i++) {
    cin >> a[i];
    for (int j = 1; j <= a[i]; j++) {
      cin >> b[j];
      f[b[j]]++;
    }
  }
  for (int i = 1; i <= m; i++) {
    if (f[i] > 0) {
      c++;
    }
  }
  if (c == m) {
    cout << "YES";
  } else {
    cout << "NO";
  }
  return 0;
}
