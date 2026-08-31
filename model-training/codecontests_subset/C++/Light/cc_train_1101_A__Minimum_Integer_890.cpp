#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  int t;
  cin >> t;
  while (t--) {
    int l, r, d;
    cin >> l >> r >> d;
    if (d < l)
      cout << d << endl;
    else {
      cout << (r / d + 1) * d << endl;
    }
  }
}
