#include <bits/stdc++.h>
using namespace std;
bool possible[20][10];
pair<int, pair<int, int>> back[20][10];
int t;
int main() {
  for (int j = 0; j < 10; j++) {
    possible[0][j] = false;
  }
  possible[0][0] = true;
  back[0][0] = make_pair(0, make_pair(0, 0));
  cin >> t;
  for (int c = 0; c < t; c++) {
    int64_t n;
    cin >> n;
    for (int i = 1; i < 20; i++) {
      int target_digit = n % 10;
      n = n / 10;
      for (int j = 0; j < 10; j++) {
        possible[i][j] = false;
        for (int n4 = 0; n4 <= 6; n4++) {
          for (int n7 = 0; n4 + n7 <= 6; n7++) {
            int x = n4 * 4 + n7 * 7;
            int digit = x % 10;
            int carry = (x - digit) / 10;
            if (carry == j && digit <= target_digit &&
                possible[i - 1][target_digit - digit]) {
              possible[i][j] = true;
              back[i][j] = make_pair(target_digit - digit, make_pair(n4, n7));
              goto end;
            } else if (carry == j - 1 && digit > target_digit &&
                       possible[i - 1][10 + target_digit - digit]) {
              possible[i][j] = true;
              back[i][j] =
                  make_pair(10 + target_digit - digit, make_pair(n4, n7));
              goto end;
            }
          }
        }
      end:;
      }
    }
    if (possible[19][0]) {
      int digits[6][20];
      for (int i = 0; i < 6; i++) {
        for (int j = 0; j < 20; j++) {
          digits[i][j] = 0;
        }
      }
      int j = 0;
      for (int i = 19; i >= 0; i--) {
        int j2 = get<0>(back[i][j]);
        int n4 = get<0>(get<1>(back[i][j]));
        int n7 = get<1>(get<1>(back[i][j]));
        int k = 0;
        for (int l = 0; l < n4; l++) {
          digits[k][i] = 4;
          k += 1;
        }
        for (int l = 0; l < n7; l++) {
          digits[k][i] = 7;
          k += 1;
        }
        j = j2;
      }
      int64_t numbers[6];
      for (int i = 0; i < 6; i++) {
        numbers[i] = 0;
        for (int j = 19; j >= 0; j--) {
          numbers[i] += digits[i][j];
          if (j > 1) {
            numbers[i] *= 10;
          }
        }
      }
      for (int i = 0; i < 6; i++) {
        cout << numbers[i] << " ";
      }
      printf("\n");
    } else {
      printf("-1\n");
    }
  }
}
