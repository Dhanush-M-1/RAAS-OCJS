#include <bits/stdc++.h>
using namespace std;
int dx[4] = {0, 0, 1, -1};
int dy[4] = {1, -1, 0, 0};
const int inf = 0x7f7f7f7f;
int n, m;
string s;
bool x[110];
struct me {
  int l, r;
  bool in = 0;
  int id;
} memo[110];
int cnt, num;
int main() {
  cin >> n >> m;
  for (int i = 1; i <= n; i++) {
    cin >> s;
    if (s[0] != 'd') cin >> num;
    if (s[0] == 'a') {
      int ast = 0;
      for (int ii = 1; ii <= m - num + 1; ii++) {
        int flag = 1;
        for (int j = ii; j <= ii + num - 1; j++)
          if (x[j]) flag = 0;
        if (flag) {
          ast = 1;
          for (int j = ii; j <= ii + num - 1; j++) x[j] = 1;
          cnt++;
          memo[cnt].in = 1;
          memo[cnt].l = ii;
          memo[cnt].r = ii + num - 1;
          memo[cnt].id = cnt;
          break;
        }
      }
      if (ast) {
        cout << cnt << endl;
      } else {
        cout << "NULL" << endl;
      }
    }
    if (s[0] == 'e') {
      if (num < 1 || num > cnt || memo[num].in == 0)
        cout << "ILLEGAL_ERASE_ARGUMENT" << endl;
      else {
        for (int i = memo[num].l; i <= memo[num].r; i++) x[i] = 0;
        memo[num].in = 0;
      }
    }
    if (s[0] == 'd') {
      int base = 0;
      int mxback = inf;
      int id = 0;
      do {
        id = 0;
        mxback = inf;
        for (int i = 1; i <= 100; i++) {
          if (memo[i].in && memo[i].r > base && memo[i].r < mxback) {
            id = i;
            mxback = memo[i].r;
          }
        }
        if (id) {
          int len = memo[id].r - memo[id].l + 1;
          memo[id].l = base + 1;
          memo[id].r = base + len;
          base += len;
        }
      } while (mxback != inf);
      memset(x, 0, sizeof(x));
      for (int i = 1; i <= base; i++) x[i] = 1;
    }
  }
}
