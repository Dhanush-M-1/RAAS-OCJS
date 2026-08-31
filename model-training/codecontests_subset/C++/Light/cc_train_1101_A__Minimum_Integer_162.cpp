#include <bits/stdc++.h>
using namespace std;
const int mod = 1000000007;
const int N = 200005;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  int q;
  cin >> q;
  for (int i = 0; i < q; i++) {
    int l, r, d;
    cin >> l >> r >> d;
    if (d < l)
      cout << d << "\n";
    else if (r % d == 0)
      cout << r + d << "\n";
    else
      cout << (r / d + 1) * d << "\n";
  }
  return 0;
}
