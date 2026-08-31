#include <bits/stdc++.h>
int a[1010], b[1010], rank[1010];
bool c[1010], d[1010];
int find(int k) {
  if (b[k] != k) b[k] = find(b[k]);
  return b[k];
}
int front(int k) {
  int ans = 1;
  while (a[k] != 0) {
    k = a[k];
    ans++;
  }
  return ans;
}
int main() {
  int i, j, n, x, s, t, ans;
  scanf("%d%d", &n, &x);
  memset(c, false, sizeof(c));
  memset(d, false, sizeof(d));
  for (i = 1; i <= n; i++) {
    rank[i] = 1;
    b[i] = i;
  }
  for (i = 1; i <= n; i++) {
    scanf("%d", &a[i]);
    if (a[i] != 0) {
      s = find(a[i]);
      t = find(i);
      if (s != t) {
        b[s] = t;
        rank[t] += rank[s];
      }
    }
  }
  t = find(x);
  c[0] = true;
  for (i = 1; i <= n; i++) {
    s = find(i);
    if ((s != t) && (d[s] == false)) {
      for (j = n - rank[s]; j >= 0; j--)
        if (c[j] == true) c[j + rank[s]] = true;
      d[s] = true;
    }
  }
  ans = front(x);
  for (i = 0; i <= n; i++)
    if ((c[i] == true) && (i + ans <= n)) printf("%d\n", i + ans);
  return 0;
}
