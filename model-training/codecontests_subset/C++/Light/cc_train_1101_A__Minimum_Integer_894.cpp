#include <bits/stdc++.h>
using namespace std;
int main() {
  int t;
  cin >> t;
  while (t--) {
    long long int l, r, d;
    cin >> l >> r >> d;
    long long int ls, rs;
    ls = d;
    if (ls < l) {
      printf("%d\n", ls);
      continue;
    }
    if (r % d == 0) {
      rs = d + r;
    } else {
      rs = d * (r / d + 1);
    }
    printf("%lld\n", rs);
  }
}
