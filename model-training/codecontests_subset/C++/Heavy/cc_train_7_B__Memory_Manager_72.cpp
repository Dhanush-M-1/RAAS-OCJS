#include <bits/stdc++.h>
using namespace std;
class point {
 public:
  int num, p, l;
  point() { num = 0, p = -1, l = 0; };
  point(int x, int y, int z) { num = x, p = y, l = z; };
  point(const point& po) { num = po.num, p = po.p, l = po.l; };
};
map<int, point> m;
map<int, int> rm;
int flag[105], tail = 0, t, n;
int alloc(int x) {
  for (int i = 0; i < n - x + 1; ++i) {
    if (!flag[i]) {
      int tmp = i;
      for (int j = i; j < tmp + x; ++j) {
        if (flag[j]) i = j;
      }
      if (i == tmp) {
        ++tail;
        point p(tail, i, x);
        m[tail] = p;
        rm[i] = tail;
        for (int j = i; j < i + x; ++j) {
          flag[j] = 1;
        }
        cout << tail << endl;
        return tail;
      }
      i--;
    }
  }
  return 0;
}
void erase(int x) {
  if (x > tail) {
    cout << "ILLEGAL_ERASE_ARGUMENT" << endl;
    return;
  }
  if (m[x].p == -1) {
    cout << "ILLEGAL_ERASE_ARGUMENT" << endl;
    return;
  }
  point p = m[x];
  for (int i = p.p; i < p.p + p.l; ++i) {
    flag[i] = false;
  }
  m[x].p = -1;
}
void defragment() {
  for (int i = 0; i < n; ++i) {
    if (!flag[i]) {
      for (int j = i + 1; j < n; ++j) {
        if (flag[j]) {
          int x = rm[j];
          rm[i] = x;
          m[x].p = i;
          point p = m[x];
          for (int k = 0; k < p.l; ++k) {
            flag[i + k] = true;
            flag[j + k] = false;
          }
          i += p.l - 1;
          break;
        }
      }
    }
  }
}
int main() {
  int x;
  cin >> t >> n;
  memset(flag, 0, sizeof(flag));
  string s;
  for (int i = 0; i < t; ++i) {
    cin >> s;
    if (s == "alloc") {
      cin >> x;
      if (!alloc(x)) cout << "NULL" << endl;
    } else if (s == "erase") {
      cin >> x;
      erase(x);
    } else
      defragment();
  }
  return 0;
}
