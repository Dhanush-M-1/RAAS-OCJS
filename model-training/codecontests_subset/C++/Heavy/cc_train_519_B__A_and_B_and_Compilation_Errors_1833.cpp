#include <bits/stdc++.h>
using namespace std;
int n;
int a[100005], b[100005], c[100005];
void read() {
  scanf("%d", &n);
  for (int i = 1; i <= n; i++) scanf("%d", &a[i]);
  for (int i = 1; i < n; i++) scanf("%d", &b[i]);
  for (int i = 1; i < n - 1; i++) scanf("%d", &c[i]);
}
void solve() {
  sort(a + 1, a + n + 1);
  sort(b + 1, b + n);
  sort(c + 1, c + n - 1);
  int i;
  for (i = 1; i < n; i++)
    if (a[i] != b[i]) {
      printf("%d\n", a[i]);
      break;
    }
  if (i == n) printf("%d\n", a[n]);
  for (i = 1; i < n - 1; i++)
    if (b[i] != c[i]) {
      printf("%d\n", b[i]);
      break;
    }
  if (i == n - 1) printf("%d\n", b[n - 1]);
}
int main() {
  read();
  solve();
  return 0;
}
