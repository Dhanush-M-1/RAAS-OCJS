#include <bits/stdc++.h>
using namespace std;
int main() {
  long long n;
  cin >> n;
  while (n--) {
    long long l, r, d;
    cin >> l >> r >> d;
    if (d < l)
      cout << d << endl;
    else {
      cout << (long long)(ceil(r / d) * d) + d << endl;
    }
  }
  return 0;
}
