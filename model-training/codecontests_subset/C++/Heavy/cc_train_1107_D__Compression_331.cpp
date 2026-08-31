#include <bits/stdc++.h>
using namespace std;
const int maxn = 5205;
bitset<maxn> matrix[maxn];
int re_sum[maxn][maxn];
int convert(char x) { return isdigit(x) ? x - '0' : x - 'A' + 10; }
int get_sum(int r1, int r2, int c1, int c2) {
  return re_sum[r2][c2] - re_sum[r1][c2] - re_sum[r2][c1] + re_sum[r1][c1];
}
char data[maxn];
int n;
int main(int argc, const char* argv[]) {
  scanf("%d", &n);
  for (int i = 0; i < n; ++i) {
    scanf("%s", data);
    reverse(data, data + n / 4);
    for (int j = 0; j < n; ++j)
      matrix[i][j] = (convert(data[j / 4]) >> j % 4) & 1;
  }
  for (int i = 0; i < n; ++i)
    for (int j = 0; j < n; ++j)
      re_sum[i + 1][j + 1] =
          re_sum[i + 1][j] + re_sum[i][j + 1] - re_sum[i][j] + matrix[i][j];
  for (int x = n; x; --x)
    if (n % x == 0) {
      int tag = 1;
      for (int i = 0; i < n && tag; i += x)
        for (int j = 0; j < n && tag; j += x) {
          int sum = get_sum(i, i + x, j, j + x);
          if (sum != x * x && sum) tag = 0;
        }
      if (tag) {
        cout << x << endl;
        return 0;
      }
    }
  return 0;
}
