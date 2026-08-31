#include <bits/stdc++.h>
using namespace std;
int n, x[100001], h[100001];
int main() {
  scanf("%d", &n);
  for (int i = 1; i <= n; i++) scanf("%d%d", &x[i], &h[i]);
  int cnt = 0;
  for (int i = 2; i <= n - 1; i++)
    if (x[i] - x[i - 1] > h[i])
      cnt++;
    else if (x[i + 1] - x[i] > h[i]) {
      cnt++;
      x[i] += h[i];
    }
  if (n == 1)
    cnt = 1;
  else
    cnt += 2;
  printf("%d\n", cnt);
  return 0;
}
