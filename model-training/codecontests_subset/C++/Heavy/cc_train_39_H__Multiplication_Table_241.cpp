#include <bits/stdc++.h>
using namespace std;
int radix(int n, int k) {
  int m = n, sum[100], b, a, q;
  q = 0;
  a = 1;
  memset(sum, 0, sizeof sum);
  b = 0;
  while (m >= k) {
    sum[b] = m % k;
    m /= k;
    b++;
  }
  sum[b] = m;
  for (int i = 0; i <= b; i++) {
    q += a * sum[i];
    a *= 10;
  }
  return q;
}
int main() {
  int mat[11][11];
  int k;
  for (int i = 0; i < 9; i++) mat[0][i] = i + 1;
  for (int i = 1; i < 9; i++)
    for (int j = 0; j < 9; j++) mat[i][j] = mat[0][j] * (i + 1);
  while (cin >> k) {
    if (k < 10) {
      for (int i = 0; i < k - 1; i++) {
        for (int j = 0; j < k - 1; j++) {
          if (j == 0) {
            if (mat[i][j] < k)
              cout << mat[i][j];
            else
              cout << radix(mat[i][j], k);
          } else {
            if (mat[i][j] < k)
              printf("%2d", mat[i][j]);
            else
              printf("%2d", radix(mat[i][j], k));
          }
          cout << " ";
        }
        cout << endl;
      }
    } else {
      for (int i = 0; i < k - 1; i++) {
        for (int j = 0; j < k - 1; j++) {
          if (j == 0)
            cout << mat[i][j];
          else
            printf("%2d", mat[i][j]);
          cout << " ";
        }
        cout << endl;
      }
    }
  }
  return 0;
}
