#include <bits/stdc++.h>
using namespace std;
const int MAXN = 2e5 + 5;
const int INF = 1e9 + 5;
int child[MAXN];
bitset<MAXN> done;
vector<int> rta;
vector<int> G[MAXN];
int dfs1(int st) {
  done[st] = true;
  int sum = 0;
  for (auto &i : G[st])
    if (!done[i]) sum += dfs1(i);
  return child[st] = sum + 1;
}
void dfs2(int st) {
  done[st] = true;
  for (auto &i : G[st])
    if (!done[i] && !(child[i] & 1)) dfs2(i);
  rta.push_back(st);
  for (auto &i : G[st])
    if (!done[i] && (child[i] & 1)) dfs2(i);
}
int main() {
  ios::sync_with_stdio(false);
  cin.tie(nullptr);
  ;
  int n;
  cin >> n;
  for (int i = 0; i < int(n); i++) {
    int x;
    cin >> x;
    x--;
    if (x >= 0) G[i].push_back(x), G[x].push_back(i);
  }
  if (!(n & 1)) return cout << "NO", 0;
  dfs1(0);
  done.reset();
  dfs2(0);
  cout << "YES\n";
  for (auto &i : rta) cout << i + 1 << '\n';
  return 0;
}
