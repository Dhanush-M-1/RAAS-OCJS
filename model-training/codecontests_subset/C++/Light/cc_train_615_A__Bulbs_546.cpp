#include <bits/stdc++.h>
using namespace std;
bool ok[110];
int main() {
  int n, m;
  cin >> n >> m;
  int x, y;
  for (int i = 1; i <= n; i++) {
    cin >> x;
    for (int j = 1; j <= x; j++) {
      cin >> y;
      ok[y] = 1;
    }
  }
  for (int i = 1; i <= m; i++)
    if (ok[i] == 0) {
      cout << "NO";
      return 0;
    }
  cout << "YES";
  return 0;
}
