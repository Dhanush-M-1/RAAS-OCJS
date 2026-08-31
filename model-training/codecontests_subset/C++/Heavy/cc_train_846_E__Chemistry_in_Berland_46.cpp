#include <bits/stdc++.h>
using namespace std;
const long double PI = 3.14159265359;
const long long MOD = (long long)998244353ll;
const long long MAXN = (long long)1e6 + 10;
const long long INF = (long long)2242545357980376863;
const long double EPS = (long double)1e-8;
vector<pair<long long, long long> > G[MAXN];
long long a[MAXN], b[MAXN];
long long MN = 3e18;
long long mul(long long a, long long b) {
  if (a > MN / b + 5) return MN;
  return a * b;
}
void DFS(long long u) {
  long long adj, w;
  for (auto E : G[u]) {
    adj = E.first;
    w = E.second;
    DFS(adj);
    if (a[adj] < b[adj]) {
      long long x = b[adj] - a[adj];
      b[adj] -= x;
      b[u] += x;
    } else if (a[adj] > b[adj]) {
      long long x = a[adj] - b[adj];
      b[adj] += x;
      b[u] -= mul(x, w);
      b[u] = max(b[u], -MN);
    }
  }
}
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  long long n;
  cin >> n;
  for (int i = 1; i <= n; i++) cin >> b[i];
  for (int i = 1; i <= n; i++) cin >> a[i];
  long long u, w;
  for (int i = 2; i <= n; i++) {
    cin >> u >> w;
    G[u].push_back({i, w});
  }
  DFS(1);
  if (b[1] < a[1])
    cout << "NO";
  else
    cout << "YES";
  return 0;
}
