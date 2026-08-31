#include <bits/stdc++.h>
using namespace std;
int r1, r2, c1, c2, d1, d2;
int a[5][5];
int main() {
  scanf("%d %d %d %d %d %d\n", &r1, &r2, &c1, &c2, &d1, &d2);
  for (int i = 1; i <= 9; i++)
    for (int j = 1; j <= 9; j++)
      for (int k = 1; k <= 9; k++)
        for (int l = 1; l <= 9; l++) {
          if (i != j && i != k && i != l && j != k && j != l && k != l) {
            a[1][1] = i;
            a[1][2] = j;
            a[2][1] = k;
            a[2][2] = l;
            if (i + j == r1 && k + l == r2 && i + k == c1 && j + l == c2 &&
                i + l == d1 && j + k == d2) {
              for (int q = 1; q <= 2; q++) {
                for (int w = 1; w <= 2; w++) cout << a[q][w] << " ";
                cout << "\n";
              }
              exit(0);
            }
          }
        }
  cout << -1;
  fclose(stdin);
  fclose(stdout);
  return 0;
}
