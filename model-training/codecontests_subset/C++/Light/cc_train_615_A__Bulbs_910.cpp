#include <bits/stdc++.h>
using namespace std;
int a[1000];
int main() {
  int n, m;
  cin >> n >> m;
  for (int i = 0; i < n; i++) {
    int k, x;
    cin >> k;
    while (k--) {
      cin >> x;
      a[x] = 1;
    }
  }
  for (int i = 1; i <= m; i++) {
    if (!a[i]) return cout << "NO", 0;
  }
  return cout << "YES", 0;
}
