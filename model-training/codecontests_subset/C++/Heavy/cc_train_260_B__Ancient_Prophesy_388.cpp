#include <bits/stdc++.h>
using namespace std;
char s[200010];
char s1[20];
int ha[40][40][10];
int maxx[3], max1;
int main() {
  memset(ha, 0, sizeof(ha));
  cin >> s;
  for (int i = 0; i < strlen(s) - 9; ++i) {
    int p, q, r;
    if (s[i + 5] != '-' || s[i + 2] != '-') continue;
    if (!(isdigit(s[i + 0]) && isdigit(s[i + 1])))
      continue;
    else
      p = 10 * (s[i + 0] - 48) + s[i + 1] - 48;
    if (!(isdigit(s[i + 3]) && isdigit(s[i + 4])))
      continue;
    else
      q = 10 * (s[i + 3] - 48) + s[i + 4] - 48;
    if (!(isdigit(s[i + 6]) && isdigit(s[i + 7]) && isdigit(s[i + 8]) &&
          isdigit(s[i + 9])))
      continue;
    else
      r = 1000 * (s[i + 6] - 48) + 100 * (s[i + 7] - 48) +
          10 * (s[i + 8] - 48) + s[i + 9] - 48;
    if (2013 <= r && r <= 2015 && 1 <= q && q <= 12 && 1 <= p && p <= 31) {
      if (p > 31) continue;
      if (p > 28 && q == 2)
        continue;
      else if (p == 31 && (q == 4 || q == 6 || q == 9 || q == 11))
        continue;
      ha[p][q][r - 2013]++;
      if (ha[p][q][r - 2013] > max1) {
        max1 = ha[p][q][r - 2013];
        maxx[0] = p;
        maxx[1] = q;
        maxx[2] = r;
      }
    }
  }
  printf("%02d-%02d-%d\n", maxx[0], maxx[1], maxx[2]);
}
