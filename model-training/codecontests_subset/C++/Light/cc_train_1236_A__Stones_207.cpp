#include <bits/stdc++.h>
using namespace std;
int main() {
  long long a, b, c, q;
  cin >> q;
  while (q--) {
    cin >> a >> b >> c;
    long long p1 = c / 2;
    long long p2 = min(b, p1);
    long long p3 = max((b - p1) / 2, 0ll);
    long long res = min(p1, p2) * 2 + min(p1, p2) + min(p3, a) * 2 + min(a, p3);
    cout << res << endl;
  }
  return 0;
}
