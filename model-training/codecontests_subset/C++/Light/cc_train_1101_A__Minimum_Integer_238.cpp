#include <bits/stdc++.h>
using namespace std;
const long long N = 1e9;
int main() {
  ios_base::sync_with_stdio(false), cin.tie(0), cout.tie(0);
  long long n, c = 0, j, m = 0;
  cin >> n;
  for (long long i = 1; i <= n; i++) {
    long long l, r, d;
    cin >> l >> r >> d;
    c = d;
    m = d;
    if (d > r || d < l) {
      cout << d << '\n';
    } else {
      j = r / d;
      if (r % d != 0) {
        j++;
      }
      c = d * j;
      if (c == r) {
        c += d;
      }
      cout << c << '\n';
    }
  }
  return 0;
}
