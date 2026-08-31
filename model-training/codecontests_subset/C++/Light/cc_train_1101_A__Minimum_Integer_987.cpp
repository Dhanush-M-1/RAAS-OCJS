#include <bits/stdc++.h>
using namespace std;
int main() {
  int q;
  cin >> q;
  long long int l, r, d;
  for (int i = 0; i < q; i++) {
    cin >> l >> r >> d;
    if (d < l)
      cout << d << endl;
    else if (d > r)
      cout << d << endl;
    else
      cout << ((r / d) + 1) * d << endl;
  }
}
