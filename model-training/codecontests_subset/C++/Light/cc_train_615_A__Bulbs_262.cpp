#include <bits/stdc++.h>
using namespace std;
long long a[105], x, y, m, n;
int main() {
  cin >> n >> m;
  for (int i = 1; i <= n; i++) {
    cin >> y;
    for (int i = 1; i <= y; i++) {
      cin >> x;
      a[x] = 1;
    }
  }
  for (int i = 1; i <= m; i++)
    if (a[i] != 1) {
      cout << "NO";
      return 0;
    }
  cout << "YES";
  return 0;
}
