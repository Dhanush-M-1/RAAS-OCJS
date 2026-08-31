#include <bits/stdc++.h>
int main() {
  int n, af(0), r(0);
  char s[200002];
  std::scanf("%d\n", &n);
  std::fgets(s, sizeof(s), stdin);
  for (int i(0); i < n; ++i) af += (s[i] == 'A') || (s[i] == 'F');
  for (int i(0); i < n; ++i) r += (s[i] != 'F') & (n == af + (s[i] == 'I'));
  std::printf("%d\n", r);
  return 0;
}
