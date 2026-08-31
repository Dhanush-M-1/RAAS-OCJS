#include <bits/stdc++.h>
using namespace std;
#pragma comment(linker, "/STACK:102400000,102400000")
int n, m, a[10000], sum[10000], op[10000], l[10000], r[10000], num[10000],
    b[10000];
int main() {
  cin >> n >> m;
  for (int i = 1; i <= n; i++) a[i] = 999999999;
  memset(sum, 0, sizeof(sum));
  for (int i = 1; i <= m; i++) {
    scanf("%d%d%d%d", &op[i], &l[i], &r[i], &num[i]);
    if (op[i] == 1) {
      for (int j = l[i]; j <= r[i]; j++) sum[j] += num[i];
    } else {
      for (int j = l[i]; j <= r[i]; j++)
        if (a[j] + sum[j] > num[i]) a[j] = num[i] - sum[j];
    }
  }
  memcpy(b, a, sizeof(a));
  for (int i = 1; i <= m; i++) {
    if (op[i] == 1) {
      for (int j = l[i]; j <= r[i]; j++) b[j] += num[i];
    } else {
      int m = -0x3f3f3f3f;
      for (int j = l[i]; j <= r[i]; j++) m = max(m, b[j]);
      if (m != num[i]) {
        cout << "NO" << endl;
        return 0;
      }
    }
  }
  cout << "YES" << endl;
  cout << a[1];
  for (int i = 2; i <= n; i++) cout << " " << a[i];
  cout << endl;
}
