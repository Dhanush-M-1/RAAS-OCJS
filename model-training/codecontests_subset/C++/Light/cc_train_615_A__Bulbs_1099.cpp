#include <bits/stdc++.h>
using namespace std;
int m, n, x, y;
bool was[101];
int main() {
  cin >> n >> m;
  for (int i = 0; i < n; i++) {
    cin >> x;
    for (int j = 0; j < x; j++) {
      cin >> y;
      was[y] = true;
    }
  }
  for (int i = 1; i <= m; i++) {
    if (!was[i]) {
      cout << "NO";
      exit(0);
    }
  }
  cout << "YES";
}
