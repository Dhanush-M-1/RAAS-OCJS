#include <bits/stdc++.h>
using namespace std;
int main() {
  long long int l, r, i, t, d, p, k, x;
  double div;
  scanf("%lld", &(t));
  while (t--) {
    scanf("%lld", &(l));
    scanf("%lld", &(r));
    scanf("%lld", &(d));
    if (d < l)
      x = d;
    else {
      div = d;
      p = ceil((r + 1) / div);
      x = d * p;
    }
    cout << x << endl;
  }
  return 0;
}
