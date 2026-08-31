#include <bits/stdc++.h>
using namespace std;
char mp[5205][5205];
int sum[5205][5205];
int main() {
  int n;
  scanf("%d", &n);
  char a;
  for (int i = 1; i <= n; i++) {
    getchar();
    for (int j = 1; j <= n; j += 4) {
      scanf("%c", &a);
      int x = a > '9' ? a - 'A' + 10 : a - '0';
      for (int k = 0; k < 4; k++) sum[i][j + k] = (x >> (3 - k)) & 1;
    }
  }
  for (int i = 1; i <= n; i++)
    for (int j = 1; j <= n; j++)
      sum[i][j] += sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1];
  for (int i = n; i >= 1; i--) {
    if (n % i == 0) {
      int cnt = i;
      bool flag = true;
      for (int row = 1; row * cnt <= n; row++) {
        for (int col = 1; col * cnt <= n; col++) {
          int s = sum[cnt * row][cnt * col] - sum[cnt * row][cnt * (col - 1)] -
                  sum[cnt * (row - 1)][cnt * col] +
                  sum[cnt * (row - 1)][cnt * (col - 1)];
          flag &= ((s == cnt * cnt) || s == 0);
        }
      }
      if (flag) {
        cout << i << endl;
        return 0;
      }
    }
  }
}
