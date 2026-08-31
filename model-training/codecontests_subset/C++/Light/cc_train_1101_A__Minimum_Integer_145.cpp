#include <bits/stdc++.h>
using namespace std;
int main() {
  int t;
  cin >> t;
  while (t--) {
    long long l, r, d;
    cin >> l >> r >> d;
    long long q = r / d;
    long long ans = d * (q + 1);
    if (d * 1 < l) {
      ans = d;
    }
    cout << ans << endl;
  }
  return 0;
}
