#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  int q;
  cin >> q;
  while (q--) {
    long long int l, r, d;
    cin >> l >> r >> d;
    if (d < l) {
      cout << d << endl;
      continue;
    }
    int cnt = (r + d) / d;
    cout << cnt * d << endl;
  }
  return 0;
}
