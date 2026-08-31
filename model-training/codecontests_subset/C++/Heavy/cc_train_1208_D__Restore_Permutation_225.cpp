#include <bits/stdc++.h>
using namespace std;
inline long long read() {
  long long s = 0, w = 1;
  char ch = getchar();
  while (!isdigit(ch)) {
    if (ch == '-') w = -1;
    ch = getchar();
  }
  while (isdigit(ch)) s = s * 10 + ch - '0', ch = getchar();
  return s * w;
}
inline void write(long long x) {
  if (x < 0) putchar('-'), x = -x;
  if (x > 9) write(x / 10);
  putchar(x % 10 + '0');
}
const int maxn = 2e5 + 10;
long long a[maxn], coun[maxn << 2], sum[maxn << 2];
long long ans[maxn];
int n;
void build(int l, int r, int i) {
  if (l == r) {
    sum[i] = 1;
    coun[i] = l;
    return;
  }
  int mid = (l + r) >> 1;
  build(l, mid, i << 1);
  build(mid + 1, r, (i << 1) + 1);
  sum[i] = sum[i << 1] + sum[(i << 1) + 1];
  coun[i] = coun[i << 1] + coun[(i << 1) + 1];
}
void update(int l, int r, int pos, int i) {
  if (l == r) {
    sum[i] = 0;
    coun[i] = 0;
    return;
  }
  int mid = (l + r) >> 1;
  if (pos <= mid) update(l, mid, pos, i << 1);
  if (pos > mid) update(mid + 1, r, pos, (i << 1) + 1);
  sum[i] = sum[i << 1] + sum[(i << 1) + 1];
  coun[i] = coun[i << 1] + coun[(i << 1) + 1];
}
long long query(int l, int r, int i, int k) {
  if (sum[i] <= k) return coun[i];
  int mid = (l + r) >> 1;
  if (sum[i << 1] >= k) return query(l, mid, i << 1, k);
  return coun[i << 1] + query(mid + 1, r, (i << 1) + 1, k - sum[i << 1]);
}
int queryMin(int l, int r, int i, int k) {
  if (l == r) return l;
  int mid = (l + r) >> 1;
  if (sum[i << 1] >= k) return queryMin(l, mid, i << 1, k);
  return queryMin(mid + 1, r, (i << 1) + 1, k - sum[i << 1]);
}
bool check(int mid, long long x) { return query(1, n, 1, mid) >= x; }
int main() {
  n = read();
  for (int i = 1; i <= n; ++i) a[i] = read();
  build(1, n, 1);
  for (int i = n; i >= 1; --i) {
    int l = 1, r = n;
    while (l <= r) {
      int mid = (l + r) >> 1;
      if (check(mid - 1, a[i])) {
        ans[i] = queryMin(1, n, 1, mid);
        r = mid - 1;
      } else
        l = mid + 1;
    }
    update(1, n, ans[i], 1);
  }
  for (int i = 1; i <= n; ++i) write(ans[i]), putchar(' ');
  putchar('\n');
  return 0;
}
