#include <bits/stdc++.h>
using namespace std;
struct node {
  int id, x;
} a[202020], b[202020];
int n, S, doe, cnt;
int fa[202020], size[202020], r[202020], id[202020];
vector<int> col[202020];
bool br[202020];
bool cmp_id(node u, node w) { return u.id < w.id; }
bool cmp_x(node u, node w) { return u.x < w.x; }
int find(int x) {
  if (fa[x] == x) return x;
  fa[x] = find(fa[x]);
  return fa[x];
}
void merge(int x, int y) {
  x = find(x);
  y = find(y);
  if (x != y) {
    fa[y] = x;
    size[x] += size[y];
  }
}
void init() {
  sort(a + 1, a + 1 + n, cmp_x);
  for (int i = 1; i <= n; ++i) b[i] = a[i];
  b[1].x = 1;
  for (int i = 2; i <= n; ++i) {
    if (a[i].x == a[i - 1].x)
      b[i].x = b[i - 1].x;
    else
      b[i].x = b[i - 1].x + 1;
  }
  for (int i = 1; i <= n; ++i) a[i].x = b[i].x, id[a[i].id] = i;
  sort(a + 1, a + 1 + n, cmp_id);
}
void together(int k) {
  int len = col[k].size(), x = col[k][0];
  for (int i = 1; i < len; ++i) {
    int y = col[k][i];
    if (find(x) != find(y)) {
      swap(r[x], r[y]);
      merge(x, y);
    }
    x = y;
  }
}
void write(int x) {
  if (br[x]) return;
  int y = x;
  while (1) {
    printf("%d ", y);
    --doe;
    y = r[y];
    if (y == x) return;
  }
}
int main() {
  scanf("%d%d", &n, &S);
  for (int i = 1; i <= n; ++i) fa[i] = i, r[i] = i, size[i] = 1;
  for (int i = 1; i <= n; ++i) scanf("%d", &a[i].x), a[i].id = i;
  init();
  for (int i = 1; i <= n; ++i)
    if (a[i].x == b[i].x && a[i].id != b[i].id) {
      int x = i, y = id[i];
      swap(id[b[x].id], id[b[y].id]);
      swap(b[x], b[y]);
    }
  for (int i = 1; i <= n; ++i)
    if (a[i].x != b[i].x) {
      ++doe;
      int x = a[i].id, y = b[i].id;
      r[y] = x;
      merge(x, y);
    }
  for (int i = 1; i <= n; ++i)
    if (size[find(i)] != 1) col[a[i].x].push_back(i);
  for (int i = 1; i <= n; ++i)
    if (col[i].size() > 1) together(i);
  for (int i = 1; i <= n; ++i)
    if (find(i) == i && size[i] != 1) ++cnt;
  if (doe > S) {
    printf("-1\n");
    return 0;
  }
  if (cnt == 0) {
    printf("0\n");
    return 0;
  }
  if (cnt == 1) {
    printf("1\n");
    printf("%d\n", doe);
    for (int i = 1; i <= n; ++i)
      if (find(i) == i && size[i] != 1) write(i);
    printf("\n");
    return 0;
  }
  if (doe + cnt <= S) {
    if (cnt == 1)
      printf("1\n");
    else
      printf("2\n");
  } else {
    if (S - doe == 1)
      printf("%d\n", cnt);
    else if (doe == S)
      printf("%d\n", cnt);
    else
      printf("%d\n", (doe + cnt - S) + 2);
  }
  int kkk = doe + cnt - S;
  for (int i = 1; i <= n && kkk > 0; ++i)
    if (find(i) == i && size[i] != 1) {
      printf("%d\n", size[i]);
      write(i);
      printf("\n");
      br[i] = 1;
      --kkk;
      --cnt;
    }
  if (cnt == 0) return 0;
  printf("%d\n", doe);
  for (int i = 1; i <= n; ++i)
    if (find(i) == i && br[i] == 0 && size[i] != 1) write(i);
  printf("\n");
  if (cnt == 1) return 0;
  printf("%d\n", cnt);
  for (int i = n; i >= 1; --i)
    if (find(i) == i && br[i] == 0 && size[i] != 1) printf("%d ", i);
  printf("\n");
  return 0;
}
