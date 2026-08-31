#include <bits/stdc++.h>
using namespace std;
int a[105];
int main() {
  int n, c;
  scanf("%d%d", &n, &c);
  for (int i = 0; i < n; i++) {
    scanf("%d", a + i);
  }
  int max = 0;
  for (int i = 0; i < n - 1; i++) {
    if (a[i] - a[i + 1] > max) max = a[i] - a[i + 1];
  }
  if (max - c > 0)
    printf("%d\n", max - c);
  else
    printf("0\n");
  return 0;
}
