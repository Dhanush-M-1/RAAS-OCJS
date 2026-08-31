#include <bits/stdc++.h>
using namespace std;
const int maxn = 6000;
int t[maxn], l[maxn], r[maxn], d[maxn], a[maxn], b[maxn];
int n, m;
int main() {
  cin >> n >> m;
  for (int i = 1; i <= n; i++) a[i] = 5e7;
  for (int i = 1; i <= m; i++) cin >> t[i] >> l[i] >> r[i] >> d[i];
  for (int i = m; i >= 1; i--) {
    if (t[i] == 1) {
      for (int j = l[i]; j <= r[i]; j++) a[j] -= d[i];
    } else {
      for (int j = l[i]; j <= r[i]; j++) a[j] = min(a[j], d[i]);
    }
  }
  for (int i = 1; i <= n; i++) b[i] = a[i];
  for (int i = 1; i <= m; i++) {
    if (t[i] == 1) {
      for (int j = l[i]; j <= r[i]; j++) b[j] += d[i];
    } else {
      int flag = 0;
      for (int j = l[i]; j <= r[i]; j++)
        if (b[j] == d[i]) flag = 1;
      if (!flag) {
        cout << "NO" << endl;
        return 0;
      }
    }
  }
  cout << "YES" << endl;
  for (int i = 1; i <= n; i++) {
    printf("%d", a[i]);
    if (i != n)
      printf(" ");
    else
      printf("\n");
  }
  return 0;
}
