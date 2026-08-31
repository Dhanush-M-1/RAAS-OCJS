#include <bits/stdc++.h>
using namespace std;
const int maxn = 300005;
int n, m, cont[maxn];
set<int> g[maxn];
set<int> first;
set<int> can;
int main(void) {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  int n, m;
  while (cin >> n >> m) {
    for (int i = 0; i < n; i++) cin >> cont[i];
    for (int i = 1; i < n + 1; i++) g[i].clear();
    can.clear();
    int st = cont[n - 1];
    for (int i = 0; i < m; i++) {
      int add1, add2;
      cin >> add1 >> add2;
      if (add2 != st)
        g[add2].insert(add1);
      else
        first.insert(add1);
    }
    if (n == 1) {
      cout << 0 << endl;
      exit(0);
    }
    int ans = 0;
    for (int i = 1; i < n + 1; i++) {
      if (i != st) {
        can.insert(i);
      }
    }
    for (int i = n - 2; i >= 0; i--) {
      if (can.find(cont[i]) != can.end() &&
          first.find(cont[i]) != first.end()) {
        ans++;
      } else {
        set<int> era;
        for (auto j : can) {
          if (g[cont[i]].find(j) == g[cont[i]].end()) {
            era.insert(j);
          }
        }
        for (auto j : era) {
          can.erase(j);
        }
        if (can.size() == 0) {
          break;
        }
      }
    }
    cout << ans << endl;
  }
}
