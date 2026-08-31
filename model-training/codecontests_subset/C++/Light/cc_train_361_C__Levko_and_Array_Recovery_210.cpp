#include <bits/stdc++.h>
using namespace std;
int n, m;
const int inf = 100000000;
const int maxn = 5100;
struct Operation {
  int type, lf, rt, val;
} op[maxn];
int a[maxn];
int b[maxn];
bool legal() {
  for (int i = 0; i < n; ++i) b[i] = a[i];
  for (int i = 0; i < m; ++i) {
    if (op[i].type == 1) {
      for (int j = op[i].lf; j <= op[i].rt; ++j) b[j] += op[i].val;
    } else {
      int mx = *max_element(b + op[i].lf, b + op[i].rt + 1);
      if (mx < op[i].val) return false;
    }
  }
  return true;
}
void solve() {
  for (int i = m - 1; i >= 0; --i) {
    if (op[i].type == 1) {
      for (int j = op[i].lf; j <= op[i].rt; ++j) {
        a[j] -= op[i].val;
      }
    } else {
      for (int j = op[i].lf; j <= op[i].rt; ++j) a[j] = min(a[j], op[i].val);
    }
  }
  if (legal()) {
    cout << "YES" << endl;
    for (int i = 0; i < n; ++i) cout << a[i] << " ";
    cout << endl;
  } else
    cout << "NO" << endl;
}
int main() {
  fill_n(a, maxn, inf);
  cin >> n >> m;
  for (int i = 0; i < m; ++i) {
    scanf("%d %d %d %d", &op[i].type, &op[i].lf, &op[i].rt, &op[i].val);
    op[i].lf--;
    op[i].rt--;
  }
  solve();
  return 0;
}
