#include <bits/stdc++.h>
using namespace std;
const int maxn = 3000050;
int n, m;
int a[maxn], b[maxn], db[maxn];
bool can(int a, int b, int x) {
  return (a <= b && !(a <= x && x < b)) || (a > b && (x >= b && x < a));
}
int main(void) {
  memset(db, -1, sizeof(b));
  scanf("%d%d", &n, &m);
  for (int i = 1; i <= (n); ++i) scanf("%d", a + i), a[i + n] = a[i];
  for (int i = 0; i < (m); ++i) scanf("%d", b + i), db[b[i]] = i;
  for (int i = 1; i <= (n + n - 1); ++i) a[i] = db[a[i]];
  int x = 1, y = 0;
  int ans = 0;
  while (y < n + n - 1) {
    ++y;
    if (x == y) {
      if (a[x] == -1)
        x = y + 1;
      else
        ans = max(ans, 1);
      continue;
    }
    if (a[y] == -1) {
      x = y + 1;
      continue;
    }
    while (!can(a[x], a[y - 1], a[y]) && x < y) ++x;
    if (x == y) {
      if (a[x] == -1)
        x = y + 1;
      else
        ans = max(ans, 1);
    }
    ans = max(ans, y - x + 1);
  }
  cout << min(ans, min(m, n)) << endl;
}
