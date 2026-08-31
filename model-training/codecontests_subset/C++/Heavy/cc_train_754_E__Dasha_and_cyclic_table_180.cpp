#include <bits/stdc++.h>
using namespace std;
const int inf = 0x3f3f3f3f;
const long double pi = acos(-1.0);
const string debug_line = "yolo";
const long double PI = acos((long double)-1.0);
const long double eps = 1e-6;
unsigned long long getRand() {
  return ((unsigned long long)rand() << 40) +
         ((unsigned long long)rand() << 20) + ((unsigned long long)rand());
}
char s[410][410];
char pat1[410][410];
bitset<810> bitVal[410][26];
bitset<810> pat[410][26];
bitset<810> ans[410];
bool checkVal(int i1, int j1, int i2, int k) {
  bitset<810> temp = (bitVal[i1][k] >> j1);
  bitset<810> res = pat[i2][k] & temp;
  if (res == pat[i2][k]) {
    return true;
  } else {
    return false;
  }
}
int main() {
  int n, m;
  scanf("%d%d", &n, &m);
  for (int(i) = (0); (i) < (n); ++(i)) {
    ans[i].set();
    scanf("%s", s[i]);
  }
  int r1, c1;
  scanf("%d%d", &r1, &c1);
  for (int(i) = (0); (i) < (r1); ++(i)) {
    scanf("%s", pat1[i]);
  }
  int maxr = max(r1, n);
  int maxc = max(c1, m);
  for (int(i) = (0); (i) < (maxr); ++(i)) {
    for (int(k) = (0); (k) < (26); ++(k)) {
      for (int(j) = (0); (j) < (2 * maxc); ++(j)) {
        if (s[i % n][j % m] - 'a' == k) {
          bitVal[i][k][j] = 1;
        }
      }
    }
  }
  for (int(i) = (0); (i) < (r1); ++(i)) {
    for (int(k) = (0); (k) < (26); ++(k)) {
      for (int(j) = (0); (j) < (c1); ++(j)) {
        if (pat1[i][j % c1] != '?' && pat1[i][j % c1] - 'a' == k) {
          pat[i][k][j] = 1;
        }
      }
    }
  }
  for (int(i) = (0); (i) < (r1); ++(i)) {
    for (int(j) = (0); (j) < (c1); ++(j)) {
      if (pat1[i][j] == '?') {
        continue;
      } else {
        int c = pat1[i][j] - 'a';
        for (int(k) = (0); (k) < (n); ++(k)) {
          int x1 = ((k - i) % n + n) % n;
          ans[x1] &= (bitVal[k][c] >> j % m) | (bitVal[k][c] << (m - j) % m);
        }
      }
    }
  }
  for (int(i) = (0); (i) < (n); ++(i)) {
    for (int(j) = (0); (j) < (m); ++(j)) {
      (ans[i][j]) ? putchar('1') : putchar('0');
    }
    printf("\n");
  }
  return 0;
}
