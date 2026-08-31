#include <bits/stdc++.h>
using namespace std;
char str[105], c[105];
int a[105];
int main() {
  scanf("%s", str);
  int cnt = 0;
  for (int i = 0; i < strlen(str); i++) {
    if (str[i] >= '0' && str[i] <= '9') a[cnt++] = str[i] - '0';
  }
  sort(a, a + cnt);
  for (int i = 0; i < cnt - 1; i++) {
    printf("%d+", a[i]);
  }
  printf("%d\n", a[cnt - 1]);
  return 0;
}
