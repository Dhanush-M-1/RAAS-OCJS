#include <bits/stdc++.h>
using namespace std;
bool com(long long a, long long b) { return a < b; }
int main() {
  long long t;
  cin >> t;
  while (t--) {
    long long l, r, d;
    cin >> l >> r >> d;
    if (d < l)
      cout << d << "\n";
    else {
      if (r % d == 0)
        cout << r + d << "\n";
      else
        cout << r + d - (r % d) << "\n";
    }
  }
}
