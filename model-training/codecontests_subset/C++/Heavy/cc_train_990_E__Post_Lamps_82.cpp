#include <bits/stdc++.h>
using namespace std;
using namespace std;
inline int read() {
  char ch;
  bool sign = 0;
  int res = 0;
  while (!isdigit(ch = getchar()))
    if (ch == '-') sign = 1;
  while (isdigit(ch)) res = res * 10 + (ch ^ 48), ch = getchar();
  if (sign)
    return -res;
  else
    return res;
}
const int maxn = 1000000 + 10;
const long long MAXN = 5000000 + 10;
const long long inf = 1e18;
const int MAXM = 3;
const int maxm = 1000 + 10;
const long long MOD[] = {469762049, 998244353, 1004535809, 1000000007};
const long long mod = 998244353;
const int apsz = 26;
const int block = 430;
int vis[maxn], n, k, m;
int a[maxn];
int can[maxn];
inline long long solve() {
  if (vis[0] == 1) return -1;
  int maxlen = 1;
  for (int l = 0; l < n;) {
    for (; l < n && vis[l] == 0;) ++l;
    int r = l;
    if (l >= n) break;
    for (; r < n && vis[r] == 1;) {
      can[r] = l - 1;
      ++r;
    }
    int now = r - l + 1;
    maxlen = max(maxlen, now);
    l = r;
  }
  long long ans = inf;
  for (int i = maxlen; i <= k; ++i) {
    long long tmp = 0;
    int j;
    for (j = 0; j < n;) {
      if (vis[j] == 0) {
        tmp += a[i];
        j += i;
      } else {
        j = can[j];
        tmp += a[i];
        j += i;
      }
    }
    ans = min(ans, tmp);
  }
  if (ans == inf) ans = -1;
  return ans;
}
int main(void) {
  scanf("%d%d%d", &n, &m, &k);
  for (auto i = (1); i <= (m); ++i) {
    int x;
    scanf("%d", &(x));
    vis[x] = 1;
  }
  for (auto i = (1); i <= (k); ++i) scanf("%d", &(a[i]));
  printf("%lld\n", solve());
  return 0;
}
