#include <bits/stdc++.h>
using namespace std;
long long int s = 0, sh = 0, d, f = 0, p = 0, b = 0, m, a, t, c = 2, n,
              ans = 9999, r, o;
bool e;
int x[1001], i[110];
int main() {
  cin >> n >> m;
  for (int q = 0; q < n; q++) {
    cin >> x[q];
  }
  for (int r = 0; r < n; r++) {
    if (m % x[r] == 0) {
      a = (m / x[r]);
      ans = min(ans, a);
    }
  }
  cout << ans;
  return 0;
}
