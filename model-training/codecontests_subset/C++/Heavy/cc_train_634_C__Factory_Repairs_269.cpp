#include <bits/stdc++.h>
using namespace std;
const int N = 200001;
int cs1[N];
int cs2[N];
int ss1[N];
int ss2[N];
int sum(int i, int cs[]) {
  int s = 0;
  while (i > 0) {
    s += cs[i];
    i -= i & -i;
  }
  return s;
}
void add(int i, int k, int cs[]) {
  while (i < N) {
    cs[i] += k;
    i += i & -i;
  }
}
int main() {
  int n, k, a, b, q;
  cin >> n >> k >> a >> b >> q;
  for (int i = 0; i < q; ++i) {
    int c;
    scanf("%d", &c);
    if (c == 1) {
      int d, aa;
      scanf("%d%d", &d, &aa);
      add(d, min(aa, b - ss1[d]), cs1);
      add(d, min(aa, a - ss2[d]), cs2);
      ss1[d] = min(ss1[d] + aa, b);
      ss2[d] = min(ss2[d] + aa, a);
    } else {
      int p;
      scanf("%d", &p);
      int o = sum(n, cs2) - sum(p + k - 1, cs2) + sum(p - 1, cs1);
      printf("%d\n", o);
    }
  }
  return 0;
}
