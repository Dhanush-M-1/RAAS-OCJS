#include <bits/stdc++.h>
using namespace std;
bool cur1;
int n;
int ans[200005];
long long S[200005];
struct Bittree {
  long long sum[200005];
  inline void update(int x, int v) {
    while (x <= n) {
      sum[x] += v;
      x += x & (-x);
    }
  }
  inline long long query(int x) {
    long long res = 0;
    while (x) {
      res += sum[x];
      x ^= x & (-x);
    }
    return res;
  }
} bit;
inline void Rd(int &res) {
  char c;
  res = 0;
  while (c = getchar(), c < 48)
    ;
  do res = (res << 3) + (res << 1) + (c ^ 48);
  while (c = getchar(), c > 47);
  return;
}
long long ch[200005];
inline bool check(int x, long long y) {
  long long h = ch[x - 1] - bit.query(x - 1);
  return h <= y;
}
bool cur2;
int main() {
  Rd(n);
  for (int i = 1; i <= n; i++) ch[i] = ch[i - 1] + i;
  for (int i = 1; i <= n; i++) scanf("%lld", &S[i]);
  for (int i = n; i >= 1; i--) {
    int l = 1, r = n;
    while (l <= r) {
      int mid = (l + r) >> 1;
      if (check(mid, S[i]))
        ans[i] = mid, l = mid + 1;
      else
        r = mid - 1;
    }
    bit.update(ans[i], ans[i]);
  }
  for (int i = 1; i <= n; i++) printf("%d ", ans[i]);
  puts("");
  return 0;
}
