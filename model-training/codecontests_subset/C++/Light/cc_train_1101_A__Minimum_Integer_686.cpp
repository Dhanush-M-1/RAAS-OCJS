#include <bits/stdc++.h>
using namespace std;
int main() {
  int q;
  cin >> q;
  int i;
  for (i = 0; i < q; i++) {
    int l, r, d;
    cin >> l >> r >> d;
    long long int x;
    if (d < l)
      x = d;
    else {
      int a = r % d;
      x = (d - a) + r;
    }
    cout << x << endl;
  }
}
