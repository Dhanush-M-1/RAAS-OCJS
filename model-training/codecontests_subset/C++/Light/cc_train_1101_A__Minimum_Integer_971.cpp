#include <bits/stdc++.h>
using namespace std;
int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  int t;
  cin >> t;
  while (t--) {
    long long int l, r, d;
    cin >> l >> r >> d;
    long long int curr = r;
    if (l > d)
      curr = d;
    else if (r >= d) {
      int k = (curr + d - 1) / d;
      curr = d * k;
      if (curr == r) curr += d;
    } else if (d > r)
      curr = d;
    cout << curr << endl;
  }
}
