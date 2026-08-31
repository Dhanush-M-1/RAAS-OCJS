#include <bits/stdc++.h>
using namespace std;
const int maxn = 1005;
char s[maxn];
int cnt[26];
int main() {
  int i, j, k;
  scanf("%d", &k);
  scanf("%s", s);
  memset(cnt, 0, sizeof(cnt));
  for (i = 0; s[i]; ++i) ++cnt[s[i] - 'a'];
  int len = i;
  bool flag = (len % k == 0);
  if (flag) {
    int l = len / k;
    for (i = 0; flag && i < 26; ++i) flag = (cnt[i] % k == 0);
    if (flag) {
      int b = 0, n;
      for (i = 0; i < 26; ++i) {
        if (cnt[i]) {
          n = cnt[i] / k;
          while (n--) {
            for (j = b; j < len; j += l) s[j] = i + 'a';
            ++b;
          }
        }
      }
    }
  }
  if (flag)
    puts(s);
  else
    puts("-1");
  return 0;
}
