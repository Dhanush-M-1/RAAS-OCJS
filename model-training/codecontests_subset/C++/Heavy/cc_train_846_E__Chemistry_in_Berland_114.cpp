#include <bits/stdc++.h>
using namespace std;
const long long int mod = 1e15 + 7;
const long long int maxn = 1e6 + 10;
const long long inf = 1e18 + 18;
double pie = 3.1415926535;
long long int a[maxn], b[maxn];
vector<pair<long long int, long long int> > adj[maxn];
long long mult(long long a, long long b) {
  if (a >= inf / b + 2) {
    return inf;
  }
  return min(a * b, inf);
}
void dfs(long long int s) {
  if (a[s] <= -inf) {
    cout << "NO";
    exit(0);
  }
  long long int i, node, k;
  for (i = 0; i < int(adj[s].size()); i++) {
    node = adj[s][i].first;
    k = adj[s][i].second;
    dfs(node);
    if (a[node] < b[node]) {
      if (mult(b[node] - a[node], k) >= inf) {
        cout << "NO";
        exit(0);
      }
      if ((a[s] - mult(b[node] - a[node], k)) <= -inf) {
        cout << "NO";
        exit(0);
      }
      a[s] = a[s] - (b[node] - a[node]) * k;
    } else {
      a[s] += a[node] - b[node];
    }
  }
}
int main() {
  long long int n, x, k, i;
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  cin >> n;
  for (i = 1; i <= n; i++) cin >> a[i];
  for (i = 1; i <= n; i++) cin >> b[i];
  for (i = 2; i <= n; i++) {
    cin >> x >> k;
    adj[x].push_back({i, k});
  }
  dfs(1);
  if (a[1] >= b[1])
    cout << "YES";
  else
    cout << "NO";
}
