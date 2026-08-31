#include <bits/stdc++.h>
using namespace std;
double req[100005], now[100005];
int x[100005], k[100005], n;
inline int read() {
  int x = 0;
  char c = getchar();
  while (c < '0' || c > '9') c = getchar();
  while (c >= '0' && c <= '9') x = x * 10 + c - '0', c = getchar();
  return x;
}
inline long long readll() {
  long long x = 0;
  char c = getchar();
  while (c < '0' || c > '9') c = getchar();
  while (c >= '0' && c <= '9') x = x * 10ll + c - '0', c = getchar();
  return x;
}
int main() {
  int i;
  n = read();
  for (i = 1; i <= n; i++) now[i] = readll();
  for (i = 1; i <= n; i++) req[i] = readll();
  for (i = 2; i <= n; i++) x[i] = read(), k[i] = read();
  for (i = n; i >= 2; i--) {
    if (now[i] > req[i]) {
      now[x[i]] += (now[i] - req[i]);
    } else {
      now[x[i]] -= (req[i] - now[i]) * k[i];
    }
  }
  if (now[1] + 0.000001 > req[1]) {
    puts("YES");
  } else {
    puts("NO");
  }
  return 0;
}
