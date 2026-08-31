#include <bits/stdc++.h>
using namespace std;
long long int oo = numeric_limits<long long int>::max();
long long int MOD = 1e9 + 7;
long long int comp(long long int n, long long int i) {
  return 2 * 1LL * (n - i);
}
int main() {
  cin.sync_with_stdio(0);
  cin.tie(0);
  cin.exceptions(cin.failbit);
  int t;
  cin >> t;
  while (t--) {
    long long int n, l, r;
    cin >> n >> l >> r;
    long long int i = 1;
    long long int sm = comp(n, i);
    while (i <= n && sm < l) {
      i++;
      sm += comp(n, i);
    }
    long long int idx = sm - comp(n, i);
    for (; i <= n; i++) {
      for (long long int j = 0; j < comp(n, i); j++) {
        long long int nm;
        if (j % 2 == 0) {
          nm = i;
        } else {
          nm = (j / 2) + i + 1LL;
        }
        idx++;
        if (idx >= l && idx <= r) {
          cout << nm << " ";
        } else if (idx > r) {
          goto end;
        }
      }
    }
    idx++;
    if (idx <= r) cout << 1;
  end:
    cout << endl;
    continue;
  }
}
