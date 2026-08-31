#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, m;
  cin >> n >> m;
  int a[m + 1];
  memset(a, 0, sizeof(a));
  for (int i = 0; i < n; i++) {
    int x;
    cin >> x;
    for (int j = 0; j < x; j++) {
      int y;
      cin >> y;
      a[y] = 1;
    }
  }
  for (int i = 1; i <= m; i++)
    if (a[i] == 0) {
      cout << "NO";
      return 0;
    }
  cout << "YES";
}
