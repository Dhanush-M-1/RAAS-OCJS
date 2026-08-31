#include <bits/stdc++.h>
using namespace std;
int main() {
  int a, b, c;
  int ans;
  scanf("%d%d%d", &a, &b, &c);
  ans = (a - b) * c;
  if (!(ans % b))
    ans /= b;
  else {
    ans /= b;
    ans += 1;
  }
  printf("%d\n", ans);
  return 0;
}
