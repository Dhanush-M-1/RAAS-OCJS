#include <bits/stdc++.h>
using namespace std;
vector<int> diff(5010, 0), b(5010, 1000000000), a(5010);
int inst[5010][4];
int main() {
  int n, m, i, j, k;
  cin >> n >> m;
  for (i = 0; i < m; i++) {
    int t, l, r, x;
    cin >> t >> l >> r >> x;
    l--;
    r--;
    inst[i][0] = t;
    inst[i][1] = l;
    inst[i][2] = r;
    inst[i][3] = x;
    if (t == 1) {
      for (j = l; j <= r; j++) {
        diff[j] += x;
      }
    } else {
      for (j = l; j <= r; j++) {
        b[j] = min(b[j], x - diff[j]);
      }
    }
  }
  int flag = 0;
  for (i = 0; i < n; i++) a[i] = b[i];
  for (i = 0; i < m; i++) {
    if (inst[i][0] == 1) {
      for (j = inst[i][1]; j <= inst[i][2]; j++) {
        b[j] += inst[i][3];
      }
    } else {
      int maxi = b[inst[i][1]];
      for (j = inst[i][1] + 1; j <= inst[i][2]; j++) {
        maxi = max(maxi, b[j]);
      }
      if (maxi != inst[i][3]) {
        flag = 1;
        break;
      }
    }
  }
  if (flag == 1) {
    cout << "NO" << endl;
    return 0;
  }
  cout << "YES" << endl;
  for (i = 0; i < n; i++) {
    cout << a[i] << " ";
  }
  cout << endl;
  return 0;
}
