#include <bits/stdc++.h>
using namespace std;
const int N = 5212;
int n;
int cnt[N][N];
bool a[N][N];
int main() {
  scanf("%d", &n);
  for (int i = 0; i < n; i++) {
    string s;
    cin >> s;
    for (int j = 0; j < n / 4; j++) {
      int val = 0;
      if (s[j] >= '0' && s[j] <= '9')
        val = s[j] - '0';
      else
        val = s[j] - 'A' + 10;
      a[i][4 * j + 3] = (val & 1);
      val /= 2;
      a[i][4 * j + 2] = (val & 1);
      val /= 2;
      a[i][4 * j + 1] = (val & 1);
      val /= 2;
      a[i][4 * j + 0] = (val & 1);
    }
  }
  for (int i = 0; i < n; i++) {
    for (int j = 0; j < n; j++) {
      cnt[i][j] = a[i][j];
      if (i) cnt[i][j] += cnt[i - 1][j];
      if (j) cnt[i][j] += cnt[i][j - 1];
      if (i && j) cnt[i][j] -= cnt[i - 1][j - 1];
    }
  }
  int ans = 1;
  for (int i = 2; i <= n; i++) {
    if (n % i == 0) {
      bool C = 0;
      int x = i;
      for (int j = i - 1; j < n; j += i) {
        for (int l = i - 1; l < n; l += i) {
          int val = cnt[j][l];
          if (j >= x) val -= cnt[j - x][l];
          if (l >= x) val -= cnt[j][l - x];
          if (l >= x && j >= x) val += cnt[j - x][l - x];
          if (val == 0 || val == (i * i))
            ;
          else
            C = 1;
        }
      }
      if (!C) ans = i;
    }
  }
  cout << ans;
  return 0;
}
