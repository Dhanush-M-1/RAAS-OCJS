#include <bits/stdc++.h>
using namespace std;
int main() {
  long long int q, l, r, d, p;
  cin >> q;
  while (q--) {
    cin >> l >> r >> d;
    p = d < l ? d : (r / d + 1) * d;
    cout << p << '\n';
  }
}
