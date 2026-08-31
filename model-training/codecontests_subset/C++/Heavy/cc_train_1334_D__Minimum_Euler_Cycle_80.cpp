#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(false);
  long long q, n, i, j, sum, sum2, l, r, pos;
  cin >> q;
  while (q--) {
    cin >> n >> l >> r;
    sum = 1;
    for (i = 1; i <= n; i++) {
      sum2 = max((n - 1 - i), 0 * 1LL) + (n - i) + 1;
      if (sum + sum2 >= l) {
        pos = i;
        while (sum <= r && pos < n) {
          for (j = pos + 1; j <= n - 1; j++) {
            if (sum >= l && sum <= r) cout << pos << " ";
            sum++;
            if (sum >= l && sum <= r) cout << j << " ";
            sum++;
          }
          if (sum >= l && sum <= r) cout << pos << " ";
          sum++;
          if (sum >= l && sum <= r) cout << n << " ";
          sum++;
          pos++;
        }
        if (sum <= r) cout << 1 << " ";
        break;
      } else
        sum += sum2;
    }
    cout << '\n';
  }
  return 0;
}
