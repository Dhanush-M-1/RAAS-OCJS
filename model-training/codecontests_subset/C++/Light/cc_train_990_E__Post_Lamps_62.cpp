#include <bits/stdc++.h>
using namespace std;
const long long INF = 100000000000000000;
long long s[1000005];
long long l[1000005];
int main() {
  long long n, m, k;
  cin >> n >> m >> k;
  for (int i = 0; i < m; i++) scanf("%lld", &s[i]);
  if (m > 0 && s[0] == 0) {
    cout << -1 << endl;
    return 0;
  }
  for (int i = 0; i < n; i++) l[i] = i;
  for (int i = 0; i < m; i++) l[s[i]] = l[s[i] - 1];
  long long ans = INF;
  for (int i = 1; i <= k; i++) {
    long long c = 0;
    long long j = 0;
    bool f = true;
    while (true) {
      if (j + i >= n) {
        c++;
        break;
      }
      if (l[j + i] == j) {
        f = false;
        break;
      }
      j = l[j + i];
      c++;
    }
    long long a;
    scanf("%lld", &a);
    if (f) ans = min(ans, c * a);
  }
  if (ans == INF)
    cout << -1 << endl;
  else
    cout << ans << endl;
}
