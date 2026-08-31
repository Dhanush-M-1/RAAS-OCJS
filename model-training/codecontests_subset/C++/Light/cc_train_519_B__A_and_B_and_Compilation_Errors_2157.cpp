#include <bits/stdc++.h>
using namespace std;
const double eps = 1e-6;
const int N = 1e5 + 5;
int a[N], b[N], ans1, ans2, n;
int main() {
  cin >> n;
  for (int i = 0; i < n; ++i) cin >> a[i];
  for (int i = 0; i < n - 1; ++i) cin >> b[i];
  sort(a, a + n);
  sort(b, b + n - 1);
  for (int i = 0; i < n - 1; ++i)
    if (a[i] != b[i]) {
      ans1 = a[i];
      break;
    }
  if (!ans1) ans1 = a[n - 1];
  for (int i = 0; i < n - 2; ++i) cin >> a[i];
  sort(a, a + n - 2);
  for (int i = 0; i < n - 2; ++i)
    if (b[i] != a[i]) {
      ans2 = b[i];
      break;
    }
  if (!ans2) ans2 = b[n - 2];
  cout << ans1 << endl << ans2;
  return 0;
}
