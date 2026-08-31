#include <bits/stdc++.h>
struct fur {
  int a, b, i;
  long long ans;
  bool operator<(fur k) const { return a < k.a; }
} ans[111111];
struct Trees {
  long long a, b, lazy;
} tree[1111111];
int totree[1111111], tonum[1111111], fa[1111111], lfa[1111111], treetot,
    line[1111111], right[1111111], next[1111111], tail[1111111], val[1111111],
    num[1111111], n, tot, q, ansstart[1111111], done[1111111], nowat;
long long inilength[1111111];
bool cmp(fur x, fur y) { return x.i < y.i; }
void dfs(int k, long long length) {
  totree[k] = ++treetot;
  tonum[treetot] = k;
  line[++line[0]] = k;
  right[k] = k;
  inilength[k] = length;
  for (int i = next[k]; i; i = next[i])
    if (fa[k] != num[i]) {
      fa[num[i]] = k;
      lfa[num[i]] = val[i];
      dfs(num[i], length + val[i]);
      right[k] = right[num[i]];
    }
  line[++line[0]] = k;
}
void ini(int now, int l, int r) {
  if (l == r) {
    tree[now].b = inilength[tonum[l]] % 1000000007;
    tree[now].a = (tree[now].b * tree[now].b % 1000000007);
    return;
  }
  int p = (l + r) / 2;
  ini(now * 2, l, p);
  ini(now * 2 + 1, p + 1, r);
  tree[now].a = (tree[now * 2].a + tree[now * 2 + 1].a) % 1000000007;
  tree[now].b = (tree[now * 2].b + tree[now * 2 + 1].b) % 1000000007;
}
void push_lazy(int now, int num) {
  if (!tree[now].lazy) return;
  tree[now].lazy %= 1000000007;
  tree[now * 2].lazy += tree[now].lazy;
  tree[now * 2 + 1].lazy += tree[now].lazy;
  tree[now].b += num * tree[now].lazy % 1000000007 + 1000000007;
  tree[now].a += (tree[now].lazy * tree[now].b * 2 -
                  num * tree[now].lazy % 1000000007 * tree[now].lazy) %
                     1000000007 +
                 1000000007;
  tree[now].a %= 1000000007;
  tree[now].b %= 1000000007;
  tree[now].lazy = 0;
}
void change(int now, int l, int r, int x, int y, int num) {
  if (x == l && y == r) {
    tree[now].lazy += num;
    return;
  }
  int p = (l + r) / 2;
  push_lazy(now, r - l + 1);
  if (y <= p)
    change(now * 2, l, p, x, y, num);
  else if (x > p)
    change(now * 2 + 1, p + 1, r, x, y, num);
  else {
    change(now * 2, l, p, x, p, num);
    change(now * 2 + 1, p + 1, r, p + 1, y, num);
  }
  push_lazy(now * 2, p - l + 1);
  push_lazy(now * 2 + 1, r - p);
  tree[now].a = (tree[now * 2].a + tree[now * 2 + 1].a) % 1000000007;
  tree[now].b = (tree[now * 2].b + tree[now * 2 + 1].b) % 1000000007;
}
long long find(int now, int l, int r, int x, int y) {
  push_lazy(now, r - l + 1);
  if (l == x && r == y) return tree[now].a;
  int p = (l + r) / 2;
  if (y <= p) return find(now * 2, l, p, x, y);
  if (x > p) return find(now * 2 + 1, p + 1, r, x, y);
  return (find(now * 2, l, p, x, p) + find(now * 2 + 1, p + 1, r, p + 1, y)) %
         1000000007;
}
void Output() {
  for (int i = 1; i <= n * 2; i++)
    printf("[%3d %2d %2d %2d]  ", i, tree[i].a, tree[i].b, tree[i].lazy);
  printf("\n");
}
int main() {
  scanf("%d", &n);
  for (tot = 1; tot <= n; tot++) tail[tot] = tot;
  for (int i = 1; i < n; i++) {
    int t1, t2, t3;
    scanf("%d%d%d", &t1, &t2, &t3);
    num[tail[t1] = next[tail[t1]] = ++tot] = t2;
    val[tot] = t3;
    ;
    num[tail[t2] = next[tail[t2]] = ++tot] = t1;
    val[tot] = t3;
    ;
  }
  dfs(1, 0);
  ini(1, 1, n);
  scanf("%d", &q);
  for (int i = 1; i <= q; i++) {
    scanf("%d%d", &ans[i].a, &ans[i].b);
    ans[i].i = i;
  }
  std::sort(ans + 1, ans + q + 1);
  for (int i = q; i >= 1; i--) ansstart[ans[i].a] = i;
  done[1] = 1;
  nowat = 1;
  for (int i = 2; i <= line[0]; i++) {
    if (done[line[i]]) {
      int delta = lfa[line[i]];
      change(1, 1, n, 1, n, -delta);
      change(1, 1, n, totree[line[i]], totree[right[line[i]]], 2 * delta);
      nowat = fa[line[i]];
    } else {
      int delta = lfa[line[i]];
      change(1, 1, n, 1, n, delta);
      change(1, 1, n, totree[line[i]], totree[right[line[i]]], -2 * delta);
      nowat = line[i];
      done[line[i]] = 1;
    }
    for (int j = ansstart[nowat]; j && ans[j].a == ans[ansstart[nowat]].a; j++)
      if (!ans[j].ans) {
        long long minus =
            find(1, 1, n, totree[ans[j].b], totree[right[ans[j].b]]);
        ans[j].ans = (minus * 2 - tree[1].a + 1000000007) % 1000000007;
      }
  }
  std::sort(ans + 1, ans + q + 1, cmp);
  for (int i = 1; i <= q; i++) printf("%I64d\n", ans[i].ans);
}
