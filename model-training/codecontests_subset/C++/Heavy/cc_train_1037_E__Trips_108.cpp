#include <bits/stdc++.h>
using namespace std;
template <class TH>
void _dbg(const char *sdbg, TH h) {
  cerr << sdbg << " = " << h << endl;
}
template <class TH, class... TA>
void _dbg(const char *sdbg, TH h, TA... a) {
  while (*sdbg != ',') cerr << *sdbg++;
  cerr << " = " << h << ", ";
  _dbg(sdbg + 1, a...);
}
const int maxn = (1e6) + 7;
const int maxk = 20;
const int inf = (1e9) + 7;
const long long LLinf = (1e18) + 7;
const long double eps = 1e-9;
const long long mod = 1e9 + 7;
queue<int> q;
bool vis[maxn];
int res;
int n, m, k;
int odp[maxn];
set<int> wek[maxn];
pair<int, int> tab[maxn];
void rob() {
  while (((int)(q).size())) {
    int a = q.front();
    q.pop();
    if (vis[a] == 0) continue;
    vis[a] = 0;
    res--;
    for (auto s : wek[a])
      if (vis[s] == 1) {
        wek[s].erase(a);
        if (((int)(wek[s]).size()) < k) q.push(s);
      }
  }
}
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  cin >> n >> m >> k;
  res = n;
  for (int i = 1; i <= m; i++) {
    cin >> tab[i].first >> tab[i].second;
    wek[tab[i].first].insert(tab[i].second);
    wek[tab[i].second].insert(tab[i].first);
  }
  for (int i = 1; i <= n; i++) {
    vis[i] = 1;
    if (((int)(wek[i]).size()) < k) q.push(i);
  }
  rob();
  odp[m] = res;
  for (int i = m - 1; i >= 0; i--) {
    wek[tab[i + 1].first].erase(tab[i + 1].second);
    wek[tab[i + 1].second].erase(tab[i + 1].first);
    if (vis[tab[i + 1].first] == 1 && ((int)(wek[tab[i + 1].first]).size()) < k)
      q.push(tab[i + 1].first);
    if (vis[tab[i + 1].second] == 1 &&
        ((int)(wek[tab[i + 1].second]).size()) < k)
      q.push(tab[i + 1].second);
    rob();
    odp[i] = res;
  }
  for (int i = 1; i <= m; i++) cout << odp[i] << "\n";
  return 0;
}
