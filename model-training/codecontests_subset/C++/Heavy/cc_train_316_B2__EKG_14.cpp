#include <bits/stdc++.h>
using namespace std;
long long _set(long long N, long long pos) { return N = N | (1 << pos); }
long long _reset(long long N, long long pos) { return N = N & ~(1 << pos); }
bool _check(long long N, long long pos) { return (bool)(N & (1 << pos)); }
bool _upper(char a) { return a >= 'A' && a <= 'Z'; }
bool _lower(char a) { return a >= 'a' && a <= 'z'; }
bool _digit(char a) { return a >= '0' && a <= '9'; }
long long dx[] = {1, -1, 0, 0, -1, -1, 1, 1};
long long dy[] = {0, 0, 1, -1, -1, 1, -1, 1};
vector<vector<long long> > g;
long long t[1010], ch, x, f, pos, n;
bool vis[1010];
void dfs(long long u) {
  if (!vis[u]) vis[u] = true;
  ch++;
  if (u == x) pos = ch, f = 1;
  for (auto i : g[u]) {
    dfs(i);
  }
}
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cin >> n >> x;
  g.resize(n + 5);
  for (long long i = 1; i <= n; i++) {
    long long a;
    cin >> a;
    if (!a) {
      t[i] = 1;
      continue;
    }
    g[a].push_back(i);
  }
  vector<long long> cl;
  for (long long i = 1; i <= n; i++) {
    if (t[i]) {
      dfs(i);
      if (!f) cl.push_back(ch);
      ch = 0, f = 0;
    }
  }
  bitset<1010> memo;
  memo[0] = 1;
  for (auto i : cl) memo |= memo << i;
  for (int i = 0; i < 1010; i++)
    if (memo[i] == 1) cout << i + pos << "\n";
  return 0;
}
