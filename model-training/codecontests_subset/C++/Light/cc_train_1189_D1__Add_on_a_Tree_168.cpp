#include <bits/stdc++.h>
using namespace std;
int a[100010];
int main() {
  int n, flag = 1;
  scanf("%d", &n);
  for (int i = 1, x, y; i < n; i++) {
    scanf("%d %d", &x, &y);
    a[x]++;
    a[y]++;
  }
  for (int i = 1; i <= n; i++)
    if (a[i] == 2) flag = 0;
  flag ? printf("YES") : printf("NO");
}
