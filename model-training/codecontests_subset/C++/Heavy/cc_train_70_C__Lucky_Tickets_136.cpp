#include <bits/stdc++.h>
bool DEBUG = false;
using namespace std;
int rev(int arg) {
  int res = 0;
  while (arg > 0) {
    res = res * 10 + (arg % 10);
    arg /= 10;
  }
  return res;
}
int gcd(int a, int b) { return a % b == 0 ? b : gcd(b, a % b); }
int maxx, maxy, w, ax, ay, x, y, n, t;
pair<int, int> mas[200000], r[200000];
map<pair<int, int>, int> mp, dup;
int main() {
  cin >> maxx >> maxy >> w;
  ax = ay = -1;
  n = ((maxx) > (maxy) ? (maxx) : (maxy));
  for (int i = (1); i <= (n); ++i) {
    mas[i] = make_pair(i, rev(i));
    t = gcd(mas[i].first, mas[i].second);
    mas[i].first /= t;
    mas[i].second /= t;
    r[i] = make_pair(mas[i].second, mas[i].first);
  }
  for (int i = (1); i <= (maxx); ++i)
    if (mp.find(mas[i]) == mp.end())
      mp[mas[i]] = 1;
    else
      mp[mas[i]]++;
  if (DEBUG) {
    for (map<pair<int, int>, int>::iterator it = mp.begin(); it != mp.end();
         it++) {
      pair<pair<int, int>, int> p = *it;
      cout << "(" << p.first.first << ";" << p.first.second << ") " << p.second
           << ": ";
      for (int i = (1); i <= (maxx); ++i)
        if (mas[i] == p.first) cout << i << " ";
      cout << endl;
    }
  }
  int res = 0;
  int cur = 0;
  x = maxx;
  y = 0;
  while (x > 0) {
    if (res < w) {
      y++;
      while (y <= maxy) {
        res += mp[r[y]];
        dup[r[y]]++;
        if (DEBUG) {
          cout << "res"
               << ": " << (res) << endl;
        };
        if (res >= w) break;
        y++;
      }
    }
    if (DEBUG) {
      cout << "After shift" << endl;
    };
    if (DEBUG) {
      cout << "x"
           << ": " << (x) << endl;
    };
    if (DEBUG) {
      cout << "y"
           << ": " << (y) << endl;
    };
    if (DEBUG) {
      cout << "res"
           << ": " << (res) << endl;
    };
    if (y > maxy) break;
    if (ax == -1 || x * y < ax * ay) {
      ax = x;
      ay = y;
    }
    if (DEBUG) {
      cout << "ax"
           << ": " << (ax) << endl;
    };
    if (DEBUG) {
      cout << "ay"
           << ": " << (ay) << endl;
    };
    res -= dup[mas[x]];
    if (DEBUG) {
      cout << "dup[mas[x]]"
           << ": " << (dup[mas[x]]) << endl;
    };
    mp[mas[x]]--;
    x--;
  }
  if (ax == -1)
    puts("-1");
  else
    cout << ax << " " << ay << endl;
  return 0;
}
