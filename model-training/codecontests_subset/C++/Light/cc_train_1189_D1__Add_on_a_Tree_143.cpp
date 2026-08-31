#include <bits/stdc++.h>
using namespace std;
const int N = 2e5 + 10;
int a[N];
int main() {
  int n;
  scanf("%d", &n);
  for (int i = 1; i < n; i++) {
    int x, y;
    scanf("%d%d", &x, &y);
    a[x]++;
    a[y]++;
  }
  for (int i = 1; i <= n; i++)
    if (a[i] == 2) {
      printf("NO\n");
      return 0;
    }
  printf("YES\n");
  return 0;
}
