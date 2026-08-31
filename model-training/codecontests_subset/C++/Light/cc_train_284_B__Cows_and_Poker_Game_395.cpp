#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  scanf("%d", &n);
  getchar();
  int a = 0, f = 0, in = 0;
  for (int i = 0; i < (n); ++i) {
    char t;
    scanf("%c", &t);
    if (t == 'A') a++;
    if (t == 'I') in++;
    if (t == 'F') f++;
  }
  if (in > 1)
    printf("0\n");
  else {
    if (in == 1)
      printf("1\n");
    else {
      printf("%d\n", a);
    }
  }
  return 0;
}
