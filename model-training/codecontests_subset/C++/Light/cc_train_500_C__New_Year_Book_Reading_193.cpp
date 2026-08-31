#include <bits/stdc++.h>
using namespace std;
const int N = 1001;
int n, a[N], w[N], b[N], s[N], m;
int main() {
  ios_base::sync_with_stdio(false);
  cin >> n >> m;
  for (int i = 1; i <= n; i++) cin >> w[i];
  for (int i = 1; i <= m; i++) cin >> a[i];
  int top = 1;
  s[1] = a[1];
  b[a[1]] = 1;
  for (int i = 2; i <= m; i++)
    if (!b[a[i]]) {
      s[++top] = a[i];
      b[a[i]] = 1;
    }
  int res = 0;
  for (int i = 1; i <= m; i++) {
    int vt, sum = 0;
    for (int j = 1; j <= top; j++)
      if (s[j] == a[i]) {
        vt = j;
        break;
      } else
        sum += w[s[j]];
    res += sum;
    for (int j = vt - 1; j >= 1; j--) s[j + 1] = s[j];
    s[1] = a[i];
  }
  cout << res << endl;
  return 0;
}
