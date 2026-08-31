#include <bits/stdc++.h>
using namespace std;
const int inf = 0x3f3f3f3f;
const int mod = 80112002;
char s[110];
int a[110];
int main() {
  scanf("%s", s);
  int len = strlen(s);
  int cnt = 0;
  for (int i = 0; i < len; i++) {
    if (s[i] >= '0' && s[i] <= '9') a[++cnt] = s[i] - '0';
  }
  sort(a + 1, a + 1 + cnt);
  for (int i = 1; i <= cnt; i++) {
    printf("%d", a[i]);
    if (i != cnt)
      printf("+");
    else
      printf("\n");
  }
  return 0;
}
