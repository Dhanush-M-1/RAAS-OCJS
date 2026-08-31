#include <bits/stdc++.h>
using namespace std;
int n, x[100001], h[100001], f0[100001], f1[100001], f2[100001];
int main() {
  scanf("%d", &n);
  for (int i = 1; i <= n; i++) scanf("%d%d", x + i, h + i);
  f0[1] = 0;
  f1[1] = 1;
  f2[1] = (x[2] - x[1] >= h[1]) ? 1 : 0;
  for (int i = 2; i <= n; i++) {
    f0[i] = max(f0[i - 1], max(f1[i - 1], f2[i - 1]));
    f1[i] = max(f0[i - 1], max(f1[i - 1], f2[i - 1]));
    if (x[i] - x[i - 1] > h[i] + h[i - 1])
      f1[i] = max(f0[i - 1], max(f1[i - 1], f2[i - 1])) + 1;
    else if (x[i] - x[i - 1] > h[i])
      f1[i] = max(f0[i - 1], f1[i - 1]) + 1;
    f2[i] = max(f0[i - 1], max(f1[i - 1], f2[i - 1]));
    if (i == n || x[i + 1] - x[i] > h[i]) f2[i]++;
  }
  printf("%d", max(f0[n], max(f1[n], f2[n])));
}
