#include <bits/stdc++.h>
using namespace std;
int a, b, c, ans;
int main() {
  scanf("%d%d", &a, &b);
  while (a) {
    ans += a;
    int t = a + c;
    a = t / b;
    c = t % b;
  }
  printf("%d\n", ans);
  return 0;
}
