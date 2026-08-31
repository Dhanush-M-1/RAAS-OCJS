#include <bits/stdc++.h>
using namespace std;
int res[101000], a[101000], t[101000], l[101000], r[101000], d[101000],
    m[101000];
int n, M;
int main() {
  cin >> n >> M;
  for (int i = 1; i <= M; i++) {
    cin >> t[i];
    if (t[i] == 1)
      cin >> l[i] >> r[i] >> d[i];
    else
      cin >> l[i] >> r[i] >> m[i];
  }
  for (int i = 1; i <= M; i++) {
    if (t[i] == 1)
      for (int j = l[i]; j <= r[i]; j++) a[j] += d[i];
    if (t[i] == 2)
      for (int j = l[i]; j <= r[i]; j++) a[j] = m[i];
  }
  for (int i = M; i >= 1; i--) {
    if (t[i] == 1)
      for (int j = l[i]; j <= r[i]; j++) a[j] -= d[i];
    else
      for (int j = l[i]; j <= r[i]; j++)
        if (a[j] > m[i]) a[j] = m[i];
  }
  for (int i = 1; i <= n; i++) res[i] = a[i];
  for (int i = 1; i <= M; i++) {
    if (t[i] == 1)
      for (int j = l[i]; j <= r[i]; j++) a[j] += d[i];
    if (t[i] == 2) {
      int amax = a[l[i]];
      for (int j = l[i]; j <= r[i]; j++) amax = max(a[j], amax);
      if (amax != m[i]) {
        cout << "NO";
        return 0;
      };
    }
  }
  cout << "YES\n";
  for (int i = 1; i <= n; i++) cout << res[i] << " ";
}
