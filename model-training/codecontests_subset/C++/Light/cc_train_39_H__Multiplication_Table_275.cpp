#include <bits/stdc++.h>
using namespace std;
const int maxn = 103;
int main() {
  int k;
  scanf("%d", &k);
  for (int i = 0; i < (int)(k); i++)
    if (i) {
      for (int j = 0; j < (int)(k); j++)
        if (j) {
          char s[20];
          int n = 0, x = i * j;
          while (!n || x) s[n++] = x % k, x /= k;
          while (n--) printf("%d", s[n]);
          printf(" ");
        }
      puts("");
    }
  return 0;
}
