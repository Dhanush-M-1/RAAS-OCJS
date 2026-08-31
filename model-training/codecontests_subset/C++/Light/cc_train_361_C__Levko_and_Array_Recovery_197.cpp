#include <bits/stdc++.h>
using namespace std;
const int LIM = 1e+5 + 100;
const int INF = -1e+8;
struct oper {
  int t;
  int l, r;
  int val;
};
int a[LIM];
int add[LIM];
oper o[LIM];
int main() {
  int n, m;
  cin >> n >> m;
  for (int i = 0; i < LIM; i++) a[i] = INF;
  for (int i = 0; i < m; i++) {
    cin >> o[i].t >> o[i].l >> o[i].r >> o[i].val;
    if (o[i].t == 1)
      for (int q = o[i].l - 1; q < o[i].r; q++) add[q] += o[i].val;
    else
      for (int q = o[i].l - 1; q < o[i].r; q++) {
        if (a[q] == INF || a[q] > o[i].val - add[q]) a[q] = o[i].val - add[q];
      }
  }
  for (int i = 0; i < n; i++) add[i] = a[i];
  for (int i = 0; i < m; i++) {
    if (o[i].t == 1)
      for (int q = o[i].l - 1; q < o[i].r; q++) add[q] += o[i].val;
    else {
      int _m = INF;
      for (int q = o[i].l - 1; q < o[i].r; q++) _m = max(_m, add[q]);
      if (_m != o[i].val) {
        cout << "NO";
        return 0;
      }
    }
  }
  cout << "YES" << endl;
  for (int i = 0; i < n; i++) cout << a[i] << ' ';
  return 0;
}
