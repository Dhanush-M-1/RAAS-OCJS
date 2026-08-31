#include <bits/stdc++.h>
using namespace std;
int a[1001];
inline int cmp(int u, int v) { return u > v; }
int main() {
  ios::sync_with_stdio(false);
  int n, m;
  cin >> n >> m;
  for (int i = 1; i <= n; i++) {
    cin >> a[i];
  }
  sort(a + 1, a + 1 + n, cmp);
  for (int i = 1; i <= n; i++) {
    if (m % a[i] == 0) {
      cout << m / a[i] << endl;
      return 0;
    }
  }
  return 0;
}
