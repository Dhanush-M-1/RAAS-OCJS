#include <bits/stdc++.h>
using namespace std;
int main() {
  int t;
  cin >> t;
  while (t--) {
    long long l, r, d;
    cin >> l >> r >> d;
    if (d < l) {
      cout << d << endl;
      continue;
    }
    long long result = r + d - (r % d);
    cout << result << endl;
  }
  return 0;
}
