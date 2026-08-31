#include <bits/stdc++.h>
using namespace std;
int t, m, M[100], id = 0;
string op;
int main() {
  cin >> t >> m;
  for (int i = 0; i < m; i++) {
    M[i] = 0;
  }
  while (t--) {
    cin >> op;
    if (op.compare("alloc") == 0) {
      int s, c = 0, b = 0;
      cin >> s;
      for (int i = 0; i < m; i++) {
        if (M[i] == 0) {
          c = 0;
          b = 0;
          int j;
          for (j = i; j < m; j++) {
            if (M[j] != 0) break;
            c++;
          }
          if (c >= s) {
            b = i;
            break;
          }
          i = j - 1;
        }
      }
      if (c < s) {
        puts("NULL");
        continue;
      }
      cout << ++id << endl;
      for (int i = 0; i < s; i++) M[b + i] = id;
    } else if (op.compare("erase") == 0) {
      int id, c = 0;
      cin >> id;
      if (id == 0) {
        puts("ILLEGAL_ERASE_ARGUMENT");
        continue;
      }
      for (int i = 0; i < m; i++) {
        if (M[i] == id) {
          M[i] = 0;
          c++;
        }
      }
      if (c == 0) puts("ILLEGAL_ERASE_ARGUMENT");
    } else {
      int M2[100];
      for (int i = 0; i < m; i++) {
        M2[i] = M[i];
        M[i] = 0;
      }
      for (int i = 0, j = 0; i < m; i++) {
        if (M2[i] != 0) {
          M[j++] = M2[i];
        }
      }
    }
  }
  return 0;
}
