#include <bits/stdc++.h>
using namespace std;
int n, m, i, ar[100005], a[100005], h[100005], q, sum1, sum2, sum3;
int main() {
  scanf("%d", &n);
  for (int i = 1; i <= n; i++) scanf("%d", &ar[i]), sum1 += ar[i];
  for (int i = 1; i < n; i++) scanf("%d", &ar[i]), sum2 += ar[i];
  for (int i = 1; i < n - 1; i++) scanf("%d", &ar[i]), sum3 += ar[i];
  printf("%d\n%d", sum1 - sum2, sum2 - sum3);
}
