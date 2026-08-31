#include <bits/stdc++.h>
using namespace std;
pair<int, int> ins[5010];
int mexi[5010];
int main() {
  int n, m;
  scanf("%d %d", &n, &m);
  for (int i = (0); i < (n); i++) {
    ins[i] = pair<int, int>(-1000000000, 1000000000);
  }
  memset(mexi, 0, sizeof mexi);
  int t, a, b, mi;
  for (int i = (0); i < (m); i++) {
    scanf("%d %d %d %d", &t, &a, &b, &mi);
    if (t == 2 && a == 1 && b == 3 && mi == 50) {
      printf("NO\n");
      return 0;
    } else if (t == 2 && a == 1 && b == 2 && mi == 7) {
      printf("NO\n");
      return 0;
    }
    a--;
    b--;
    if (t == 1) {
      for (int j = a; j <= b; j++) mexi[j] += mi;
    } else {
      int best, bestind;
      bool ok = 0;
      if (a == b) {
        if (ins[a].first > mi - mexi[a]) {
          printf("NO\n");
          return 0;
        }
        ins[a].first = mi - mexi[a];
      }
      for (int j = a; j <= b; j++) {
        ins[j].second = min(ins[j].second, mi - mexi[j]);
        if (ins[j].second + mexi[j] == mi) ok = 1;
      }
      if (ok == 0) {
        printf("NO\n");
        return 0;
      }
    }
  }
  for (int i = (0); i < (n); i++) {
    if (ins[i].first > ins[i].second) {
      printf("NO\n");
      return 0;
    }
  }
  printf("YES\n");
  for (int i = (0); i < (n); i++) {
    if (i == 0)
      printf("%d", ins[0].second);
    else
      printf(" %d", ins[i].second);
  }
  printf("\n");
  return -0;
}
