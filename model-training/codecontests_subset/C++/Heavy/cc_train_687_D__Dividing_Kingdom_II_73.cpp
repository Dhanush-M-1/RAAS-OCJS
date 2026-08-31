#include <bits/stdc++.h>
using namespace std;
int cf[2000], tmpf[2000];
int N, M, Q;
int a[1000000], b[1000000], w[1000000];
int cid[1000000];
int find(int i) {
  if (cf[i] == i) return i;
  cf[i] = find(cf[i]);
  return cf[i];
}
bool cmp(int x, int y) { return w[x] > w[y]; }
int l, r;
int main() {
  scanf("%d %d %d", &N, &M, &Q);
  for (int i = 0; i < M; i++) {
    scanf("%d %d %d", &a[i], &b[i], &w[i]);
    a[i]--, b[i]--;
    cid[i] = i;
  }
  sort(cid, cid + M, cmp);
  int u, v;
  for (int i = 0; i < Q; i++) {
    scanf("%d %d", &l, &r);
    l--, r--;
    for (int i = 0; i < 2 * N; i++) cf[i] = i;
    bool out = 0;
    for (int j = 0; j < M; j++) {
      if (l <= cid[j] && cid[j] <= r) {
        u = a[cid[j]], v = b[cid[j]];
        if (find(u) == find(v)) {
          out = 1;
          printf("%d\n", w[cid[j]]);
          break;
        }
        cf[find(u)] = find(v + N);
        cf[find(v)] = find(u + N);
      }
    }
    if (out == 0) printf("-1\n");
  }
}
