#include <bits/stdc++.h>
using namespace std;
struct DS {
  int rank, cost, parent;
  bool forced;
} ds[4 * 300100];
int ans;
char status[300100];
vector<int> subs[300100];
int neg(int n) { return n + 300100; }
int find(int n) {
  if (n == ds[n].parent) return n;
  return ds[n].parent = find(ds[n].parent);
}
void join(int n1, int n2) {
  int s1 = find(n1), s2 = find(n2);
  if (s1 != s2) {
    if (ds[s1].rank < ds[s2].rank) swap(s1, s2);
    ds[s2].parent = s1;
    ds[s1].cost += ds[s2].cost;
    ds[s1].rank += ds[s2].rank;
    ds[s1].forced |= ds[s2].forced;
  }
}
int main() {
  int n, k, qtd, v, s1, s2, ns1, ns2, mini;
  scanf("%d %d", &n, &k);
  getchar();
  scanf("%s", status);
  for (int i = 0; i < k; i++) {
    scanf("%d", &qtd);
    for (int j = 0; j < qtd; j++) {
      scanf("%d", &v);
      subs[v].emplace_back(i);
    }
    ds[i].rank = 1;
    ds[i].cost = 1;
    ds[i].parent = i;
    ds[i].forced = false;
    ds[neg(i)].rank = 1;
    ds[neg(i)].cost = 0;
    ds[neg(i)].parent = neg(i);
    ds[neg(i)].forced = false;
  }
  for (int i = 1; i <= n; i++) {
    if (status[i - 1] == '1') {
      if (subs[i].size() == 2) {
        s1 = find(subs[i][0]);
        s2 = find(subs[i][1]);
        ns1 = find(neg(subs[i][0]));
        ns2 = find(neg(subs[i][1]));
        mini = -1;
        if (ds[s1].forced) ans -= ds[s1].cost, mini = 0;
        if (ds[ns1].forced) ans -= ds[ns1].cost, mini = 0;
        if (mini == -1) {
          mini = min(ds[s1].cost, ds[ns1].cost);
          ans -= mini;
        }
        mini = -1;
        if (ds[s2].forced and s1 != s2 and ns1 != s2)
          ans -= ds[s2].cost, mini = 0;
        if (ds[ns2].forced and s1 != ns2 and ns1 != ns2)
          ans -= ds[ns2].cost, mini = 0;
        if (mini == -1 and s1 != s2 and s1 != ns2 and ns1 != s2 and
            ns1 != ns2) {
          mini = min(ds[s2].cost, ds[ns2].cost);
          ans -= mini;
        }
        join(s1, s2);
        join(ns1, ns2);
        s1 = find(subs[i][0]);
        s2 = find(subs[i][1]);
        ns1 = find(neg(subs[i][0]));
        ns2 = find(neg(subs[i][1]));
        mini = -1;
        if (ds[s1].forced) ans += ds[s1].cost, mini = 0;
        if (ds[ns1].forced) ans += ds[ns1].cost, mini = 0;
        if (mini == -1) mini = min(ds[s1].cost, ds[ns1].cost);
        ans += mini;
      } else {
        if (subs[i].size() == 1) {
          s1 = find(subs[i][0]);
          ns1 = find(neg(subs[i][0]));
          if (not ds[ns1].forced) {
            ans -= min(ds[s1].cost, ds[ns1].cost);
            ds[ns1].forced = true;
            ans += ds[ns1].cost;
          }
        }
      }
    } else {
      if (subs[i].size() == 2) {
        s1 = find(subs[i][0]);
        ns2 = find(neg(subs[i][1]));
        ns1 = find(neg(subs[i][0]));
        s2 = find(subs[i][1]);
        mini = -1;
        if (ds[s1].forced) ans -= ds[s1].cost, mini = 0;
        if (ds[ns1].forced) ans -= ds[ns1].cost, mini = 0;
        if (mini == -1) {
          mini = min(ds[s1].cost, ds[ns1].cost);
          ans -= mini;
        }
        mini = -1;
        if (ds[s2].forced and s1 != s2 and ns1 != s2)
          ans -= ds[s2].cost, mini = 0;
        if (ds[ns2].forced and s1 != ns2 and ns1 != ns2)
          ans -= ds[ns2].cost, mini = 0;
        if (mini == -1 and s1 != s2 and s1 != ns2 and ns1 != s2 and
            ns1 != ns2) {
          mini = min(ds[s2].cost, ds[ns2].cost);
          ans -= mini;
        }
        join(s1, ns2);
        join(ns1, s2);
        s1 = find(subs[i][0]);
        ns2 = find(neg(subs[i][1]));
        ns1 = find(neg(subs[i][0]));
        s2 = find(subs[i][1]);
        mini = -1;
        if (ds[s1].forced) ans += ds[s1].cost, mini = 0;
        if (ds[ns1].forced) ans += ds[ns1].cost, mini = 0;
        if (mini == -1) mini = min(ds[s1].cost, ds[ns1].cost);
        ans += mini;
      } else {
        if (subs[i].size() == 1) {
          s1 = find(subs[i][0]);
          ns1 = find(neg(subs[i][0]));
          if (not ds[s1].forced) {
            ans -= min(ds[s1].cost, ds[ns1].cost);
            ds[s1].forced = true;
            ans += ds[s1].cost;
          }
        }
      }
    }
    printf("%d\n", ans);
  }
  return 0;
}
