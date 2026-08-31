#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  ;
  int t;
  cin >> t;
  while (t--) {
    long long l, r, d;
    cin >> l >> r >> d;
    if (d < l)
      cout << d << "\n";
    else {
      cout << ((r / d) + 1) * d << "\n";
    }
  }
  return 0;
}
