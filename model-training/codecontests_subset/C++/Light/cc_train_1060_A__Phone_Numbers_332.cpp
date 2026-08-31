#include <bits/stdc++.h>
using namespace std;
int main() {
  static char s[1000];
  int ns;
  scanf("%d%s", &ns, s);
  int ans = 0;
  for (int i = 0; i < ns; ++i) {
    if (s[i] == '8') ++ans;
  }
  ans = min(ans, ns / 11);
  printf("%d\n", ans);
  return 0;
}
