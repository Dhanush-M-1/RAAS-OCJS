#include <bits/stdc++.h>
using namespace std;
const int maxn = 1e6 + 5;
string Number;
int test;
int check[200], Digit4[200], Digit7[200], f[20][20], Digit[20][20],
    Value[20][20];
long long ans[10];
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  for (int i = 0; i <= 6; i++)
    for (int j = 0; i + j <= 6; j++) {
      check[i * 4 + j * 7] = 1;
      Digit4[i * 4 + j * 7] = i;
      Digit7[i * 4 + j * 7] = j;
    }
  cin >> test;
  while (test) {
    test--;
    cin >> Number;
    int len_Number = Number.length();
    Number = ' ' + Number;
    for (int i = 19; i >= 0; i--)
      for (int j = 19; j >= 0; j--) f[i][j] = 0;
    f[len_Number][0] = 1;
    for (int i = len_Number; i >= 1; i--) {
      int digit = Number[i] - '0';
      for (int j = 0; j <= 9; j++)
        if (f[i][j] == 1) {
          for (int k = digit - j; k <= 42; k += 10)
            if (check[k] == 1 and k >= 0) {
              f[i - 1][(k + j) / 10] = 1;
              Digit[i - 1][(k + j) / 10] = j;
              Value[i - 1][(k + j) / 10] = k;
            }
        }
    }
    if (f[0][0] == 0) {
      cout << "-1\n";
    } else {
      for (int i = 1; i <= 6; i++) ans[i] = 0;
      int j = 0;
      for (int i = 0; i < len_Number; i++) {
        int Num = Value[i][j];
        for (int k = 1; k <= Digit4[Num]; k++) ans[k] = ans[k] * 10 + 4;
        for (int k = 1; k <= Digit7[Num]; k++)
          ans[k + Digit4[Num]] = ans[k + Digit4[Num]] * 10 + 7;
        for (int k = Digit4[Num] + Digit7[Num] + 1; k <= 6; k++) ans[k] *= 10;
        j = Digit[i][j];
      }
      for (int i = 1; i <= 6; i++) cout << ans[i] << ' ';
      cout << "\n";
    }
  }
  return 0;
}
