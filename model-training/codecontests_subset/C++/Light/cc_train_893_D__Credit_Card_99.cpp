#include <bits/stdc++.h>
using namespace std;
template <typename T>
void read(T& x) {
  x = 0;
  char c;
  int sign = 1;
  do {
    c = getchar();
    if (c == '-') sign = -1;
  } while (c < '0' || c > '9');
  do {
    x = x * 10 + c - '0';
    c = getchar();
  } while (c <= '9' && c >= '0');
  x *= sign;
}
const int N = 1e5 + 500;
int ans;
long long n, d, ASK[N], p, sum[N], mx[N];
int main() {
  read(n);
  read(d);
  for (register int i = 1; i <= n; ++i) read(ASK[i]);
  mx[n + 1] = -1e18;
  for (register int i = 1; i <= n; ++i) sum[i] += sum[i - 1] + ASK[i];
  for (register int i = n; i >= 1; --i) mx[i] = max(mx[i + 1], sum[i]);
  if (mx[1] + p > d) return puts("-1"), 0;
  for (register int i = 1; i <= n; ++i) {
    if (sum[i] + p > d) return puts("-1"), 0;
    if (ASK[i] == 0 && sum[i] + p < 0) {
      p += d - (mx[i] + p);
      ans++;
      if (sum[i] + p < 0) return puts("-1"), 0;
    }
  }
  printf("%d", ans);
  return 0;
}
