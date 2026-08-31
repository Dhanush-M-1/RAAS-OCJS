#include <bits/stdc++.h>
using namespace std;
int main() {
  int t = 1;
  cin >> t;
  while (t--) {
    long long int l, r, d;
    cin >> l >> r >> d;
    if (l > d)
      cout << d;
    else if (l <= d) {
      cout << ((r / d) + 1) * d;
    }
    cout << "\n";
  }
  return 0;
}
