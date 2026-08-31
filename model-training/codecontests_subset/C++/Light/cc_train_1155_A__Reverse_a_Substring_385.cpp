#include <bits/stdc++.h>
int main() {
  size_t n;
  scanf("%zu", &n);
  char buf[300010];
  scanf("%s", buf);
  std::string s = buf;
  for (size_t i = 1; i < n; ++i)
    if (s[i - 1] > s[i]) {
      std::swap(s[i - 1], s[i]);
      puts("YES");
      printf("%zu %zu\n", i, i + 1);
      return 0;
    }
  puts("NO");
}
