#include <bits/stdc++.h>
using namespace std;
struct query {
  int t, l, r, v;
};
int main(void) {
  int N, M;
  bool status = true;
  scanf("%d%d", &N, &M);
  set<int> val[N + 1];
  vector<query> qq;
  int added[N + 1], array[N + 1];
  memset(added, 0, sizeof(added));
  for (int i = 1; i <= M; i++) {
    int t, l, r, v;
    scanf("%d%d%d%d", &t, &l, &r, &v);
    qq.push_back((query){t, l, r, v});
    if (t == 1) {
      for (int j = l; j <= r; j++) {
        added[j] += v;
      }
    } else {
      for (int j = l; j <= r; j++) {
        val[j].insert(v - added[j]);
      }
    }
  }
  memset(added, 0, sizeof(added));
  for (int i = 1; i <= N; i++) {
    array[i] = *val[i].begin();
  }
  for (int i = 0; i < M; i++) {
    int t = qq[i].t;
    int l = qq[i].l;
    int r = qq[i].r;
    int v = qq[i].v;
    if (t == 1) {
      for (int j = l; j <= r; j++) {
        added[j] += v;
      }
    } else {
      bool valid = false;
      for (int j = l; j <= r; j++) {
        if (array[j] + added[j] == v) {
          valid = true;
        }
      }
      if (!valid) {
        status = false;
      }
    }
  }
  if (!status) {
    printf("NO\n");
    return 0;
  }
  printf("YES\n%d", array[1]);
  for (int i = 2; i <= N; i++) {
    printf(" %d", array[i]);
  }
  printf("\n");
  return 0;
}
