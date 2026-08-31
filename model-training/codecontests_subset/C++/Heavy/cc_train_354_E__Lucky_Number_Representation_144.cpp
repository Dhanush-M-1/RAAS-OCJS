#include <bits/stdc++.h>
using namespace std;
int N;
char S[20], A[6][22];
bool D[22][10];
int T[22][10], P[22][10];
int main() {
  cin >> N;
  for (int s = 1; s <= N; ++s) {
    cin >> S;
    int size;
    for (size = 0; S[size] != 0; ++size)
      ;
    memset(D, 0, sizeof(D));
    D[0][0] = true;
    for (int i = 0; i <= 19; ++i)
      for (int j = 0; j <= 4; ++j)
        if (D[i][j] == true) {
          for (int x = 0; x <= 6; ++x)
            for (int y = 0; x + y <= 6; ++y) {
              int valnow = j + 4 * x + 7 * y;
              if ((size - i - 1 < 0 && valnow % 10 == 0) ||
                  (size - i - 1 >= 0 && valnow % 10 == S[size - i - 1] - '0')) {
                D[i + 1][valnow / 10] = true;
                T[i + 1][valnow / 10] = j;
                P[i + 1][valnow / 10] = 4 * x + 7 * y;
              }
            }
        }
    if (D[20][0] == true) {
      int now = 20, aux = 0;
      while (now != 0) {
        for (int x = 0; x <= 6; ++x)
          for (int y = 0; x + y <= 6; ++y)
            if (4 * x + 7 * y == P[now][aux]) {
              for (int k = 0; k < 6; ++k)
                if (1 + k <= x)
                  A[k][now - 1] = '4';
                else if (1 + k <= x + y)
                  A[k][now - 1] = '7';
                else
                  A[k][now - 1] = '0';
            }
        aux = T[now][aux];
        --now;
      }
      for (int k = 0; k < 6; ++k) {
        reverse(A[k], A[k] + 20);
        int begnow = 0;
        while (begnow < 20 && A[k][begnow] == '0') ++begnow;
        if (begnow == 20)
          cout << 0 << ' ';
        else
          cout << A[k] + begnow << ' ';
      }
      cout << '\n';
    } else
      cout << -1 << '\n';
  }
}
