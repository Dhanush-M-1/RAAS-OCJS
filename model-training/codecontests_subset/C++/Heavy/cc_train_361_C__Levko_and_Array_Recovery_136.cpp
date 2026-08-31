#include <bits/stdc++.h>
using namespace std;
int a[5002][4], n, k;
bool b[5002];
int c[5002], c1[5002];
int minn(int a, int b) {
  if (a < b)
    return a;
  else
    return b;
}
void cit() {
  cin >> n >> k;
  for (int i = 1; i <= k; i++) cin >> a[i][1] >> a[i][2] >> a[i][3] >> a[i][4];
  for (int i = 1; i <= n; i++) b[i] = false;
}
void solve() {
  for (int i = k; i >= 1; i--)
    if (a[i][1] == 1) {
      for (int j = a[i][2]; j <= a[i][3]; j++)
        if (b[j]) c[j] -= a[i][4];
    } else
      for (int j = a[i][2]; j <= a[i][3]; j++)
        if (b[j])
          c[j] = minn(c[j], a[i][4]);
        else {
          c[j] = a[i][4], b[j] = true;
        }
}
void writ() {
  for (int i = 1; i <= n; i++) c1[i] = c[i];
  for (int i = 1; i <= k; i++)
    if (a[i][1] == 1) {
      for (int j = a[i][2]; j <= a[i][3]; j++) c1[j] += a[i][4];
    } else {
      int mins = c1[a[i][2]];
      for (int j = a[i][2] + 1; j <= a[i][3]; j++)
        if (mins < c1[j]) mins = c1[j];
      if (mins != a[i][4]) {
        cout << "NO";
        return;
      }
    }
  cout << "YES"
       << "\n";
  for (int i = 1; i <= n; i++) cout << c[i] << " ";
}
int main() {
  cit();
  solve();
  writ();
}
