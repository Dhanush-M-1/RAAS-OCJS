#include <bits/stdc++.h>
using namespace std;
char s[103];
int main() {
  int neg = 0, pos = 1, sum = 0, k = 0, n;
  while (1) {
    char c;
    scanf(" %c %c", &c, &c);
    if (c == '=') break;
    if (c == '-')
      neg++;
    else
      pos++;
    s[k++] = c;
  }
  scanf("%d", &n);
  if (n < pos - neg * n || n > pos * n - neg)
    printf("Impossible\n");
  else {
    printf("Possible\n");
    for (int i = 0; i < k; i++) {
      int flag = 1;
      if (i > 0 && s[i - 1] == '-') flag = -1;
      if (flag == 1)
        pos--;
      else
        neg--;
      for (int j = 1; j <= n; j++) {
        if (sum + j * flag + pos - neg * n <= n &&
            n <= sum + j * flag + pos * n - neg) {
          printf("%d %c ", j, s[i]);
          sum += flag * j;
          break;
        }
      }
    }
    printf("%d = %d\n", abs(n - sum), n);
  }
  return 0;
}
