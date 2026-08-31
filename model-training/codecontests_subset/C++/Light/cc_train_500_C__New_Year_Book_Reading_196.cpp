#include <bits/stdc++.h>
using namespace std;
const int mm = 1e6;
long long int d[mm];
long long int ans[mm];
bool vis[mm];
queue<long long int> q, qq;
int main() {
  long long int n, m, i, j, k, kk, a, b, t, num, p, z, l, r, mid, s, ss;
  cin >> n >> m;
  for (i = 1; i <= n; i++) cin >> d[i];
  for (i = 1; i <= m; i++) cin >> ans[i];
  for (i = 1; i <= m; i++)
    if (vis[ans[i]] == 0) q.push(ans[i]), vis[ans[i]] = 1;
  num = 0;
  for (i = 1; i <= m; i++) {
    qq.push(ans[i]);
    while (1) {
      k = q.front();
      q.pop();
      if (k != ans[i]) qq.push(k);
      if (k != ans[i])
        num += d[k];
      else
        break;
    }
    while (!q.empty()) {
      k = q.front();
      q.pop();
      qq.push(k);
    }
    while (!qq.empty()) {
      k = qq.front();
      qq.pop();
      q.push(k);
    }
  }
  cout << num << endl;
}
