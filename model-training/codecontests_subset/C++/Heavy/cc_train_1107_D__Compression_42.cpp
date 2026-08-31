#include <bits/stdc++.h>
using namespace std;
const int LIM = 1e5 + 5, MOD = 1e9 + 7;
const int N_MAX = 5205;
int N;
bitset<N_MAX> matrix[N_MAX];
int rect[N_MAX][N_MAX];
int get_rect(int r1, int r2, int c1, int c2) {
  return rect[r2][c2] - rect[r2][c1] - rect[r1][c2] + rect[r1][c1];
}
int hexconvert(char hex) { return isdigit(hex) ? hex - '0' : hex - 'A' + 10; }
int main() {
  cin >> N;
  char str[N_MAX];
  for (int i = 0; i < N; i++) {
    cin >> str;
    reverse(str, str + N / 4);
    for (int j = 0; j < N; j++)
      matrix[i][j] = (hexconvert(str[j / 4]) >> j % 4) & 1;
  }
  for (int i = 0; i < N; i++)
    for (int j = 0; j < N; j++)
      rect[i + 1][j + 1] =
          rect[i + 1][j] + rect[i][j + 1] - rect[i][j] + matrix[i][j];
  for (int x = N; x > 0; x--)
    if (N % x == 0) {
      bool good = true;
      for (int i = 0; i < N && good; i += x)
        for (int j = 0; j < N && good; j += x) {
          int sum = get_rect(i, i + x, j, j + x);
          if (sum != x * x && sum != 0) good = false;
        }
      if (good) {
        cout << x << '\n';
        return 0;
      }
    }
}
