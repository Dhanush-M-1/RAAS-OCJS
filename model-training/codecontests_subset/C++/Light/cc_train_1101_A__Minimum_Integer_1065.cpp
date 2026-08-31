#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  int t;
  cin >> t;
  while (t--) {
    long long l, r, d;
    cin >> l >> r >> d;
    if (d < l || d > r) {
      cout << d << endl;
    } else {
      int c = r / d;
      cout << d * (c + 1) << endl;
    }
  }
  return 0;
}
