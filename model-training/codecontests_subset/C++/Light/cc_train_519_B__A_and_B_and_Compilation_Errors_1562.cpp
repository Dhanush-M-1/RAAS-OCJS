#include <bits/stdc++.h>
using namespace std;
int a[100005], b[100005], c[100005];
int n;
void Init() {
  scanf("%d", &n);
  for (int i = 1; i <= n; i++) scanf("%d", &a[i]);
  for (int i = 1; i < n; i++) scanf("%d", &b[i]);
  for (int i = 1; i < n - 1; i++) scanf("%d", &c[i]);
}
void Work() {
  sort(a + 1, a + n + 1);
  sort(b + 1, b + n);
  for (int i = 1; i <= n; i++)
    if (a[i] != b[i]) {
      printf("%d\n", a[i]);
      c[n - 1] = a[i];
      break;
    }
  sort(c + 1, c + n);
  for (int i = 1; i <= n; i++)
    if (a[i] != c[i]) {
      printf("%d\n", a[i]);
      break;
    }
}
int main() {
  Init();
  Work();
  return 0;
}
