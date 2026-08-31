#include <bits/stdc++.h>
using namespace std;
int n;
long long l, r;
long long curlen;
void add(int u) {
  curlen++;
  if (l <= curlen && curlen <= r) printf("%d ", u);
  return;
}
void Add(int u) {
  int cnt = (n - u) * 2;
  if (curlen + cnt >= l && curlen < r) {
    for (int i = u + 1; i <= n; i++) {
      add(u);
      add(i);
    }
  } else
    curlen += cnt;
  return;
}
void solve() {
  scanf("%d %I64d %I64d", &n, &l, &r);
  curlen = 0;
  for (int i = 1; i < n; i++) Add(i);
  add(1);
  printf("\n");
  return;
}
int main() {
  int t;
  scanf("%d", &t);
  while (t--) solve();
  return 0;
}
