#include <bits/stdc++.h>
using namespace std;
const int inf = 0x3f3f3f3f;
const int MOD = 1e9 + 7;
int n, add, de, l, r;
int base = 0, now;
int solve() {
  r = base * add - de;
  l = -base * de + add;
  int l1, r1, mid;
  if (now == 0)
    l1 = n - base, r1 = n - 1;
  else
    l1 = n + 1, r1 = n + base;
  mid = (l1 + r1) >> 1;
  int cnt = 0;
  while (l1 <= r1) {
    mid = (l1 + r1) >> 1;
    int l2 = mid + l;
    int r2 = mid + r;
    if (base < l2)
      r1 = mid - 1;
    else if (base > r2)
      l1 = mid + 1;
    else {
      break;
    }
  }
  int a = n;
  n = mid;
  return fabs(mid - a);
}
bool check() {
  r = base * add - de;
  l = -base * de + add;
  if (base <= r && base >= l) return 1;
  return 0;
}
int main() {
  add = de = 0;
  string s;
  getline(cin, s);
  int l = s.size();
  add++;
  for (int i = 0; i < l; i++) {
    if (s[i] == '-') de++;
    if (s[i] == '+') add++;
  }
  stringstream ss(s);
  string t;
  while (ss >> t && t[0] != '=')
    ;
  ss >> n;
  base = n;
  n = 0;
  if (!check()) {
    puts("Impossible");
  } else {
    puts("Possible");
    int pos = 0;
    now = 1;
    while (pos < l) {
      if (s[pos] == '=') {
        printf("=");
        pos++;
        break;
      }
      if (s[pos] == '?') {
        if (now)
          add--;
        else
          de--;
        printf("%d", solve());
      } else
        printf("%c", s[pos]);
      if (s[pos] == '-') now = 0;
      if (s[pos] == '+') now = 1;
      pos++;
    }
    while (pos < l) printf("%c", s[pos++]);
  }
  return 0;
}
