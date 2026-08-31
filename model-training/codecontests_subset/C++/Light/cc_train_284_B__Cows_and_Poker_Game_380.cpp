#include <bits/stdc++.h>
using namespace std;
char a[300000];
int main() {
  int n;
  while (scanf("%d", &n) != EOF) {
    scanf("%s", a);
    int len = strlen(a);
    int ii = 0, aa = 0;
    for (int i = 0; i < len; ++i) {
      if (a[i] == 'I')
        ii++;
      else if (a[i] == 'A')
        aa++;
    }
    if (ii == 0)
      printf("%d\n", aa);
    else if (ii == 1)
      printf("1\n");
    else
      printf("0\n");
  }
  return 0;
}
