#include <bits/stdc++.h>
using namespace std;
int maxv[5000];
int totald[5000];
struct op {
  int t, l, r, d;
};
op ops[5000];
int main(void) {
  int n, m;
  scanf("%d%d", &n, &m);
  for (int i = 0; i < n; i++) maxv[i] = 1000000000;
  for (int i = 0; i < m; i++) {
    scanf("%d%d%d%d", &ops[i].t, &ops[i].l, &ops[i].r, &ops[i].d);
    if (ops[i].t == 1) {
      for (int j = ops[i].l - 1; j < ops[i].r; j++) {
        totald[j] += ops[i].d;
      }
    } else {
      for (int j = ops[i].l - 1; j < ops[i].r; j++) {
        maxv[j] = min(maxv[j], ops[i].d - totald[j]);
      }
    }
  }
  for (int i = 0; i < n; i++) {
    if (maxv[i] > 1000000000 || maxv[i] < -1000000000) {
      printf("NO");
      return 0;
    }
    totald[i] = maxv[i];
  }
  for (int i = 0; i < m; i++) {
    if (ops[i].t == 1) {
      for (int j = ops[i].l - 1; j < ops[i].r; j++) {
        totald[j] += ops[i].d;
      }
    } else {
      int mymax = INT_MIN;
      for (int j = ops[i].l - 1; j < ops[i].r; j++) {
        mymax = max(mymax, totald[j]);
      }
      if (mymax != ops[i].d) {
        printf("NO");
        return 0;
      }
    }
  }
  printf("YES\n");
  for (int i = 0; i < n; i++) printf("%d ", maxv[i]);
}
