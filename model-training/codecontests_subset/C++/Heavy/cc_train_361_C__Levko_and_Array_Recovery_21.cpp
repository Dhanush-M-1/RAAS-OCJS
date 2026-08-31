#include <bits/stdc++.h>
using namespace std;
int b[5005];
int diff[5005];
int l[5005];
int t[5005];
int mex[5005];
int r[5005];
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  int n, q;
  cin >> n >> q;
  for (int i = 1; i <= n; i += 1) {
    b[i] = 1e9;
  }
  for (int i = 1; i <= q; i += 1) {
    cin >> t[i] >> l[i] >> r[i] >> mex[i];
    for (int j = l[i]; j <= r[i]; j += 1) {
      if (t[i] == 1) {
        diff[j] += mex[i];
      } else {
        b[j] = min(b[j], mex[i] - diff[j]);
      }
    }
  }
  for (int i = 1; i <= n; i += 1) {
    diff[i] = 0;
  }
  for (int i = 1; i <= q; i++) {
    int mn = -1e9;
    for (int j = l[i]; j <= r[i]; j++) {
      if (t[i] == 1) {
        diff[j] += mex[i];
      } else {
        mn = max(mn, diff[j] + b[j]);
      }
    }
    if (t[i] == 2 && mn != mex[i]) {
      printf("NO");
      return 0;
    }
  }
  cout << "YES" << endl;
  for (int i = 1; i <= n; i += 1) {
    cout << b[i] << " ";
  }
  cout << endl;
  return 0;
}
