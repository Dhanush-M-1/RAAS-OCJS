#include <bits/stdc++.h>
using namespace std;
inline long long read() {
  long long r = 0, f = 0;
  char c;
  while (!isdigit(c = getchar())) f |= (c == '-');
  while (isdigit(c)) r = (r << 1) + (r << 3) + (c ^ 48), c = getchar();
  return f ? -r : r;
}
inline long long min(long long a, long long b) { return a < b ? a : b; }
struct Book {
  long long t, a, b;
  bool operator<(const Book &book) const {
    return t ^ book.t ? t < book.t : (a & b) > (book.a & book.b);
  }
} b[202202];
long long n, k, sum, ans, cnt[2], size[2], s[2][202202];
inline void work() {
  n = read(), k = read();
  for (long long i = 1; i <= n; i++) {
    b[i].t = read();
    b[i].a = read();
    b[i].b = read();
    if (b[i].a | b[i].b) sum += b[i].t;
    cnt[0] += b[i].a;
    cnt[1] += b[i].b;
  }
  if (cnt[0] < k || cnt[1] < k) {
    puts("-1");
    return;
  }
  sort(b + 1, b + 1 + n);
  for (long long i = n; i >= 1; i--)
    if (b[i].a && !b[i].b) {
      s[0][size[0] + 1] = s[0][size[0]];
      size[0]++;
      s[0][size[0]] += b[i].t;
    }
  for (long long i = size[0] + 1; i <= n; i++) s[0][i] = s[0][size[0]];
  for (long long i = n; i >= 1; i--)
    if (b[i].b && !b[i].a) {
      s[1][size[1] + 1] = s[1][size[1]];
      size[1]++;
      s[1][size[1]] += b[i].t;
    }
  for (long long i = size[1] + 1; i <= n; i++) s[1][i] = s[1][size[1]];
  ans = sum - s[0][cnt[0] - k] - s[1][cnt[1] - k];
  for (long long i = n; i >= 1; i--) {
    if (cnt[0] == k || cnt[1] == k) break;
    if (!(b[i].a & b[i].b)) continue;
    cnt[0]--, cnt[1]--;
    sum -= b[i].t;
    ans = min(ans, sum - s[0][cnt[0] - k] - s[1][cnt[1] - k]);
  }
  printf("%lld", ans);
}
signed main() {
  work();
  return 0;
}
