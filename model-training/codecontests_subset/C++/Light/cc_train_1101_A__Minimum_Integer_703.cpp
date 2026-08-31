#include <bits/stdc++.h>
using namespace std;
const long long inf = 1e16;
const long long MAXN = 1e6;
long long n, i, x, l, r;
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cin >> n;
  for (i = 0; i < n; i++) {
    cin >> l >> r >> x;
    if (x < l)
      cout << x << endl;
    else {
      cout << r / x * x + x << endl;
    }
  }
  return 0;
}
