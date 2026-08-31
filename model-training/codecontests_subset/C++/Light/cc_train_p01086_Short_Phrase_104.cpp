#include <cstdio>
#include <cstring>

int l[40];

bool check(int *p, int n) {
  int i;
  for (i=0;i<n;i+=l[(*p)++]);
  return (i == n);
}

int main() {
  int n;
  while (scanf("%d", &n), n!=0) {
    for (int i=0;i<n;i++) {
      char s[11];
      scanf("%s", s);
      l[i] = strlen(s);
    }
    for (int i=0;i<n-4;i++) {
      int p = i;
      if (!check(&p, 5)) continue;
      if (!check(&p, 7)) continue;
      if (!check(&p, 5)) continue;
      if (!check(&p, 7)) continue;
      if (!check(&p, 7)) continue;
      printf("%d\n", i+1);
      break;
    }
  }
  return 0;
}