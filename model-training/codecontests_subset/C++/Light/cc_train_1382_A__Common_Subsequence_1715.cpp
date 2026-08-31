#include <bits/stdc++.h>
using namespace std;
const int mx = 1e5 + 10;
const double PI = cos(-1.0);
map<int, int> a, b;
int n, m, t;
int main() {
  cin >> t;
  while (t--) {
    int x;
    cin >> n >> m;
    a.clear();
    b.clear();
    for (int i = 1; i <= n; i++) {
      cin >> x;
      a[x] = 1;
    }
    for (int i = 1; i <= m; i++) {
      cin >> x;
      b[x] = 1;
    }
    int f = 0;
    for (int i = 1; i <= 1000; i++) {
      if (a[i] && b[i]) {
        f = 1;
        printf("YES\n1 %d\n", i);
        break;
      }
    }
    if (f == 0) printf("NO\n");
  }
  return 0;
}
