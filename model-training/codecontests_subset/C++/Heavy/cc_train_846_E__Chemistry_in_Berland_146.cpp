#include <bits/stdc++.h>
using namespace std;
vector<vector<long long> > adj(123456);
long long w[123456], a[123456], b[123456];
long long iinf;
int add(long long &a, long long &b, long long &c) {
  long long val;
  if (iinf / c > abs(b)) {
    val = b * c;
  } else {
    cout << "NO" << endl;
    exit(0);
  }
  a += val;
  if (abs(a) > iinf) {
    cout << "NO" << endl;
    exit(0);
  }
  return 0;
}
int dfs(int cur, int par) {
  int i, flag = 0;
  for (i = 0; i < adj[cur].size(); i++) {
    if (adj[cur][i] != par) {
      dfs(adj[cur][i], cur);
      flag = 1;
    }
  }
  b[cur] -= a[cur];
  if (par == -1) {
    if (b[cur] < 0) {
      cout << "NO" << endl;
    } else {
      cout << "YES" << endl;
    }
    exit(0);
  } else {
    if (b[cur] >= 0) {
      b[par] += b[cur];
    } else {
      add(b[par], b[cur], w[cur]);
    }
  }
  return 0;
}
int main() {
  std::ios::sync_with_stdio(false);
  int n, dep;
  cin >> n;
  iinf = (1000 * 1000 * 1000 + 5);
  iinf *= (1000 * 1000 * 1000 + 5);
  int i;
  for (i = 0; i < n; i++) {
    cin >> b[i];
  }
  for (i = 0; i < n; i++) {
    cin >> a[i];
  }
  for (i = 1; i < n; i++) {
    cin >> dep >> w[i];
    dep--;
    adj[dep].push_back(i);
    adj[i].push_back(dep);
  }
  dfs(0, -1);
  return 0;
}
