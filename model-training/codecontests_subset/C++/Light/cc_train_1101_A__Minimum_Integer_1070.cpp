#include <bits/stdc++.h>
using namespace std;
int main() {
  int q;
  cin >> q;
  int l[500], r[500], d[500], ans[500];
  for (int i = 0; i < q; i++) {
    cin >> l[i] >> r[i] >> d[i];
    int quo;
    if (d[i] < l[i]) {
      ans[i] = d[i];
    } else {
      quo = int(r[i] / d[i]);
      ans[i] = d[i] * (quo + 1);
    }
  }
  for (int i = 0; i < q; i++) {
    cout << ans[i] << endl;
  }
  return 0;
}
