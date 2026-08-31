#include <bits/stdc++.h>
using namespace std;
const int MX = 400 + 5;
int n, m, r, c;
char table[MX][MX], preg[MX][MX];
bool ok[MX][MX][MX];
bitset<MX> pp[26];
void presolve() {
  for (int t = 1; t <= r; t++) {
    for (int o = 0; o < 26; o++) pp[o].reset();
    for (int i = c; i >= 1; i--) {
      for (int o = 0; o < 26; o++) {
        pp[o] <<= 1;
        if (preg[t][i] == '?' || preg[t][i] - 'a' == o) pp[o][0] = 1;
      }
    }
    for (int i = 1; i <= n; i++) {
      bitset<MX> now = 0;
      for (int j = 1; j - c + 1 <= m; j++) {
        int o = table[i][(j - 1) % m + 1] - 'a';
        now <<= 1;
        now[0] = 1;
        now &= pp[o];
        if (now[c - 1]) {
          ok[i][j - c + 1][t] = 1;
        }
      }
    }
  }
}
bool check(int opx, int opy) {
  for (int i = 1; i <= r; i++) {
    int x = (opx + i - 2) % n + 1;
    if (!ok[x][opy][i]) return 0;
  }
  return 1;
}
void solve() {
  for (int i = 1; i <= n; i++) {
    for (int j = 1; j <= m; j++) {
      printf("%c", check(i, j) ? '1' : '0');
    }
    printf("\n");
  }
}
int main() {
  scanf("%d%d", &n, &m);
  for (int i = 1; i <= n; i++) {
    scanf("%s", table[i] + 1);
  }
  scanf("%d%d", &r, &c);
  for (int i = 1; i <= r; i++) {
    scanf("%s", preg[i] + 1);
  }
  presolve();
  solve();
  return 0;
}
