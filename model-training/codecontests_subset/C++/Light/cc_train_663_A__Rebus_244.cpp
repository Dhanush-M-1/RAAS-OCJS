#include <bits/stdc++.h>
using namespace std;
string s;
int res, p, m, ans[105];
bool pos[105];
int main() {
  int mx = 0, mn = 0;
  getline(cin, s);
  int cnt = 1;
  for (int i = s.size() - 1; s[i] != ' '; --i) {
    res += (s[i] - '0') * cnt;
    cnt *= 10;
  }
  p = 1;
  cnt = 1;
  for (int i = 0; s[i] != '='; ++i) {
    if (s[i] == '+') {
      p++;
      pos[++cnt] = true;
    } else if (s[i] == '-') {
      m++;
      pos[++cnt] = false;
    }
  }
  mx = p * res - m;
  mn = p - m * res;
  if (res > mx || res < mn) {
    puts("Impossible");
    return 0;
  }
  puts("Possible");
  int lp = (res < p ? p : res), rp = res * p;
  int lm = m, rm = res * m;
  int x, y;
  for (int i = lp; i <= rp; ++i) {
    if (i - res >= lm && i - res <= rm) {
      x = i;
      y = i - res;
      break;
    }
  }
  pos[1] = true;
  int q = 0;
  for (int i = 1; i <= cnt; ++i) {
    if (pos[i]) {
      if (x - (p - 1) <= res) {
        ans[i] = x - (p - 1);
        x -= ans[i];
      } else {
        ans[i] = res;
        x -= ans[i];
      }
      q += ans[i];
      --p;
    } else {
      if (y - (m - 1) <= res) {
        ans[i] = y - (m - 1);
        y -= ans[i];
      } else {
        ans[i] = res;
        y -= ans[i];
      }
      q -= ans[i];
      --m;
    }
    if (i != 1) cout << (pos[i] ? '+' : '-') << ' ';
    cout << ans[i] << ' ';
  }
  cout << "= " << res;
}
