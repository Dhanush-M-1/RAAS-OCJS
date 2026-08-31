#include <bits/stdc++.h>
using namespace std;
int sf = 0;
struct pr {
  int x, y;
  pr(int xe = 0, int ye = 0) {
    x = xe;
    y = ye;
  }
  bool operator<(const pr& p) const {
    if (sf == 0) {
      if (x != p.x) return x < p.x;
      return y < p.y;
    }
    if (sf == 1) {
      if (y != p.y) return y < p.y;
      return x < p.x;
    }
    if (sf == 2) {
      if (y - x != p.y - p.x) return y - x < p.y - p.x;
      return x < p.x;
    }
    return 0;
  }
  bool eq(const pr& p) {
    if (sf == 2) return y - x == p.y - p.x;
    if (sf == 0) return x == p.x;
    if (sf == 1) return y == p.y;
  }
  int dst(int tp, pr& p) {
    if (tp == 0) return p.y - y;
    return p.x - x;
  }
};
pr a[3][100005];
int p[3], e[3];
int Check(pr st) {
  int res = 0;
  while (p[0] < e[0] && p[1] < e[1] && p[2] < e[2]) {
    if (st.dst(0, a[0][p[0]]) == st.dst(1, a[1][p[1]]) &&
        st.dst(0, a[0][p[0]]) == st.dst(2, a[2][p[2]])) {
      p[0]++;
      p[1]++;
      p[2]++;
      res++;
      continue;
    }
    if (st.dst(0, a[0][p[0]]) < st.dst(1, a[1][p[1]]) &&
        st.dst(0, a[0][p[0]]) < st.dst(2, a[2][p[2]])) {
      p[0]++;
      continue;
    }
    if (st.dst(0, a[0][p[0]]) > st.dst(1, a[1][p[1]]) &&
        st.dst(1, a[1][p[1]]) < st.dst(2, a[2][p[2]])) {
      p[1]++;
      continue;
    }
    if (st.dst(2, a[2][p[2]]) < st.dst(1, a[1][p[1]]) &&
        st.dst(1, a[1][p[1]]) > st.dst(2, a[2][p[2]])) {
      p[2]++;
      continue;
    }
    if (st.dst(0, a[0][p[0]]) == st.dst(1, a[1][p[1]])) {
      p[0]++;
      p[1]++;
      continue;
    }
    if (st.dst(2, a[2][p[2]]) == st.dst(1, a[1][p[1]])) {
      p[2]++;
      p[1]++;
      continue;
    }
    if (st.dst(2, a[2][p[2]]) == st.dst(0, a[0][p[0]])) {
      p[2]++;
      p[0]++;
      continue;
    }
  }
  return res;
}
int main() {
  int n;
  scanf("%d", &n);
  for (int i = 0; i < n; i++) {
    scanf("%d%d", &a[0][i].x, &a[0][i].y);
    a[1][i] = a[2][i] = a[0][i];
  }
  long long res = 0;
  for (int i = 0; i < 3; i++) {
    sf = i;
    sort(a[i], a[i] + n);
  }
  for (int i = 0; i < n; i++) {
    for (int j = 0; j < 3; j++) {
      sf = j;
      p[j] = lower_bound(a[j], a[j] + n, a[0][i]) - a[j] + 1;
      if (j == 0)
        e[j] = lower_bound(a[j], a[j] + n, pr(a[0][i].x + 1, -1000000)) - a[j];
      if (j == 1)
        e[j] = lower_bound(a[j], a[j] + n, pr(-1000000, a[0][i].y + 1)) - a[j];
      if (j == 2)
        e[j] =
            lower_bound(a[j], a[j] + n,
                        pr(-1000000, -1000000 + (a[0][i].y - a[0][i].x + 1))) -
            a[j];
    }
    res += Check(a[0][i]);
  }
  printf("%I64d\n", res);
  return 0;
}
