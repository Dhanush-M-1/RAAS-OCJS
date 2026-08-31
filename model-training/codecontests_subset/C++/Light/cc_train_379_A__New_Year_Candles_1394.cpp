#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, m, ans = 0, du = 0;
  cin >> n >> m;
  ans = n;
  while (n > 0) {
    ans += (n / m);
    int nc = n / m;
    n -= m * (n / m);
    n += nc;
    if (nc == 0) break;
  }
  cout << ans << endl;
  return 0;
}
