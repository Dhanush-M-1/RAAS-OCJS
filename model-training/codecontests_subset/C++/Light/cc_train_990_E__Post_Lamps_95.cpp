#include <bits/stdc++.h>
using namespace std;
const int N = 1e6 + 5;
int n, m, k, s;
int nxt[N], path[N];
bool bl[N];
int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  cin >> n >> m >> k;
  for (int i = 1; i <= m; i++) {
    cin >> s;
    bl[s] = true;
  }
  for (int i = 0; i <= n; i++) {
    if (bl[i]) {
      if (i == 0) {
        nxt[i] = -1;
      } else {
        nxt[i] = nxt[i - 1];
      }
    } else {
      nxt[i] = i;
    }
  }
  if (bl[0]) {
    return puts("-1"), 0;
  }
  long long ans = LLONG_MAX;
  for (int i = 1; i <= k; i++) {
    cin >> s;
    long long ct = 0;
    int pos = 0;
    while (pos < n) {
      if (pos == -1 || path[pos] == i) {
        break;
      }
      path[pos] = i;
      ct++;
      if (pos + i >= n) {
        pos = n;
        break;
      }
      pos = nxt[pos + i];
    }
    if (pos >= n) {
      ans = min(ans, ct * s);
    }
  }
  cout << (ans == LLONG_MAX ? -1 : ans) << endl;
  return 0;
}
