#include <bits/stdc++.h>
using namespace std;
const int maxn = 300000 + 10;
const int apsz = 26;
const int INF = 10000007;
const unsigned long long mod = 97;
const int maxm = 10000 + 10;
struct rev {
  int c0, c1, tag;
  void maintain() {
    c0 = min(c0, INF);
    c1 = min(c1, INF);
  }
};
rev info[maxn];
int dsu[maxn];
pair<int, int> fd(int u) {
  if (dsu[u] < 0) return {u, 0};
  pair<int, int> tmp = fd(dsu[u]);
  info[u].tag ^= tmp.second;
  dsu[u] = tmp.first;
  return (pair<int, int>){tmp.first, info[u].tag};
}
int st[maxn];
char s[maxn];
int n, k;
vector<int> edge[maxn];
int main(void) {
  scanf("%d", &(n)), scanf("%d", &(k));
  scanf("%s", s + 1);
  for (int i = (1); i <= (n); ++i) st[i] = s[i] - '0';
  for (int i = (1); i <= (k); ++i) {
    info[i] = (rev){0, 1, 0};
    dsu[i] = -1;
    int sz;
    scanf("%d", &(sz));
    for (; sz--;) {
      int x;
      scanf("%d", &(x));
      edge[x].push_back(i);
    }
  }
  long long ans = 0;
  for (int i = (1); i <= (n); ++i) {
    int co = st[i];
    if (edge[i].size() == 1) {
      pair<int, int> t = fd(edge[i][0]);
      int u = t.first;
      ans -= min(info[u].c0, info[u].c1);
      if (co == 1) {
        if (t.second == 0)
          info[u].c1 = INF;
        else
          info[u].c0 = INF;
      } else if (co == 0) {
        if (t.second == 0)
          info[u].c0 = INF;
        else
          info[u].c1 = INF;
      }
      ans += min(info[u].c0, info[u].c1);
    } else if (edge[i].size() == 2) {
      pair<int, int> x, y;
      x = fd(edge[i][0]);
      y = fd(edge[i][1]);
      if (x.first != y.first) {
        if (dsu[x.first] > dsu[y.first]) swap(x, y);
        ans -= min(info[x.first].c0, info[x.first].c1);
        ans -= min(info[y.first].c0, info[y.first].c1);
        if (co == 1) {
          if (x.second != y.second) {
            info[y.first].tag ^= 1;
            swap(info[y.first].c0, info[y.first].c1);
          }
        } else {
          if (x.second == y.second) {
            info[y.first].tag ^= 1;
            swap(info[y.first].c0, info[y.first].c1);
          }
        }
        info[x.first].c0 += info[y.first].c0;
        info[x.first].c1 += info[y.first].c1;
        info[x.first].maintain();
        ans += min(info[x.first].c0, info[x.first].c1);
        dsu[x.first] += dsu[y.first];
        dsu[y.first] = x.first;
      }
    }
    printf("%lld\n", ans);
  }
  return 0;
}
