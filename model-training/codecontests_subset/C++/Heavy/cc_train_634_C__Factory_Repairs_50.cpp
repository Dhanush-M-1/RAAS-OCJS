#include <bits/stdc++.h>
using namespace std;
const int N = 200500;
int t[3][3 * N];
int a[N];
int getsum(int id, int l, int r) {
  int res = 0;
  while (l <= r) {
    if (l % 2 == 1) {
      res += t[id][l];
    }
    if (r % 2 == 0) {
      res += t[id][r];
    }
    l = (l + 1) / 2;
    r = (r - 1) / 2;
  }
  return res;
}
void upd(int id, int p) {
  while (p) {
    p /= 2;
    t[id][p] = t[id][p * 2] + t[id][p * 2 + 1];
  }
}
int main() {
  srand(time(NULL));
  int n, k, p1, p2, m;
  cin >> n >> k >> p1 >> p2 >> m;
  int sz = 1;
  while (sz < n) {
    sz *= 2;
  }
  for (int i = 1; i <= m; i++) {
    int type;
    cin >> type;
    if (type == 1) {
      int day, kol;
      cin >> day >> kol;
      a[day] += kol;
      t[1][sz + day - 1] = min(a[day], p1);
      t[2][sz + day - 1] = min(a[day], p2);
      upd(1, sz + day - 1);
      upd(2, sz + day - 1);
    } else {
      int pos;
      cin >> pos;
      cout << getsum(2, sz, sz + pos - 2) +
                  getsum(1, sz + pos + k - 1, sz + n - 1)
           << endl;
    }
  }
  return 0;
}
