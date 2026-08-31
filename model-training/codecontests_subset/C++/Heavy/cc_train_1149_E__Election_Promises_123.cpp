#include <bits/stdc++.h>
const int N = 200005;
using namespace std;
long long n, m, num[N], sy[N], ds[N], bj[N], sum[N];
vector<long long> to[N], pre[N];
queue<long long> que;
int main() {
  long long i, j, t, p, q;
  scanf("%d%d", &n, &m);
  for (i = 1; i <= n; i++) scanf("%lld", &num[i]);
  for (i = 1; i <= m; i++) {
    scanf("%lld%lld", &p, &q);
    pre[q].push_back(p);
    to[p].push_back(q);
    ds[p]++;
  }
  for (i = 1; i <= n; i++)
    if (!ds[i]) que.push(i);
  while (!que.empty()) {
    q = que.front();
    que.pop();
    for (i = 0; i < pre[q].size(); i++) {
      t = pre[q][i];
      ds[t]--;
      if (!ds[t]) que.push(t);
    }
    for (i = 0; i < to[q].size(); i++) {
      t = to[q][i];
      bj[sy[t]] = q;
    }
    for (i = 0; bj[i] == q; i++)
      ;
    sy[q] = i;
    sum[sy[q]] ^= num[q];
  }
  for (i = n; i >= 0; i--) {
    if (!sum[i]) continue;
    puts("WIN");
    for (j = 1; j <= n; j++)
      if (sy[j] == i && (num[j] ^ sum[i]) < num[j]) break;
    q = j, num[q] ^= sum[i];
    for (j = 0; j < to[q].size(); j++) {
      t = to[q][j];
      if (sum[sy[t]] && bj[sy[t]] != -1) {
        bj[sy[t]] = -1;
        num[t] ^= sum[sy[t]];
      }
    }
    for (i = 1; i <= n; i++) printf("%lld ", num[i]);
    return 0;
  }
  puts("LOSE");
}
