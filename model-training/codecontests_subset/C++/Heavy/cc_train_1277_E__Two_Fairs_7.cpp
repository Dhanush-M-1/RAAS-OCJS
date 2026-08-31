#include <bits/stdc++.h>
const long long mod = 1000000007;
const long long mod1 = 998244353;
using namespace std;
long long n, m, a, b, sum = 0;
vector<long long> v[200005];
bool visited[200005];
void dfs(long long x, long long y) {
  if (x == y) return;
  visited[x] = true, sum++;
  for (long long i = 0; i < v[x].size(); i++) {
    if (!visited[v[x][i]]) {
      dfs(v[x][i], y);
    }
  }
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  long long t;
  cin >> t;
  while (t--) {
    cin >> n >> m >> a >> b;
    for (long long i = 0; i <= n + 1; i++) v[i].clear(), visited[i] = false;
    for (long long i = 0; i < m; i++) {
      long long x, y;
      cin >> x >> y;
      v[x].push_back(y);
      v[y].push_back(x);
    }
    dfs(a, b);
    long long xz = sum;
    sum = 0;
    for (long long i = 0; i <= n; i++) visited[i] = false;
    dfs(b, a);
    long long yz = sum;
    sum = 0;
    long long z = xz + yz - n;
    xz -= z + 1, yz -= z + 1;
    cout << xz * yz << endl;
  }
}
