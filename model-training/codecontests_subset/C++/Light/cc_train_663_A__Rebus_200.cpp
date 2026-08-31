#include <bits/stdc++.h>
using namespace std;
const int maxn = 100233;
char s[maxn];
int v[maxn];
int i, j, k, n, m;
int ra, fh;
char rx;
inline int read() {
  rx = getchar(), ra = 0, fh = 1;
  while (rx < 48) rx == '-' && (fh = -1), rx = getchar();
  while (rx > 47) ra = ra * 10 + rx - 48, rx = getchar();
  return ra * fh;
}
int main() {
  gets(s + 1);
  n = strlen(s + 1);
  int n1 = 1, n2 = 0, mx = 0, base = 1;
  v[1] = 1;
  for (i = 1; i <= n; i++)
    if (s[i] == '+')
      n1++, v[n1 + n2] = 1;
    else if (s[i] == '-')
      n2++, v[n1 + n2] = -1;
  for (i = n; s[i] >= '0'; i--) mx += base * (s[i] - '0'), base *= 10;
  if (n1 * mx - n2 < mx || n1 - n2 * mx > mx) return puts("Impossible"), 0;
  puts("Possible");
  int sm = n1 + n2, now = 0;
  for (i = 1; i <= sm; i++) {
    if (i > 1) {
      if (v[i] == 1)
        printf("+ ");
      else
        printf("- ");
    }
    if (v[i] == 1)
      n1--;
    else
      n2--;
    int x = mx + n2 - n1 * mx, y = mx + n2 * mx - n1;
    for (j = 1; j <= mx; j++) {
      now += v[i];
      if (now >= x && now <= y) break;
    }
    printf("%d ", j);
  }
  printf("= %d\n", mx);
}
