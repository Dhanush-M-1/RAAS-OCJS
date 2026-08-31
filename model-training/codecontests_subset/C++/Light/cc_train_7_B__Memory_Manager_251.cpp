#include <bits/stdc++.h>
using namespace std;
int t, m;
int mem[105];
int memcnt;
void input() {
  cin >> t >> m;
  memset(mem, 0, sizeof(mem));
  memcnt = 0;
}
int checkM(int len) {
  int cnt = 0;
  for (int i = (1), _n = (m); i <= _n; ++i) {
    if (mem[i] == 0) {
      ++cnt;
      if (cnt == len) return i - len + 1;
    } else
      cnt = 0;
  }
  return 0;
}
void solve() {
  string cmd;
  int n, p, v;
  for (int ti = (1), _n = (t); ti <= _n; ++ti) {
    cin >> cmd;
    if (cmd == "alloc") {
      cin >> n;
      p = checkM(n);
      if (p) {
        v = ++memcnt;
        for (int i = (p), _n = (p + n - 1); i <= _n; ++i) mem[i] = v;
        printf("%d\n", v);
      } else
        puts("NULL");
    } else if (cmd == "erase") {
      cin >> n;
      bool cleaned = false;
      for (int i = (1), _n = (m); i <= _n; ++i)
        if (mem[i] == n) {
          cleaned = true;
          mem[i] = 0;
        }
      if (!cleaned || n <= 0) puts("ILLEGAL_ERASE_ARGUMENT");
    } else {
      p = 1;
      int tmpm[105];
      memset(tmpm, 0, sizeof(tmpm));
      for (int i = (1), _n = (m); i <= _n; ++i)
        if (mem[i]) {
          tmpm[p++] = mem[i];
        }
      memcpy(mem, tmpm, sizeof(mem));
    }
  }
}
int main(void) {
  input();
  solve();
  return 0;
}
