#include <bits/stdc++.h>
using namespace std;
int main() {
  iostream::sync_with_stdio(false);
  int q;
  cin >> q;
  for (int i = 0; i < q; ++i) {
    int l, r, d;
    cin >> l;
    cin >> r;
    cin >> d;
    if (l > d) {
      cout << d << "\n";
    } else {
      int t = r / d;
      t = (t + 1) * d;
      cout << t << "\n";
    }
  }
  return 0;
}
