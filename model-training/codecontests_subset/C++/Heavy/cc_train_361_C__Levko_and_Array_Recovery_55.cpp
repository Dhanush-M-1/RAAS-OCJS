#include <bits/stdc++.h>
using namespace std;
int n, m;
int mx[5010];
int sum[5010];
int arr[5010];
int q[5010][4];
int main() {
  cin >> n >> m;
  for (int i = 0; i < n; i++) mx[i] = 1000000000;
  for (int i = 0; i < m; i++) {
    for (int j = 0; j < 4; j++) cin >> q[i][j];
    q[i][1]--, q[i][2]--;
    if (q[i][0] == 1)
      for (int j = q[i][1]; j <= q[i][2]; j++) sum[j] += q[i][3];
    else
      for (int j = q[i][1]; j <= q[i][2]; j++)
        mx[j] = min(mx[j], q[i][3] - sum[j]);
  }
  for (int i = 0; i < n; i++) arr[i] = mx[i];
  bool can = true;
  for (int i = 0; i < m; i++) {
    if (q[i][0] == 1)
      for (int j = q[i][1]; j <= q[i][2]; j++) arr[j] += q[i][3];
    else {
      int val = arr[q[i][1]];
      for (int j = q[i][1]; j <= q[i][2]; j++) val = max(val, arr[j]);
      if (val != q[i][3]) can = false;
    }
  }
  if (can) {
    cout << "YES" << endl;
    for (int i = 0; i < n; i++) cout << mx[i] << ' ';
    cout << endl;
  } else
    cout << "NO" << endl;
  return 0;
}
