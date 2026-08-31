#include <bits/stdc++.h>
using namespace std;
const int maxN = 59;
struct vt {
  int x, y, r;
  vt() : x(0), y(0), r(0) {}
  vt(int x, int y, int r) {
    this->x = x;
    this->y = y;
    this->r = r;
  }
};
vector<vt> point(maxN);
string s1, s2;
pair<int, int> rec(int x, int y, int l, int r) {
  if (l + 1 == r) {
    int ll = l;
    int next_x = point[l + 1].x, next_y = point[l + 1].y;
    if (abs(next_x - x) % 2 == 1) --next_x;
    if (abs(next_y - y) % 2 == 1) --next_y;
    int e_x = (next_x - x) / 2, e_y = (next_y - y) / 2;
    s1 += "(";
    s2 += "(";
    bool q = false, w = false;
    if (e_x < 0) {
      e_x = -e_x;
      q = true;
    }
    if (e_y < 0) {
      e_y = -e_y;
      w = true;
    }
    if (q) s1 += "(0-";
    if (e_x / 10 > 0) {
      s1 += (char)(e_x / 10 + '0');
    }
    s1 += (char)(e_x % 10 + '0');
    if (q) s1 += ")";
    if (w) s2 += "(0-";
    if (e_y / 10 > 0) {
      s2 += (char)(e_y / 10 + '0');
    }
    s2 += (char)(e_y % 10 + '0');
    if (w) s2 += ")";
    s1 += "*(1+(abs((t-";
    s2 += "*(1+(abs((t-";
    bool k = false;
    if (ll < 0) {
      k = true;
      ll = -ll;
      s1 += "(0-";
      s2 += "(0-";
    }
    if (ll / 10 > 0) {
      s1 += (char)(ll / 10 + '0');
      s2 += (char)(ll / 10 + '0');
    }
    s1 += (char)(ll % 10 + '0');
    s2 += (char)(ll % 10 + '0');
    if (k) {
      s1 += ")";
      s2 += ")";
    }
    s1 += "))-abs((t-";
    s2 += "))-abs((t-";
    ll = r;
    if (ll / 10 > 0) {
      s1 += (char)(ll / 10 + '0');
      s2 += (char)(ll / 10 + '0');
    }
    s1 += (char)(ll % 10 + '0');
    s2 += (char)(ll % 10 + '0');
    s1 += ")))))";
    s2 += ")))))";
    return make_pair(next_x, next_y);
  } else {
    int m = (l + r) / 2;
    s1 += '(';
    s2 += '(';
    pair<int, int> t = rec(x, y, l, m);
    s1 += '+';
    s2 += '+';
    t = rec(t.first, t.second, m, r);
    s1 += ')';
    s2 += ')';
    return t;
  }
}
int main() {
  int n;
  cin >> n;
  for (int i = 0; i < n; i++) {
    cin >> point[i].x >> point[i].y >> point[i].r;
  }
  pair<int, int> t = rec(0, 0, -1, n - 1);
  cout << s1 << endl;
  cout << s2 << endl;
  return 0;
}
