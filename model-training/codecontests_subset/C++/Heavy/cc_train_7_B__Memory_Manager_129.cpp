#include <bits/stdc++.h>
using namespace std;
int M[110], M2[110];
int main() {
  int t, m, n, cur = 1;
  memset(M, 0, sizeof(M));
  cin >> t >> m;
  while (t-- > 0) {
    string op;
    cin >> op;
    if (op == "alloc") {
      cin >> n;
      bool f = false;
      for (int i = 0; i < m; ++i) {
        int cnt = 0;
        for (int j = i; j < m; ++j) {
          if (M[j] == 0)
            ++cnt;
          else
            break;
          if (cnt == n) break;
        }
        if (cnt == n) {
          for (int j = i; j < i + n; ++j) M[j] = cur;
          cout << cur << endl;
          ++cur;
          f = true;
          break;
        }
      }
      if (!f) cout << "NULL" << endl;
    } else if (op == "erase") {
      cin >> n;
      bool f = false;
      for (int i = 0; i < m; ++i)
        if (M[i] == n) {
          M[i] = 0;
          f = true;
        }
      if (!f || n == 0) cout << "ILLEGAL_ERASE_ARGUMENT" << endl;
    } else if (op == "defragment") {
      int j = 0;
      for (int i = 0; i < m; ++i)
        if (M[i] != 0) M[j++] = M[i];
      while (j < m) M[j++] = 0;
    }
  }
  return 0;
}
