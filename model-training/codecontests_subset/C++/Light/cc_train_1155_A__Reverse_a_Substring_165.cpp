#include <bits/stdc++.h>
using namespace std;
const int maxn = 3e5 + 5;
char c[maxn];
int main() {
  int n, ma = -1, pos;
  scanf("%d%s", &n, c + 1);
  for (int i = 1; i <= n; i++) {
    if (c[i] - 'a' > ma) {
      ma = c[i] - 'a';
      pos = i;
    } else if (c[i] - 'a' < ma) {
      printf("YES\n");
      printf("%d %d", pos, i);
      return 0;
    }
  }
  printf("NO");
}
