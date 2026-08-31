#include <bits/stdc++.h>
using namespace std;
int main() {
  int t;
  cin >> t;
  long long int l, r, d;
  while (t--) {
    cin >> l >> r >> d;
    if (d < l) {
      cout << d << endl;
    } else {
      long long int a = r / d + 1;
      cout << d * a << endl;
    }
  }
}
