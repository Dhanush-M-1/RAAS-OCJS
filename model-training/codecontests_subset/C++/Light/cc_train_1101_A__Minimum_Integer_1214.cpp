#include <bits/stdc++.h>
using namespace std;
int main() {
  long long l, r, x, n;
  cin >> n;
  while (n--) {
    cin >> l >> r >> x;
    if (x < l)
      cout << x << endl;
    else
      cout << (r / x + 1) * x << endl;
  }
  return 0;
}
