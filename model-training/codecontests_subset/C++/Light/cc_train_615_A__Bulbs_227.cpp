#include <bits/stdc++.h>
using namespace std;
int a[1005];
int main() {
  int n, m;
  cin >> n >> m;
  memset(a, 0, sizeof(a));
  int x, w;
  for (int i = 0; i < n; i++) {
    cin >> x;
    for (int i = 0; i < x; i++) {
      cin >> w;
      a[w] = 1;
    }
  }
  for (int i = 1; i <= m; i++) {
    if (a[i] == 0) {
      cout << "NO" << endl;
      return 0;
    }
  }
  cout << "YES" << endl;
  return 0;
}
