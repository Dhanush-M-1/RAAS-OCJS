#include <bits/stdc++.h>
using namespace std;
int ask(long long a, long long b) {
  int ret = 0;
  cout << "? " << a << ' ' << b << endl;
  cout.flush();
  cin >> ret;
  return ret;
}
void ans(long long a, long long b) {
  cout << "! " << a << ' ' << b << endl;
  cout.flush();
  return;
}
int pre;
int c, d;
int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  pre = ask(0, 0);
  for (int pos = 29; pos >= 0; pos--) {
    int nan1 = ask(c | (1 << pos), d | (1 << pos));
    if (nan1 == pre) {
      int n2 = ask(c | (1 << pos), d | (0 << pos));
      if (n2 == 1) {
      } else {
        c = c | (1 << pos);
        d = d | (1 << pos);
        pre = nan1;
      }
    } else {
      if (pre == -1) {
        d = d | (1 << pos);
        pre = ask(c, d);
      } else {
        c = c | (1 << pos);
        pre = ask(c, d);
      }
    }
  }
  ans(c, d);
  return 0;
}
