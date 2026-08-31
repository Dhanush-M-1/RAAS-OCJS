#include <bits/stdc++.h>
using namespace std;
inline int read() {
  int sum = 0, t = 1;
  char ch = getchar();
  while (ch < '0' || ch > '9') {
    if (ch == '-') t = -1;
    ch = getchar();
  }
  while (ch >= '0' && ch <= '9') {
    sum = sum * 10 + ch - '0';
    ch = getchar();
  }
  return sum * t;
}
int n, p[1000005], pos;
long long step[1000005], now, S, ans;
int main() {
  n = read();
  for (int i = 1; i <= n; i++) p[i] = read();
  for (int i = 1; i <= n; i++) {
    S += abs(p[i] - i);
    if (p[i] >= i) {
      step[0] += -1;
      step[p[i] - i] += 1 + 1;
      step[n - i] += abs(p[i] - 1) - abs(p[i] - n) - 1;
      step[n - i + 1] += -1 - abs(p[i] - 1) + abs(p[i] - n);
    } else if (p[i] < i) {
      step[0] += 1;
      step[n - i] += abs(p[i] - 1) - abs(p[i] - n) - 1;
      step[n - i + 1] += -1 - abs(p[i] - 1) + abs(p[i] - n);
      step[p[i] + n - i] += 1 + 1;
    }
  }
  ans = S;
  pos = 0;
  for (int k = 0; k < n; k++) {
    S += now;
    if (S < ans) ans = S, pos = k;
    now += step[k];
  }
  printf("%lld %d\n", ans, pos);
}
