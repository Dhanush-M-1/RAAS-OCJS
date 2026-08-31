#include <bits/stdc++.h>
char s[200005];
int main() {
  int N;
  while (scanf("%d", &N) == 1) {
    scanf("%s", s);
    int n = 0, a = 0, f = 0;
    for (int i = 0; i < N; ++i) {
      if (s[i] == 'I') n++;
      if (s[i] == 'A') a++;
      if (s[i] == 'F') f++;
    }
    if (n >= 2) {
      puts("0");
    } else if (n == 1) {
      puts("1");
    } else if (f == 0) {
      printf("%d\n", N);
    } else
      printf("%d\n", a);
  }
  return 0;
}
