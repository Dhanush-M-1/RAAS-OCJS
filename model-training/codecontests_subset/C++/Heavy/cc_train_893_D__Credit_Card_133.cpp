#include <bits/stdc++.h>
char ch;
bool fs;
void re(long long& x) {
  while (ch = getchar(), ch < 33)
    ;
  if (ch == '-')
    fs = 1, x = 0;
  else
    fs = 0, x = ch - 48;
  while (ch = getchar(), ch > 33) x = x * 10 + ch - 48;
  if (fs) x = -x;
}
using namespace std;
long long n, d, ans, a[100005], mx[100005];
int main() {
  re(n), re(d);
  for (long long i = 1; i <= n; ++i) re(a[i]);
  for (long long i = n; i; --i) mx[i] = max(0ll, max(a[i], a[i] + mx[i + 1]));
  for (long long i = 1, now = 0; i <= n; ++i) {
    now += a[i];
    if (now > d || (!a[i] && mx[i] > d)) {
      puts("-1");
      return 0;
    }
  }
  for (long long i = 1, now = 0; i <= n; ++i) {
    now += a[i];
    if (!a[i] && now < 0) {
      ++ans;
      now = d - mx[i];
    }
  }
  printf("%I64d\n", ans);
}
