#include <bits/stdc++.h>
using namespace std;
int s[1000010], a[1000010];
int Next[1000010];
bool f[1000010];
int main() {
  int n, m, k;
  scanf("%d%d%d", &n, &m, &k);
  for (int i = 1; i <= m; ++i) {
    scanf("%d", &s[i]);
    f[s[i]] = 1;
  }
  for (int i = 1; i <= k; ++i) {
    scanf("%d", &a[i]);
  }
  Next[n] = n;
  for (int i = n - 1; i >= 0; --i) {
    if (f[i])
      Next[i] = Next[i + 1];
    else
      Next[i] = i;
  }
  long long Ans = 1ll * 1e9 * 1e9;
  for (int i = 1; i <= k; ++i) {
    int t = 0;
    int now = n;
    bool flag = false;
    while (now != 0) {
      int l = Next[(now >= i ? now - i : 0)];
      if (l >= now) {
        flag = true;
        break;
      }
      ++t;
      now = l;
    }
    if (flag == false) Ans = min(Ans, 1ll * t * a[i]);
  }
  if (Ans == 1ll * 1e9 * 1e9)
    puts("-1");
  else
    printf("%lld\n", Ans);
}
