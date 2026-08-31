#include <bits/stdc++.h>
using namespace std;
const int mxn = 1e5 + 5;
const int inf = 1e9;
int ask(int c, int d) {
  cout << "? " << c << " " << d << endl;
  int x;
  cin >> x;
  return x;
}
int main() {
  int v[2] = {};
  int cur;
  int tm = ask(0, 0);
  bool eq = false;
  if (tm == 1)
    cur = 0;
  else if (tm == 0)
    eq = true;
  else
    cur = 1;
  map<pair<int, int>, pair<int, int> > mp;
  mp[{0, 0}] = {1, 0};
  mp[{1, 1}] = {1, 0};
  mp[{1, -1}] = {0, 0};
  mp[{-1, 1}] = {1, 1};
  mp[{-1, -1}] = {1, 0};
  for (int i = 29; i >= 0; i--) {
    if (eq) {
      int t = ask(v[0] | (1 << i), v[1]);
      if (t == -1) {
        v[0] |= 1 << i;
        v[1] |= 1 << i;
      }
      continue;
    }
    int x = ask(v[0] | (1 << i), v[1]);
    int y = ask(v[0], v[1] | (1 << i));
    pair<int, int> z = mp[{x, y}];
    if (cur == 0) {
      if (z.first == 1) v[0] |= 1 << i;
      if (z.second == 1) v[1] |= 1 << i;
      if ((z == make_pair(0, 0)) || (z == make_pair(1, 1))) continue;
      if (x == -1) cur = 1;
    } else {
      if (z.first == 1) v[1] |= 1 << i;
      if (z.second == 1) v[0] |= 1 << i;
      if ((z == make_pair(0, 0)) || (z == make_pair(1, 1))) continue;
      if (y == 1) cur = 0;
    }
  }
  cout << "! " << v[0] << " " << v[1] << endl;
}
