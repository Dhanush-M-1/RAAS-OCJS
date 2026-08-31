#include <bits/stdc++.h>
using namespace std;
bool a[200005];
int main() {
  int n, m;
  cin >> n >> m;
  for (int i = 0; i < n; ++i) {
    int x;
    cin >> x;
    for (int j = 0; j < x; ++j) {
      int y;
      cin >> y;
      a[y] = true;
    }
  }
  for (int i = 1; i <= m; ++i)
    if (!a[i]) {
      cout << "NO";
      return 0;
    }
  cout << "YES";
  return 0;
}
