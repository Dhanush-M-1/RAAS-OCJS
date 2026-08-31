#include <bits/stdc++.h>
using namespace std;
const int N = 100100;
const long long MOD = 1000000007;
const double EBS = 1e-7;
int dX[] = {0, 0, 1, -1};
int dY[] = {1, -1, 0, 0};
int n;
vector<pair<long long, long long> > adj[N];
long long a[N], b[N];
bool f = 1;
bool ok(long long x, long long y) {
  x = log10(x);
  y = log10(y);
  return x + y <= 18;
}
long long dfs(int cur) {
  for (auto x : adj[cur]) b[cur] += dfs(x.first);
  for (auto x : adj[cur])
    if (b[x.first] < a[x.first])
      f &= ok(a[x.first] - b[x.first], x.second),
          b[cur] -= (a[x.first] - b[x.first]) * x.second,
          a[x.first] = b[x.first], f &= (b[cur] <= (long long)1e18);
  long long cnt = 0;
  if (b[cur] > a[cur]) cnt = b[cur] - a[cur], a[cur] = b[cur];
  return cnt;
}
int main() {
  scanf("%d", &n);
  for (int i = 0; i < n; ++i) scanf("%lld", &b[i]);
  for (int i = 0; i < n; ++i) scanf("%lld", &a[i]);
  for (int i = 1; i < n; ++i) {
    int x, y;
    scanf("%d", &x);
    scanf("%d", &y);
    adj[--x].push_back({i, y});
  }
  dfs(0);
  if (b[0] >= a[0] && f)
    puts("YES");
  else
    puts("NO");
  return 0;
}
