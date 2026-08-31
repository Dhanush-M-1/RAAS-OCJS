#include <bits/stdc++.h>
using namespace std;
int main() {
  long long n;
  cin >> n;
  while (n--) {
    long long l, r, k;
    cin >> l >> r >> k;
    if (r - k <= r - l && k <= r) {
      cout << r + k - (r % k) << endl;
    } else {
      cout << k << endl;
    }
  }
  return 0;
}
