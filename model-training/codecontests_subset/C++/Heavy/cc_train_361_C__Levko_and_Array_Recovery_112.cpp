#include <bits/stdc++.h>
using namespace std;
void printub(int ub[], int n) {
  for (int i = 0; i < n; ++i) {
    cout << (ub[i] < INT_MAX ? ub[i] : 0);
    if (i < n - 1) cout << " ";
  }
  cout << endl;
}
int main() {
  int n, m;
  cin >> n >> m;
  int ub[n];
  int d[n];
  int type2[m][3];
  int neededD[m][n];
  int n2 = 0;
  memset(d, 0, sizeof(d));
  memset(neededD, 0, sizeof(neededD));
  for (int i = 0; i < n; ++i) ub[i] = INT_MAX;
  for (int i = 0; i < m; ++i) {
    int c, l, r, v;
    cin >> c >> l >> r >> v;
    l--;
    r--;
    if (c == 1) {
      for (int j = l; j <= r; ++j) d[j] += v;
    } else {
      type2[n2][0] = l;
      type2[n2][1] = r;
      type2[n2][2] = v;
      for (int j = l; j <= r; ++j) {
        neededD[n2][j] = d[j];
        ub[j] = min(ub[j], v - d[j]);
      }
      n2++;
    }
  }
  bool pass = true;
  for (int i = 0; i < n2; ++i) {
    bool sat = false;
    for (int j = type2[i][0]; j <= type2[i][1]; ++j)
      sat = sat || (ub[j] == type2[i][2] - neededD[i][j]);
    if (!sat) pass = false;
  }
  if (!pass) {
    cout << "NO" << endl;
  } else {
    cout << "YES" << endl;
    printub(ub, n);
  }
  return 0;
}
