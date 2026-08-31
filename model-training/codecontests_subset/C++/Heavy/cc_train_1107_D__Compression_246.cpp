#include <bits/stdc++.h>
using namespace std;
const int MAXN = 5200 + 5;
const bool SEND = 1;
int pref[MAXN][MAXN];
char arr[MAXN][MAXN];
bool bad[MAXN];
char s[MAXN];
int n, ans;
bool bit(int x, int p) { return x & (1 << p); }
int rectSum(int ax, int ay, int bx, int by) {
  int ret = pref[bx][by];
  if (ax > 0) {
    ret -= pref[ax - 1][by];
  }
  if (ay > 0) {
    ret -= pref[bx][ay - 1];
  }
  if (ax > 0 && ay > 0) {
    ret += pref[ax - 1][ay - 1];
  }
  return ret;
}
bool check(int k) {
  int L = n / k;
  for (int x = 0; x < L; ++x) {
    for (int y = 0; y < L; ++y) {
      int cur = rectSum(x * k, y * k, (x + 1) * k - 1, (y + 1) * k - 1);
      if (cur != 0 && cur != k * k) {
        return 0;
      }
    }
  }
  return 1;
}
void solve() {
  scanf("%d", &n);
  if (SEND) {
    for (int i = 0; i < n; ++i) {
      scanf("%s", s);
      for (int j = 0, cur; j < n / 4; ++j) {
        if ('A' <= s[j] && s[j] <= 'F') {
          cur = s[j] - 'A' + 10;
        } else {
          cur = s[j] - '0';
        }
        for (int k = 0; k < 4; ++k) {
          arr[i][j * 4 + 3 - k] = bit(cur, k) + '0';
        }
      }
    }
  } else {
    for (int i = 0; i < n; ++i) {
      scanf("%s", arr[i]);
    }
  }
  for (int i = 0; i < n; ++i) {
    for (int j = 0; j < n; ++j) {
      pref[i][j] = arr[i][j] - '0';
      if (i > 0) {
        pref[i][j] += pref[i - 1][j];
      }
      if (j > 0) {
        pref[i][j] += pref[i][j - 1];
      }
      if (i > 0 && j > 0) {
        pref[i][j] -= pref[i - 1][j - 1];
      }
    }
  }
  for (int i = n; i > 1; --i) {
    if (n % i == 0) {
      if (check(i)) {
        printf("%d\n", i);
        return;
      }
    }
  }
  printf("1\n");
}
int main() {
  int tt = 1;
  while (tt--) {
    solve();
  }
  return 0;
}
