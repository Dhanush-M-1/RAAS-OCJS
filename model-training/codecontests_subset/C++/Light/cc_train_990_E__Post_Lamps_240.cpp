#include <bits/stdc++.h>
using namespace std;
using INT = long long;
using pii = pair<int, int>;
int vst[1001000], cst[1001000], nxt[1001000];
int main() {
  ios_base ::sync_with_stdio(0);
  cin.tie(0);
  int n, m, k;
  cin >> n >> m >> k;
  for (int i = 1; i <= m; i++) {
    int pos;
    cin >> pos;
    vst[pos] = 1;
  }
  for (int i = 1; i <= k; i++) cin >> cst[i];
  nxt[n] = n + 1;
  for (int i = n; i >= 0; i--) {
    nxt[i] = nxt[i + 1];
    if (vst[i] == 0) nxt[i] = i;
  }
  INT ans = 0x3f3f3f3f3f3f3f3f;
  for (int len = 1; len <= k; len++) {
    INT tmp = 0;
    int pos = n;
    int flag = 1;
    while (1) {
      if (nxt[max(0, pos - len)] >= pos) {
        flag = 0;
        break;
      }
      pos = nxt[max(0, pos - len)];
      tmp += cst[len];
      if (pos == 0) break;
    }
    if (flag) ans = min(ans, tmp);
  }
  if (ans > 1000000000000000000ll)
    cout << "-1" << endl;
  else
    cout << ans << endl;
  return 0;
}
