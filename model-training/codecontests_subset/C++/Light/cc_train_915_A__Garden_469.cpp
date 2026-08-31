#include <bits/stdc++.h>
using namespace std;
int ans = 1 << 30;
int main() {
  int k, n;
  scanf("%d%d", &k, &n);
  for (int i = 1; i <= k; i++) {
    int a;
    cin >> a;
    if (n % a == 0) {
      ans = min(ans, n / a);
    }
  }
  printf("%d", ans);
}
