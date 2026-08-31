#include <bits/stdc++.h>
using namespace std;
const long long int maxn = 5 * 100000 + 50, inf = 1e13, N = 3050;
long long int par[maxn];
vector<long long int> v[maxn];
long long int dp[maxn];
vector<long long int> p;
bool f[maxn];
void dfs(long long int x) {
  long long int y = 0;
  p.push_back(x);
  for (long long int i = 0; i < v[x].size(); i++) dfs(v[x][i]);
  for (long long int i = 0; i < v[x].size(); i++) {
    if (dp[v[x][i]] == 1) y++;
  }
  if (y % 2 == 1) {
    dp[x] = 2;
    f[x] = true;
  } else
    dp[x] = 1;
}
int main() {
  long long int n;
  cin >> n;
  long long int rishe = -1;
  for (long long int i = 1; i <= n; i++) {
    long long int c;
    cin >> c;
    if (c == 0) {
      rishe = i;
      continue;
    }
    v[c].push_back(i);
    par[i] = c;
  }
  for (long long int i = 1; i <= n; i++)
    if (v[i].size() == 0) dp[i] = 1;
  dfs(rishe);
  if (dp[rishe] == 2) {
    cout << "NO";
  } else {
    cout << "YES" << endl;
    for (long long int i = p.size() - 1; i > -1; i--) {
      if (f[p[i]] == true) cout << p[i] << endl;
    }
    for (long long int i = 0; i < p.size(); i++) {
      if (f[p[i]] == true) continue;
      cout << p[i] << endl;
    }
  }
  return 0;
}
