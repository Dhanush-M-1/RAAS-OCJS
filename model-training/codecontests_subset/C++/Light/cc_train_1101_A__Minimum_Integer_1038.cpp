#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  long long int q;
  cin >> q;
  while (q--) {
    long long int l, r, d;
    cin >> l >> r >> d;
    long long int i = 0;
    while (1) {
      if (l <= d) {
        cout << d * (r / d + 1) << '\n';
        break;
      } else {
        cout << d << '\n';
        break;
      }
    }
  }
  return 0;
}
