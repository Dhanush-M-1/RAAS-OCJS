#include <bits/stdc++.h>
using namespace std;
const int maxn = 300000 + 10;
const int apsz = 26;
const int INF = 10000007;
const unsigned long long mod = 97;
const int maxm = 10000 + 10;
int n, k;
char s[maxn];
int st[maxn];
vector<int> epos[maxn];
int cnt[maxn << 1];
int fa[maxn << 1];
int fd(int x) { return x == fa[x] ? x : fa[x] = fd(fa[x]); }
inline int calc(int x) {
  int y = x + k;
  x = fd(x), y = fd(y);
  if (y == 0 || x == 0) return cnt[x + y];
  return min(cnt[x], cnt[y]);
}
void merge(int x, int y) {
  x = fd(x), y = fd(y);
  if (x == y) return;
  if (y == 0) swap(x, y);
  fa[y] = x;
  if (x) cnt[x] += cnt[y];
}
int main(void) {
  scanf("%d", &(n)), scanf("%d", &(k));
  scanf("%s", s + 1);
  for (int i = (1); i <= (n); ++i) st[i] = s[i] - '0';
  for (int i = (1); i <= (k); ++i) {
    int sz, x;
    scanf("%d", &(sz));
    for (; sz--;) {
      scanf("%d", &(x));
      epos[x].push_back(i);
    }
  }
  for (int i = (1); i <= (k * 2); ++i) fa[i] = i;
  for (int i = (1); i <= (k); ++i) cnt[i] = 1;
  int ans = 0;
  for (int i = (1); i <= (n); ++i) {
    if (epos[i].size() == 1) {
      int u = epos[i][0];
      ans -= calc(u);
      if (st[i] == 0)
        fa[fd(u + k)] = 0;
      else
        fa[fd(u)] = 0;
      ans += calc(u);
    } else if (epos[i].size() == 2) {
      int y, x;
      x = epos[i][0], y = epos[i][1];
      if (st[i] == 1) {
        if (fd(x) != fd(y) || fd(x + k) != fd(y + k)) {
          ans -= calc(x) + calc(y);
          merge(x, y), merge(x + k, y + k);
          ans += calc(x);
        }
      } else {
        if (fd(x) != fd(y + k) || fd(y) != fd(x + k)) {
          ans -= calc(x) + calc(y);
          merge(x + k, y), merge(y + k, x);
          ans += calc(x);
        }
      }
    }
    printf("%d\n", ans);
  }
  return 0;
}
