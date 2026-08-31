#include <bits/stdc++.h>
using namespace std;
const int MOD = 1000000007;
long long POW(long long a, long long b, long long MMM = MOD) {
  long long ret = 1;
  for (; b; b >>= 1, a = (a * a) % MMM)
    if (b & 1) ret = (ret * a) % MMM;
  return ret;
}
int dx[] = {0, 1, 0, -1, 1, 1, -1, -1}, dy[] = {1, 0, -1, 0, 1, -1, 1, -1};
int ddx[] = {-1, -2, 1, -2, 2, -1, 2, 1}, ddy[] = {-2, -1, -2, 1, -1, 2, 1, 2};
bitset<404> C[26][404], res[404];
char s[404][404], t[404];
bitset<404> shift(const bitset<404> &B, int len, int s) {
  return B >> s | B << (len - s);
}
int main() {
  int n, m, r, c;
  scanf("%d%d", &n, &m);
  for (int(i) = (0); (i) <= (n - 1); (i) += (1)) {
    scanf("%s", s[i]);
    for (int(j) = (0); (j) <= (m - 1); (j) += (1)) {
      C[s[i][j] - 'a'][i][j] = true;
    }
    res[i].set();
  }
  scanf("%d%d", &r, &c);
  for (int(i) = (0); (i) <= (r - 1); (i) += (1)) {
    scanf("%s", t);
    for (int(j) = (0); (j) <= (c - 1); (j) += (1)) {
      if (t[j] == '?') continue;
      int k = t[j] - 'a';
      for (int(x) = (0); (x) <= (n - 1); (x) += (1)) {
        int nx = x - i;
        nx %= n;
        if (nx < 0) nx += n;
        res[nx] &= shift(C[k][x], m, j % m);
      }
    }
  }
  for (int(i) = (0); (i) <= (n - 1); (i) += (1)) {
    for (int(j) = (0); (j) <= (m - 1); (j) += (1))
      putchar(res[i][j] ? '1' : '0');
    puts("");
  }
}
