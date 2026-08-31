#include <bits/stdc++.h>
using namespace std;
inline void rd(double &x) { scanf("%lf", &x); }
inline void rd(char &x) { scanf("%c", &x); }
inline void rd(char *s) { scanf("%s", s); }
template <typename T>
inline void rd(T &x) {
  x = 0;
  char ch = getchar();
  bool w = 0;
  while (!isdigit(ch)) {
    w |= (ch == '-');
    ch = getchar();
  }
  while (isdigit(ch)) x = (x << 1) + (x << 3) + (ch ^ 48), ch = getchar();
  if (w) x = -x;
}
template <typename T, typename... U>
inline void rd(T &a, U &...b) {
  rd(a), rd(b...);
}
template <typename T>
inline void write(T x) {
  if (x < 0) putchar('-'), x = -x;
  if (x >= 10) write(x / 10);
  putchar(x % 10 + '0');
}
const int maxn = 2e5 + 114;
int n, arr[maxn], cnt[maxn], mx = 0;
int main() {
  rd(n);
  for (int i = 1, __i = n; i <= __i; ++i) {
    rd(arr[i]);
    if (++cnt[arr[i]] > cnt[mx]) mx = arr[i];
  }
  for (int i = 1, __i = n; i <= __i; ++i)
    if (arr[i] != mx && cnt[arr[i]] == cnt[mx]) {
      printf("%d\n", n);
      return 0;
    }
  int B = sqrt(n);
  int ans = 0;
  int mp[maxn << 1];
  for (int i = 1, __i = n; i <= __i; ++i)
    if (i != mx && cnt[i] >= B) {
      memset(mp, 0, sizeof(mp));
      int cur = 0;
      for (int j = 1, __j = n; j <= __j; ++j) {
        if (arr[j] == i) ++cur;
        if (arr[j] == mx) --cur;
        if (!cur || mp[cur + n])
          ans = max(ans, j - mp[cur + n]);
        else
          mp[cur + n] = j;
      }
    }
  for (int i = 1, __i = B - 1; i <= __i; ++i) {
    fill_n(mp + 1, n, 0);
    int l = 1, cnt = 0;
    for (int r = 1, __r = n; r <= __r; ++r) {
      if (++mp[arr[r]] == i) ++cnt;
      if (mp[arr[r]] > i) {
        do {
          if (mp[arr[l]]-- == i) --cnt;
        } while (arr[l++] != arr[r]);
      }
      if (cnt >= 2) ans = max(ans, r - l + 1);
    }
  }
  printf("%d\n", ans);
  return 0;
}
