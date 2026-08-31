#include <bits/stdc++.h>
using namespace std;
const int cnt = 1000 * 1000 * 1000;
struct mt {
  int t, l, r, x;
};
int a[5001];
int s[5001];
mt op[5001];
int main() {
  int n, m;
  cin >> n >> m;
  for (int i = 0; i < m; i++) cin >> op[i].t >> op[i].l >> op[i].r >> op[i].x;
  for (int i = 1; i <= n; i++) s[i] = cnt;
  for (int i = 0; i < m; i++)
    if (op[i].t == 1)
      for (int j = op[i].l; j <= op[i].r; j++) a[j] += op[i].x;
    else
      for (int j = op[i].l; j <= op[i].r; j++) {
        s[j] = max(-cnt, min(s[j], op[i].x - a[j]));
      }
  for (int i = 0; i <= n; i++) a[i] = 0;
  for (int i = 0; i < m; i++) {
    if (op[i].t == 1)
      for (int j = op[i].l; j <= op[i].r; j++) a[j] += op[i].x;
    else {
      bool f = 0;
      for (int j = op[i].l; j <= op[i].r; j++)
        if (a[j] + s[j] == op[i].x)
          f = 1;
        else if (a[j] + s[j] > op[i].x) {
          cout << "NO";
          return 0;
        }
      if (!f) {
        cout << "NO";
        return 0;
      }
    }
  }
  cout << "YES" << endl;
  for (int i = 1; i <= n; i++) cout << s[i] << ' ';
  return 0;
}
