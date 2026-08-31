#include <bits/stdc++.h>
using namespace std;
template <class T>
inline void read(T& num) {
  bool start = false, neg = false;
  char c;
  num = 0;
  while ((c = getchar()) != EOF) {
    if (c == '-')
      start = neg = true;
    else if (c >= '0' && c <= '9') {
      start = true;
      num = num * 10 + c - '0';
    } else if (start)
      break;
  }
  if (neg) num = -num;
}
const int maxn = (int)(1e6) + 5;
int bi[maxn], ai[maxn], idx;
char s[10], opt[10];
int main() {
  int n, cnt = 0;
  bi[++idx] = 1;
  while (1) {
    scanf("%s%s", s, opt);
    if (opt[0] == '=') break;
    if (opt[0] == '+')
      bi[++idx] = 1;
    else
      bi[++idx] = -1;
  }
  scanf("%d", &n);
  for (int i = (1); i <= (idx); i++)
    if (bi[i] > 0) ++cnt;
  long long r = 1LL * n * cnt - (idx - cnt),
            l = 1LL * cnt - 1LL * n * (idx - cnt);
  if (n < l || n > r) {
    printf("Impossible\n");
    return 0;
  }
  printf("Possible\n");
  for (int i = (1); i <= (idx); i++)
    if (bi[i] > 0)
      ai[i] = n;
    else
      ai[i] = 1;
  long long now = r;
  for (int i = (1); i <= (idx); i++)
    if (bi[i] > 0)
      if (now > n) {
        int dt = min(1LL * ai[i] - 1, now - n);
        ai[i] -= dt;
        now -= dt;
      }
  for (int i = (1); i <= (idx); i++)
    if (bi[i] < 0)
      if (now > n) {
        int dt = min(n - 1LL * ai[i], now - n);
        ai[i] += dt;
        now -= dt;
      }
  for (int i = (1); i <= (idx); i++) {
    if (bi[i] > 0 && i != 1)
      printf("+ ");
    else if (bi[i] < 0)
      printf("- ");
    printf("%d ", ai[i]);
  }
  printf("= %d\n", n);
  return 0;
}
