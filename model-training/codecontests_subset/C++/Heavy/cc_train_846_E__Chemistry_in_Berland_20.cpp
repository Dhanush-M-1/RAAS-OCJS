#include <bits/stdc++.h>
using namespace std;
const int N = 2e5;
const long long inf = 1e18;
long long a[N];
long long bal[N];
long long zn[N];
int n;
long long b[N];
long long limit;
long long mul(long long &x, long long y) {
  if (-x >= inf / y + ((inf % y) != 0))
    return -inf;
  else
    return x * y;
}
void add(long long &x, long long y) {
  x += y;
  if (x > inf) x = inf;
  if (x < -inf) x = -inf;
}
vector<int> ed[N];
void dfs(int x) {
  long long sum = a[x] - b[x];
  for (int j = 0; j < ed[x].size(); j++) {
    int to = ed[x][j];
    dfs(to);
    if (bal[to] < 0) add(sum, mul(bal[to], zn[to]));
  }
  for (int j = 0; j < ed[x].size(); j++) {
    int to = ed[x][j];
    if (bal[to] > 0) sum += bal[to];
  }
  bal[x] = sum;
}
int main() {
  ios_base::sync_with_stdio(0);
  cin >> n;
  for (int i = 1; i <= n; i++) cin >> a[i];
  for (int i = 1; i <= n; i++) cin >> b[i];
  for (int i = 2; i <= n; i++) {
    int par, k;
    cin >> par >> k;
    ed[par].push_back(i);
    zn[i] = k;
  }
  dfs(1);
  if (bal[1] < 0)
    cout << "NO\n";
  else
    cout << "YES\n";
  return 0;
}
