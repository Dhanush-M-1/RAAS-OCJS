#include <bits/stdc++.h>
using namespace std;
const int N = 100010;
int main() {
  int n, m;
  cin >> n >> m;
  vector<bool> v(m + 1, false);
  for (int i = 0; i < n; i++) {
    int x;
    cin >> x;
    while (x--) {
      int y;
      cin >> y;
      v[y] = true;
    }
  }
  bool ok = true;
  for (int i = 1; i <= m; i++)
    if (!v[i]) ok = false;
  puts(ok ? "YES" : "NO");
}
