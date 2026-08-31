#include <bits/stdc++.h>
using namespace std;
const double pi = acos(-1.0);
const double eps = 1e-11;
void fastIO() {
  std::ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
}
int main() {
  fastIO();
  int n, a;
  cin >> n;
  int tot = 0;
  int mx = 0;
  for (int i = 0; i < n; i++) {
    cin >> a;
    tot += a;
    mx = max(mx, a);
  }
  double cond = (2.0 * tot) / n;
  if (cond < mx) {
    cout << mx << endl;
  } else {
    cout << ceil(cond + .00001) << endl;
  }
  return 0;
}
