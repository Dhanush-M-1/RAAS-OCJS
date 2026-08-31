#include <bits/stdc++.h>
using namespace std;
int main() {
  long long n, m, k, i, j, arr[5001][4], last = 0, res[5001], tt[5001];
  cin >> n >> m;
  for (i = 0; i < m; i++) {
    cin >> arr[i][0] >> arr[i][1] >> arr[i][2] >> arr[i][3];
    if (arr[i][0] == 2) last = i;
  }
  for (i = 1; i <= n; i++) res[i] = 1000000000;
  for (i = last; i >= 0; i--) {
    if (arr[i][0] == 2) {
      k = 0;
      for (j = arr[i][1]; j <= arr[i][2]; j++) {
        if (res[j] >= arr[i][3]) {
          k++;
          res[j] = arr[i][3];
        }
      }
      if (!k) {
        cout << "NO" << endl;
        return 0;
      }
    } else {
      for (j = arr[i][1]; j <= arr[i][2]; j++) {
        if (res[j] != 1000000000) res[j] -= arr[i][3];
      }
    }
  }
  for (j = 1; j <= n; j++) tt[j] = res[j];
  for (i = 0; i < m; i++) {
    if (arr[i][0] == 2) {
      k = -1000000000000LL;
      for (j = arr[i][1]; j <= arr[i][2]; j++) {
        if (tt[j] > k) k = tt[j];
      }
      if (k != arr[i][3]) {
        cout << "NO" << endl;
        return 0;
      }
    } else {
      for (j = arr[i][1]; j <= arr[i][2]; j++) {
        if (tt[j] != 1000000000) tt[j] += arr[i][3];
      }
    }
  }
  cout << "YES" << endl;
  for (j = 1; j < n; j++) cout << res[j] << " ";
  cout << res[j] << endl;
  return 0;
}
