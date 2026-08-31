#include <bits/stdc++.h>
using namespace std;
int a[100002];
int h[100002];
int d[100002];
int df(int i, int k, int n) {
  if (i >= n - 1) return 0;
  if (d[i] != -1) return d[i];
  int y = max(a[i - 1], k);
  int x = max(a[i + 1], k);
  int a1 = 0, a2 = 0, a3 = 0;
  if (y < (a[i] - h[i])) a1 = 1 + df(i + 1, a[i], n);
  if (x > (a[i] + h[i])) a2 = 1 + df(i + 1, a[i] + h[i], n);
  a3 = df(i + 1, a[i], n);
  return d[i] = max(a3, max(a1, a2));
}
int main() {
  int n;
  cin >> n;
  memset(d, -1, sizeof d);
  for (int i = 0; i < n; i++) {
    cin >> a[i] >> h[i];
  }
  if (n > 1)
    cout << 2 + df(1, 0, n);
  else
    cout << 1 << endl;
}
