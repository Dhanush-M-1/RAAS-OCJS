#include <bits/stdc++.h>
using namespace std;
int n, m, q;
int from[500000], to[500000], w[500000], ord[500000], tmp[500000];
int c[1000], col[1000];
vector<int> cm[1000];
inline bool cmp(const int &lhs, const int &rhs) { return w[lhs] > w[rhs]; }
void reord(int *a) {
  for (int i = 0; i < (int)(m); ++i) tmp[i] = a[ord[i]];
  for (int i = 0; i < (int)(m); ++i) a[i] = tmp[i];
}
int main() {
  scanf("%d%d%d", &n, &m, &q);
  for (int i = 0; i < (int)(m); ++i)
    scanf("%d%d%d", from + i, to + i, w + i), --from[i], --to[i];
  for (int i = 0; i < (int)(m); ++i) ord[i] = i;
  sort(ord, ord + m, cmp);
  reord(from);
  reord(to);
  reord(w);
  for (int times = 0; times < (int)(q); ++times) {
    int l, r;
    scanf("%d%d", &l, &r), --l, --r;
    for (int i = 0; i < (int)(n); ++i) {
      c[i] = i;
      cm[i].clear();
      cm[i].push_back(i);
      col[i] = 0;
    }
    int ans = -1;
    for (int i = 0; i < (int)(m); ++i) {
      if (ord[i] < l || ord[i] > r) continue;
      int s = from[i];
      int t = to[i];
      if (c[s] == c[t]) {
        if (col[s] == col[t]) {
          ans = w[i];
          break;
        }
      } else {
        bool eq = col[s] == col[t];
        s = c[s];
        t = c[t];
        if (cm[s].size() < cm[t].size()) {
          swap(s, t);
        }
        if (eq) {
          for (int x : cm[t]) {
            col[x] ^= 1;
          }
        }
        for (int x : cm[t]) {
          cm[s].push_back(x);
          c[x] = s;
        }
      }
    }
    printf("%d\n", ans);
  }
  return 0;
}
