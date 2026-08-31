#include <bits/stdc++.h>
using namespace std;
int main() {
  long long int t;
  cin >> t;
  while (t--) {
    long long int l, r, d;
    cin >> l >> r >> d;
    if (d < l)
      cout << d << endl;
    else {
      long long int tmp1 = r / d;
      cout << (tmp1 + 1) * d << endl;
    }
  }
}
