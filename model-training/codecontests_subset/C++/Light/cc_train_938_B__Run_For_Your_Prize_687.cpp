#include <bits/stdc++.h>
using namespace std;
const int maxn = 100010;
int a[maxn];
int maxx = 1, minn = 1000000;
int main() {
  int n;
  scanf("%d", &n);
  for (int i = 1; i <= n; i++) {
    scanf("%d", &a[i]);
    if (a[i] <= 500000)
      maxx = max(maxx, a[i]);
    else
      minn = min(minn, a[i]);
  }
  printf("%d", max(maxx - 1, 1000000 - minn));
  return 0;
}
