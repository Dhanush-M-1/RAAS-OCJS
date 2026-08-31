#include <bits/stdc++.h>
using namespace std;
long long int a[100010], csum[100010], mx[100010], mn[100100];
void fail() {
  cout << -1 << endl;
  exit(0);
}
int main() {
  int n, d;
  cin >> n >> d;
  for (int i = 1; i <= n; i++) cin >> a[i];
  for (int i = 1; i <= n; i++) csum[i] = csum[i - 1] + a[i];
  mx[n + 1] = -2000000010, mn[n + 1] = 2000000010;
  for (int i = 1; i <= n; i++) {
    if (a[i] == 0)
      mn[i] = min(mn[i + 1], csum[i]);
    else
      mn[i] = mn[i + 1];
  }
  for (int i = n; i >= 1; i--) mx[i] = max(csum[i], mx[i + 1]);
  long long int del = 0, ans = 0;
  for (int i = 1; i <= n; i++) {
    if (mn[i] + del < 0) {
      int aux = mx[i] + del;
      if (aux < d) {
        ans++;
        del += d - aux;
      }
    }
    if (csum[i] + del > d) fail();
    if (a[i] == 0 && csum[i] + del < 0) fail();
  }
  cout << ans << endl;
}
