#include <bits/stdc++.h>
using namespace std;
int main() {
  int q, i, l[500], r[500], d[500], j;
  cin >> q;
  for (i = 0; i < q; i++) {
    cin >> l[i] >> r[i] >> d[i];
    if (d[i] < l[i] || d[i] > r[i]) {
      cout << d[i] << endl;
    } else {
      j = ((r[i] / d[i]) + 1) * d[i];
      cout << j << endl;
    }
  }
  return 0;
}
