#include <bits/stdc++.h>
using namespace std;
double PI = acos(-1);
double EPS = 1e-7;
int INF = 1000000000;
long long INFLL = 1000000000000000000LL;
int mx[8] = {-1, 1, 0, 0, -1, -1, 1, 1};
int my[8] = {0, 0, -1, 1, -1, 1, -1, 1};
vector<pair<int, pair<int, int>>> que;
int MGC = 400;
int cntPre[200005];
int cntSuf[200005];
int ori[200005];
int main() {
  int n, k, A, B, q;
  scanf("%d%d%d%d%d", &n, &k, &A, &B, &q);
  for (int(a) = (0); (a) <= (q - 1); (a)++) {
    int i, j, k;
    scanf("%d", &i);
    if (i == 1) {
      scanf("%d%d", &j, &k);
      que.push_back(make_pair(i, make_pair(j, k)));
    } else {
      scanf("%d", &j);
      que.push_back(make_pair(i, make_pair(j, 0)));
    }
  }
  vector<pair<int, int>> upd;
  for (int(a) = (0); (a) <= (q - 1); (a)++) {
    int t = que[a].first;
    if (t == 1) {
      int d = que[a].second.first;
      int x = que[a].second.second;
      upd.push_back(make_pair(d, x));
    } else {
      int p = que[a].second.first;
      unordered_map<int, int> um;
      long long ans = cntPre[p - 1];
      if (p + k <= n) ans += cntSuf[p + k];
      for (int(a) = (0); (a) <= ((int)upd.size() - 1); (a)++) {
        um[upd[a].first] += upd[a].second;
      }
      for (__typeof((um).begin()) it = (um).begin(); it != (um).end(); it++) {
        int idx = (*it).first;
        int val = (*it).second;
        if (idx < p) {
          ans -= min(ori[idx], B);
          ans += min(ori[idx] + val, B);
        } else if (idx >= p + k) {
          ans -= min(ori[idx], A);
          ans += min(ori[idx] + val, A);
        }
      }
      printf("%lld\n", ans);
    }
    if (a % MGC == 0) {
      for (int(a) = (0); (a) <= ((int)upd.size() - 1); (a)++) {
        ori[upd[a].first] += upd[a].second;
      }
      upd.clear();
      for (int(a) = (1); (a) <= (n); (a)++) {
        cntPre[a] = cntPre[a - 1] + min(ori[a], B);
      }
      for (int(a) = (n); (a) >= (1); (a)--) {
        cntSuf[a] = cntSuf[a + 1] + min(ori[a], A);
      }
    }
  }
}
