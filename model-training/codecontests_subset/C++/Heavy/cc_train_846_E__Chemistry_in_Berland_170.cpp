#include <bits/stdc++.h>
using namespace std;
const int mod = 1e9 + 7;
const int maxn = 1e6 + 5;
long long int power(long long int base, long long int exp) {
  long long int res = 1;
  while (exp) {
    if (exp % 2) res *= base;
    base *= base;
    res %= mod;
    base %= mod;
    exp /= 2;
  }
  return res;
}
long long int u[maxn], v[maxn], a[maxn], b[maxn];
vector<pair<long long int, long long int> > adj[maxn];
void dfs(long long int i) {
  if (b[i] < -1e18) {
    cout << "NO";
    exit(0);
  }
  for (auto next : adj[i]) {
    dfs(next.first);
  }
  if (i == 1) {
    if (a[i] > b[i]) {
      cout << "NO";
      exit(0);
    } else {
      cout << "YES";
      exit(0);
    }
  }
  if (a[i] > b[i]) {
    long long int how = a[i] - b[i];
    if (1.0 * b[u[i]] - 1.0 * v[i] * how < -2e17) {
      cout << "NO";
      exit(0);
    }
    b[u[i]] -= (v[i] * how);
  } else {
    long long int how = b[i] - a[i];
    b[u[i]] += how;
  }
  b[i] = a[i];
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  long long int n, i;
  cin >> n;
  for (i = 1; i <= n; i++) cin >> b[i];
  for (i = 1; i <= n; i++) cin >> a[i];
  for (i = 2; i <= n; i++) {
    cin >> u[i] >> v[i];
    adj[u[i]].push_back({i, v[i]});
  }
  dfs(1);
  return 0;
}
