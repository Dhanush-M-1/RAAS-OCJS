#include <bits/stdc++.h>
using namespace std;
int main() {
  int q;
  cin >> q;
  int l[501], r[501], d[501], ans[501];
  for (int i = 0; i < q; i++) {
    cin >> l[i] >> r[i] >> d[i];
    if (l[i] > d[i] || r[i] < d[i])
      ans[i] = d[i];
    else
      ans[i] = (r[i] / d[i] + 1) * d[i];
  }
  for (int i = 0; i < q; i++) cout << ans[i] << endl;
  return 0;
}
