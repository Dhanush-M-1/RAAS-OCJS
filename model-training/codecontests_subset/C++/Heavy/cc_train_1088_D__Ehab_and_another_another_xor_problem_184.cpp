#include <bits/stdc++.h>
using namespace std;
int gen(vector<int> &v) {
  int ret = 0, cur = 1 << 29;
  for (int x : v) {
    ret += x * cur;
    cur /= 2;
  }
  return ret;
}
vector<int> complete(const vector<int> &v) {
  vector<int> ret = v;
  while (ret.size() < 30) ret.emplace_back(0);
  return ret;
}
int main(void) {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  vector<int> a, b;
  cout << "? " << gen(a) << " " << gen(b) << endl;
  int tot_eq;
  cin >> tot_eq;
  for (int i = 29; i >= 0; i--) {
    vector<int> c, d;
    c = a;
    d = b;
    c.emplace_back(1);
    d.emplace_back(1);
    c = complete(c);
    d = complete(d);
    cout << "? " << gen(c) << " " << gen(d) << endl;
    int x;
    cin >> x;
    if (x == tot_eq) {
      c = a;
      d = b;
      c.emplace_back(1);
      d.emplace_back(0);
      c = complete(c);
      d = complete(d);
      cout << "? " << gen(c) << " " << gen(d) << endl;
      int y;
      cin >> y;
      if (y == 1) {
        a.emplace_back(0);
        b.emplace_back(0);
      } else {
        a.emplace_back(1);
        b.emplace_back(1);
      }
    } else {
      if (x == 1) {
        a.emplace_back(0);
        b.emplace_back(1);
      } else if (x == -1) {
        a.emplace_back(1);
        b.emplace_back(0);
      } else
        assert(0);
      cout << "? " << gen(a) << " " << gen(b) << endl;
      cin >> tot_eq;
    }
  }
  cout << "! " << gen(a) << " " << gen(b) << endl;
  return 0;
}
