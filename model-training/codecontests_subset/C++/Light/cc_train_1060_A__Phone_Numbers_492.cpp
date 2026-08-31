#include <bits/stdc++.h>
using LL = long long;
int main() {
  int n;
  scanf("%d", &n);
  char s[100 + 5];
  scanf("%s", s);
  int cnt[10] = {};
  for (int i = 0; i < n; ++i) cnt[s[i] - '0']++;
  printf("%d\n", std::min(cnt[8], n / 11));
}
