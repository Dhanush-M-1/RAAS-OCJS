#include <bits/stdc++.h>
int const N = 1e6 + 6;
using namespace std;
long long n, m, k, i, j, a, b, x, y, ans, ev;
char st[N], bt[N], ct[N];
vector<long long> adj[N];
vector<long long> res;
void createList(int x, int y, long long z) {
  if (x == 18) {
    res.push_back(z);
    return;
  }
  createList(x + 1, y, z * 10);
  if (y < 3)
    for (long long i = 1; i <= 9; i++) createList(x + 1, y + 1, z * 10 + i);
}
long long o[N], l[N], r[N], d[N], diff[N], pa[N], sum[N];
int main() {
  cin >> n >> m;
  for (i = 0; i < 5010; i++) pa[i] = INT_MAX;
  for (i = 1; i <= m; i++) {
    cin >> o[i] >> l[i] >> r[i] >> d[i];
    if (o[i] == 1) {
      for (j = l[i]; j <= r[i]; j++) diff[j] += d[i];
      continue;
    }
    for (j = l[i]; j <= r[i]; j++) pa[j] = min(pa[j], d[i] - diff[j]);
  }
  for (i = 0; i < 5010; i++)
    if (pa[i] == INT_MAX) pa[i] = 0;
  for (i = 1; i <= m && !x; i++) {
    if (o[i] == 1) {
      for (j = l[i]; j <= r[i]; j++) sum[j] += d[i];
      continue;
    }
    y = 0;
    for (j = l[i]; j <= r[i] && !x; j++) {
      if (pa[j] + sum[j] < d[i])
        y++;
      else if (pa[j] + sum[j] > d[i])
        x = 1;
    }
    if (y == r[i] - l[i] + 1) x = 1;
  }
  if (x)
    cout << "NO";
  else {
    cout << "YES" << endl;
    for (i = 1; i <= n; i++) cout << pa[i] << " ";
    cout << endl;
  }
}
