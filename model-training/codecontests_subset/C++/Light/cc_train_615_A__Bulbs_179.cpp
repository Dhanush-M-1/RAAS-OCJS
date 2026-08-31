#include <bits/stdc++.h>
using namespace std;
long long a[1000001], n, m = INT_MIN, b[1000001], c, k1, c1, r, l, x,
                         m1 = INT_MAX, p1, p, k, t, tx1 = -1, ty1 = -1,
                         tx2 = -1, ty2 = -1, a1, b1, y, mid;
bool u[1000001];
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  cin >> n >> m;
  for (int i = 1; i <= n; i++) {
    cin >> x;
    for (int j = 1; j <= x; j++) {
      cin >> y;
      u[y]++;
    }
  }
  for (int i = 1; i <= m; i++) {
    if (u[i] == 0) return cout << "NO", 0;
  }
  cout << "YES";
}
