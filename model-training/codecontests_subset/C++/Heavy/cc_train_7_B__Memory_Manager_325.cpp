#include <bits/stdc++.h>
using namespace std;
const int maxn = 1e5 + 20;
const int mod = 1000000007;
int T;
int n, m;
char str[20];
int a[110], tot(1);
long long t;
int main() {
  T = 1;
  for (int T1 = 1; T1 <= T; T1++) {
    scanf("%d %d", &n, &m);
    for (int k = 1; k <= n; k++) {
      scanf("%s", str);
      if (str[0] == 'a') {
        scanf("%lld", &t);
        int cnt(0);
        for (int i = 1; i <= m; i++) {
          if (!a[i])
            cnt++;
          else
            cnt = 0;
          if (cnt == t) {
            while (t) {
              a[i - t + 1] = tot;
              t--;
            }
            break;
          }
        }
        if (t)
          puts("NULL");
        else
          printf("%d\n", tot++);
      } else if (str[0] == 'e') {
        scanf("%lld", &t);
        if (t <= 0 || t > n) {
          puts("ILLEGAL_ERASE_ARGUMENT");
          continue;
        }
        int ff(0);
        for (int i = 1; i <= m; i++) {
          if (a[i] == t) ff = 1, a[i] = 0;
        }
        if (!ff) puts("ILLEGAL_ERASE_ARGUMENT");
      } else {
        for (int i = 2; i <= m; i++) {
          if (a[i]) {
            int j = i - 1;
            while (j && !a[j]) {
              a[j] = a[j + 1];
              a[j + 1] = 0;
              j--;
            }
          }
        }
      }
    }
  }
  return 0;
}
