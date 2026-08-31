#include <bits/stdc++.h>
using namespace std;
int n, m, k, a, b, x;
vector<int> edge[200005];
pair<int, int> amie[200005];
int deg[200005], ans[200005];
set<pair<int, int> > s, r;
void go(int y, int z) {
  while (!s.empty() && s.begin()->first < k) {
    a = s.begin()->second;
    b = (int)edge[a].size();
    s.erase(s.begin());
    for (int i = 0; i < b; ++i) {
      if ((a == y && edge[a][i] == z) || (a == z && edge[a][i] == y)) continue;
      if (s.find(pair<int, int>(deg[edge[a][i]], edge[a][i])) != s.end() &&
          r.find(pair<int, int>(a, edge[a][i])) == r.end() &&
          r.find(pair<int, int>(edge[a][i], a)) == r.end()) {
        s.erase(s.find(pair<int, int>(deg[edge[a][i]], edge[a][i])));
        deg[edge[a][i]]--;
        s.insert(pair<int, int>(deg[edge[a][i]], edge[a][i]));
      }
    }
  }
}
int main() {
  scanf("%d%d%d", &n, &m, &k);
  for (int i = 0; i < m; ++i) {
    scanf("%d%d", &amie[i].first, &amie[i].second);
    edge[amie[i].first].push_back(amie[i].second);
    edge[amie[i].second].push_back(amie[i].first);
    deg[amie[i].first]++;
    deg[amie[i].second]++;
  }
  for (int i = 1; i <= n; ++i) s.insert(pair<int, int>(deg[i], i));
  go(-1, -1);
  for (int i = m - 1; i >= 0; --i) {
    ans[i] = (int)s.size();
    if (s.find(pair<int, int>(deg[amie[i].first], amie[i].first)) != s.end() &&
        s.find(pair<int, int>(deg[amie[i].second], amie[i].second)) !=
            s.end()) {
      s.erase(s.find(pair<int, int>(deg[amie[i].first], amie[i].first)));
      s.erase(s.find(pair<int, int>(deg[amie[i].second], amie[i].second)));
      deg[amie[i].first]--;
      deg[amie[i].second]--;
      s.insert(pair<int, int>(deg[amie[i].first], amie[i].first));
      s.insert(pair<int, int>(deg[amie[i].second], amie[i].second));
      r.insert(amie[i]);
      go(amie[i].first, amie[i].second);
    }
  }
  for (int i = 0; i < m; ++i) {
    printf("%d\n", ans[i]);
  }
  return 0;
}
