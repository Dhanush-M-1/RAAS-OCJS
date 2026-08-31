#include <bits/stdc++.h>
using namespace std;
int n, cnt8;
char s[110];
int main() {
  cin >> n;
  cnt8 = 0;
  scanf("%s", s + 1);
  for (int i = 1; i <= n; ++i)
    if (s[i] == '8') ++cnt8;
  int ans = 0;
  while (cnt8 > 0 && n >= 11) ++ans, --cnt8, n -= 11;
  printf("%d\n", ans);
  return 0;
}
