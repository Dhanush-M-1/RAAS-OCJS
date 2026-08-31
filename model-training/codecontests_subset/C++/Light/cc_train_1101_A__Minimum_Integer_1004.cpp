#include <bits/stdc++.h>
using namespace std;
int main() {
  long long n, l, r, d, s;
  cin >> n;
  for (int i = 0; i < n; i++) {
    cin >> l >> r >> d;
    s = d;
    if (s >= l && s <= r) {
      s += (r - r % d);
    }
    cout << s << endl;
  }
  return 0;
}
