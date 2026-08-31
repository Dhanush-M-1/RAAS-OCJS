#include <bits/stdc++.h>
using namespace std;
int n, m, x, y, t[1000000];
int main() {
  cin >> n >> m;
  for (int i = 0; i < n; i++) {
    cin >> x;
    for (int j = 0; j < x; j++) {
      cin >> y;
      t[y] = 1;
    }
  }
  for (int i = 1; i <= m; i++) {
    if (t[i] == 0) {
      cout << "NO";
      return 0;
    }
  }
  cout << "YES";
}
