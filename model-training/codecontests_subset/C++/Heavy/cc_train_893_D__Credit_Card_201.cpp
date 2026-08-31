#include <bits/stdc++.h>
using namespace std;
struct A {
  int l, r;
  int nxl, nxr;
  int big;
  int add;
} Node[200005];
int all[200005];
int add[200005] = {0};
int now = 1;
void build(int l, int r, int here) {
  Node[here].l = l;
  Node[here].r = r;
  Node[here].add = 0;
  if (l == r) {
    Node[here].big = add[l];
    return;
  }
  Node[here].nxl = now++;
  Node[here].nxr = now++;
  build(l, (l + r) / 2, Node[here].nxl);
  build((l + r) / 2 + 1, r, Node[here].nxr);
  Node[here].big = max(Node[Node[here].nxl].big, Node[Node[here].nxr].big);
}
void UPD(int here) {
  Node[Node[here].nxl].big += Node[here].add;
  Node[Node[here].nxr].big += Node[here].add;
  Node[Node[here].nxl].add += Node[here].add;
  Node[Node[here].nxr].add += Node[here].add;
  Node[here].add = 0;
}
int Find(int l, int r, int here) {
  if (l == Node[here].l && r == Node[here].r) return Node[here].big;
  UPD(here);
  if (r <= (Node[here].l + Node[here].r) / 2)
    return Find(l, r, Node[here].nxl);
  else if (l > (Node[here].l + Node[here].r) / 2)
    return Find(l, r, Node[here].nxr);
  else
    return max(Find(l, (Node[here].l + Node[here].r) / 2, Node[here].nxl),
               Find((Node[here].l + Node[here].r) / 2 + 1, r, Node[here].nxr));
}
void Add(int l, int r, int here, int con) {
  if (l == Node[here].l && r == Node[here].r) {
    Node[here].add += con;
    Node[here].big += con;
    return;
  }
  UPD(here);
  if (r <= (Node[here].l + Node[here].r) / 2)
    Add(l, r, Node[here].nxl, con);
  else if (l > (Node[here].l + Node[here].r) / 2)
    Add(l, r, Node[here].nxr, con);
  else {
    Add(l, (Node[here].l + Node[here].r) / 2, Node[here].nxl, con);
    Add((Node[here].l + Node[here].r) / 2 + 1, r, Node[here].nxr, con);
  }
  Node[here].big = max(Node[Node[here].nxl].big, Node[Node[here].nxr].big);
}
int main() {
  int N, D, ok = 1, last = -1, i, ans = 0;
  scanf("%d %d", &N, &D);
  for (i = 1; i <= N; i++) {
    scanf("%d", &all[i]);
    add[i] = add[i - 1] + all[i];
  }
  build(0, N, 0);
  for (i = 1; i <= N; i++) {
    if (all[i] == 0) {
      if (Find(i, i, 0) >= 0) continue;
      if (last == -1 || Find(last, N, 0) + (0 - Find(i, i, 0)) > D) {
        if (Find(i, N, 0) + (0 - Find(i, i, 0)) > D)
          ok = 0;
        else {
          Add(i, N, 0, (0 - Find(i, i, 0)));
          last = i;
          ans++;
        }
      } else
        Add(last, N, 0, (0 - Find(i, i, 0)));
    }
  }
  if (Find(0, N, 0) > D) ok = 0;
  if (!ok)
    printf("-1\n");
  else
    printf("%d\n", ans);
  return 0;
}
