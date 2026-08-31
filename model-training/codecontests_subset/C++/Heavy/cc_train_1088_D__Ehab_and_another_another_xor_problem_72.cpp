#include <bits/stdc++.h>
using namespace std;
int vis[50];
int ask(int c, int d) {
  cout << "? " << c << " " << d << endl;
  int res;
  cin >> res;
  return res;
}
int main(void) {
  int i, j, n, m, C, D, resc, resd, T, MOST;
  C = D = 0;
  MOST = 29;
  T = 0;
  memset(vis, 0, sizeof(vis));
  while (1) {
    m = ask(C, D);
    T = 0;
    for (i = 0; i <= MOST; i++) {
      T += (1 << i);
    }
    if (m == 1) {
      while (MOST >= 0 && ask(T + C, T + D) == -1) {
        T -= (1 << MOST);
        MOST--;
      }
      C += (1 << (MOST + 1));
      vis[MOST + 1] = 1;
      MOST--;
    } else if (m == -1) {
      while (MOST >= 0 && ask(T + C, T + D) == 1) {
        T -= (1 << MOST);
        MOST--;
      }
      D += (1 << (MOST + 1));
      vis[MOST + 1] = 1;
      MOST--;
    } else {
      MOST = 29;
      while (MOST >= 0) {
        if (vis[MOST]) {
          MOST--;
          continue;
        }
        T = (1 << MOST);
        if (ask(T + C, D) == -1) {
          C += (1 << (MOST));
          D += (1 << (MOST));
        }
        MOST--;
      }
      break;
    }
  }
  cout << "! " << C << " " << D << endl;
}
