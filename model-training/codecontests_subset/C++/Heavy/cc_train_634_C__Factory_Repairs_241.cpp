#include <bits/stdc++.h>
using namespace std;
long long T[2][200005] = {0};
int n, k, a, b, q;
long long read(int x, long long tree[]) {
  long long s = 0;
  while (x > 0) {
    s += tree[x];
    x -= (x & -x);
  }
  return s;
}
void update(int x, long long tree[], long long val) {
  while (x < 200005) {
    tree[x] += val;
    x += (x & -x);
  }
}
int days[200005];
void add(int x, int mul) {
  update(x, T[0], mul * min(days[x], a));
  update(x, T[1], mul * min(days[x], b));
}
int main() {
  scanf("%d%d%d%d%d", &n, &k, &a, &b, &q);
  swap(a, b);
  while (q--) {
    int t;
    scanf("%d", &t);
    if (t == 1) {
      int idx, val;
      scanf("%d%d", &idx, &val);
      add(idx, -1);
      days[idx] += val;
      add(idx, 1);
    } else {
      int pi;
      scanf("%d", &pi);
      long long ans =
          read(pi - 1, T[0]) + read(n, T[1]) - read(pi + k - 1, T[1]);
      printf("%I64d\n", ans);
    }
  }
}
