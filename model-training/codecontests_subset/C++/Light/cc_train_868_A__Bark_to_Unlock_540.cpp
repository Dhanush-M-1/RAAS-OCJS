#include <bits/stdc++.h>
using namespace std;
const int N = 103;
int main() {
  char a[3], b[N][3];
  bool f1, f2;
  int n;
  while (~scanf("%s", a)) {
    f1 = f2 = 0;
    scanf("%d", &n);
    for (int i = 0; i < n; i++) {
      scanf("%s", b[i]);
      if (strcmp(b[i], a) == 0) f1 = 1, f2 = 1;
      if (b[i][0] == a[1]) f1 = 1;
      if (b[i][1] == a[0]) f2 = 1;
    }
    if (f1 == 1 && f2 == 1)
      printf("YES\n");
    else
      printf("NO\n");
  }
  return 0;
}
