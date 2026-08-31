#include <bits/stdc++.h>
using namespace std;
int IsPrime(int k) {
  for (int u = 2; u * u <= k; u++)
    if (k % u == 0) return false;
  return (k != 1);
}
int printnum(int num, int base) {
  int curr = 0, ans[10];
  while (num != 0) {
    ans[curr++] = num % base;
    num /= base;
  }
  for (int x = curr - 1; x >= 0; x--) cout << ans[x];
  cout << " ";
  return 0;
}
int i, n, ans[1000000], a[1000000];
int x, y, z, x2, y2, z2, dx, dy, dz;
int main() {
  cin >> n;
  for (i = 1; i < n; i++) {
    for (int j = 1; j < n; j++) printnum(i * j, n);
    cout << endl;
  }
}
