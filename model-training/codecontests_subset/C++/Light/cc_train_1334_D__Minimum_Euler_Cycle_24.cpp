#include <bits/stdc++.h>
using namespace std;
const int maxc = 1e5;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  int t;
  cin >> t;
  while (t--) {
    long long k = 0;
    long long n, l, r;
    cin >> n >> l >> r;
    for (long long i = 2 * (n - 1); i; k += i, i -= 2) {
      for (long long j = max(l, k + 1); j <= min(r, k + i); j++) {
        if (j % 2)
          cout << n - i / 2 << " ";
        else
          cout << n - i / 2 + (j - k) / 2 << " ";
      }
    }
    if (k + 1 == r) cout << 1;
    cout << endl;
  }
  return 0;
}
