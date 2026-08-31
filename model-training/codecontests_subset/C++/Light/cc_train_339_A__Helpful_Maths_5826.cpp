#include <bits/stdc++.h>
using namespace std;
const int MAXN = 1e3;
char s[MAXN];
int a[MAXN];
int main(void) {
  scanf("%s", s);
  int n = strlen(s), m = 0;
  for (int i = 0; i < n; i += 2) a[m++] = s[i] - '0';
  sort(a, a + m);
  printf("%d", a[0]);
  for (int i = 1; i < m; i++) printf("+%d", a[i]);
  return 0;
}
