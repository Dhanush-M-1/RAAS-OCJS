#include <bits/stdc++.h>
using namespace std;
int main() {
  int t, m, q, k, x, cnt = 0;
  int i, j;
  int ex;
  bool e_mark;
  int mem[100] = {0};
  string op;
  cin >> t >> m;
  for (i = 0; i < t; i++) {
    cin >> op;
    if (op[0] == 'a') {
      cin >> q;
      k = 0;
      for (j = 0; j < m && k < q; j++) {
        if (!mem[j])
          k++;
        else if (mem[j])
          k = 0;
      }
      if (k == q) {
        cnt++;
        for (int l = j - k; l < j; l++) mem[l] = cnt;
        cout << cnt << endl;
      } else
        cout << "NULL" << endl;
    }
    if (op[0] == 'e') {
      cin >> q;
      e_mark = 0;
      for (j = 0; j < m; j++)
        if (mem[j] == q && q != 0) mem[j] = 0, e_mark = 1;
      if (!e_mark) cout << "ILLEGAL_ERASE_ARGUMENT" << endl;
    }
    if (op[0] == 'd') {
      k = 0;
      for (j = 0; j < m; j++) {
        if (!mem[j])
          k++;
        else
          ex = mem[j - k], mem[j - k] = mem[j], mem[j] = ex;
      }
    }
  }
  return 0;
}
