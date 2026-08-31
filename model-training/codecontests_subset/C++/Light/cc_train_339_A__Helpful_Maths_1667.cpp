#include <bits/stdc++.h>
using namespace std;
char x[1000005];
int main() {
  int i, len, c1, c2, c3;
  c1 = c2 = c3 = 0;
  scanf("%s", &x);
  len = strlen(x);
  for (i = 0; i < len; i++) {
    if (x[i] == '1') c1++;
    if (x[i] == '2') c2++;
    if (x[i] == '3') c3++;
  }
  for (i = 0; i < c1; i++) {
    printf("1");
    if (c1 + c2 + c3 - 1 > i) printf("+");
  }
  for (i = 0; i < c2; i++) {
    printf("2");
    if (c1 + c2 + c3 - 1 > i + c1) printf("+");
  }
  for (i = 0; i < c3; i++) {
    printf("3");
    if (c1 + c2 + c3 - 1 > i + c1 + c2) printf("+");
  }
  puts("");
  return 0;
}
