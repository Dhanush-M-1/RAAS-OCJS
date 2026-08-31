#include <bits/stdc++.h>
using namespace std;
int r1, r2, c1, c2, d1, d2;
bool flag;
int main() {
  while (~scanf("%d%d%d%d%d%d", &r1, &r2, &c1, &c2, &d1, &d2)) {
    flag = true;
    for (int i = 1; i <= 9; i++)
      for (int j = 1; j <= 9; j++)
        if (j != i)
          for (int k = 1; k <= 9; k++)
            if (k != i && k != j)
              for (int l = 1; l <= 9; l++)
                if (l != i && l != j && l != k) {
                  if (i + j == r1 && k + l == r2 && i + k == c1 &&
                      j + l == c2 && i + l == d1 && j + k == d2) {
                    flag = false;
                    cout << i << " " << j << endl;
                    cout << k << " " << l << endl;
                    break;
                  }
                }
    if (flag) cout << "-1" << endl;
  }
  return 0;
}
