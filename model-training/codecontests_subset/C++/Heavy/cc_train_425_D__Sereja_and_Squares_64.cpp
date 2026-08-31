#include <bits/stdc++.h>
using namespace std;
int n, x[(100005)], y[(100005)];
vector<vector<int> > vert, hori;
bool check(int p, int q) {
  if (p >= (100005) || q >= (100005)) return false;
  vector<int>::iterator it = (lower_bound(hori[p].begin(), hori[p].end(), q));
  return (it != hori[p].end() && (*it) == q);
}
int main() {
  while (scanf("%d", &n) != EOF) {
    vert.clear();
    vert.resize((100005));
    hori.clear();
    hori.resize((100005));
    for (int i = 0; i < n; i++) {
      scanf("%d%d", &x[i], &y[i]);
      hori[x[i]].push_back(y[i]);
      vert[y[i]].push_back(x[i]);
    }
    for (int i = 0; i < (100005); i++) {
      sort(vert[i].begin(), vert[i].end());
      sort(hori[i].begin(), hori[i].end());
    }
    int ans = 0;
    for (int i = 0; i < (100005); i++) {
      int sz = hori[i].size();
      for (int j = 0; j < sz; j++) {
        int p = i;
        int q = hori[i][j];
        int sz2 = vert[q].size();
        int ind2 =
            lower_bound(vert[q].begin(), vert[q].end(), p) - vert[q].begin();
        if ((sz2 - ind2) > (sz - j)) {
          for (int k = j + 1; k < sz; k++) {
            int dis = hori[i][k] - q;
            if (check(p + dis, q) && check(p + dis, q + dis)) {
              ans++;
            }
          }
        } else {
          for (int k = ind2 + 1; k < sz2; k++) {
            int dis = vert[q][k] - p;
            if (check(p, q + dis) && check(p + dis, q + dis)) {
              ans++;
            }
          }
        }
      }
    }
    printf("%d\n", ans);
  }
  return 0;
}
