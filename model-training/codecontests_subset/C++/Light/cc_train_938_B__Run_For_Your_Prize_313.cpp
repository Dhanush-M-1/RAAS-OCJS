#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  scanf("%d", &n);
  int ans = 0;
  for (int i = 0; i < n; i++) {
    int x;
    scanf("%d", &x);
    ans = max(ans, min(abs(1 - x), abs(1000000 - x)));
  }
  printf("%d", ans);
  return 0;
}
