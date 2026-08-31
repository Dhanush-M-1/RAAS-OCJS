#include <bits/stdc++.h>
using namespace std;
const int N = 110;
const int M = 300000100;
const int K = 670000;
const int LIT = 2500;
const int INF = 1 << 30;
const int base = 137;
const double eps = 1e-10;
const int dir[5][2] = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
const int dir2[10][2] = {{-1, 0}, {1, 0},  {0, 1},  {0, -1},
                         {1, 0},  {-1, 0}, {0, -1}, {0, 1}};
const int ABS(int a) { return a > 0 ? a : -a; }
int dta[N], t, m;
void init() { memset(dta, 0, sizeof(dta)); }
void all(int x, int &id) {
  for (int i = 1; i <= m; i++) {
    int cnt = 0, j;
    for (j = i; j <= m; j++) {
      if (!dta[j])
        cnt++;
      else
        break;
      if (cnt == x) break;
    }
    if (cnt != x) continue;
    id++;
    for (int k = i; k <= j; k++) dta[k] = id;
    cout << id << endl;
    return;
  }
  cout << "NULL" << endl;
}
void era(int x) {
  if (x <= 0) {
    cout << "ILLEGAL_ERASE_ARGUMENT" << endl;
    return;
  }
  bool f = 0;
  for (int i = 1; i <= m; i++)
    if (dta[i] == x) dta[i] = 0, f = 1;
  if (!f) cout << "ILLEGAL_ERASE_ARGUMENT" << endl;
}
void re() {
  int tmp[N] = {0};
  for (int i = 1, j = 1; i <= m; i++) {
    if (!dta[i]) continue;
    tmp[j++] = dta[i];
  }
  for (int i = 1; i <= m; i++) dta[i] = tmp[i];
}
void solve() {
  int id = 0;
  for (int i = 1; i <= t; i++) {
    string s;
    int x;
    cin >> s;
    if (s[0] == 'a') {
      cin >> x;
      all(x, id);
    } else if (s[0] == 'e') {
      cin >> x;
      era(x);
    } else
      re();
  }
}
int main() {
  while (cin >> t >> m) {
    init();
    solve();
  }
}
