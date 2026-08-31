#include <bits/stdc++.h>
using namespace std;
int a[50][50][50];
int main() {
  string s;
  cin >> s;
  int arr[13] = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
  int d = 0, m = 0, y = 0, mx = 0, ans1 = 0, ans2 = 0, ans3 = 0;
  for (int i = 0; i < s.size() - 9; i++) {
    if (s[i + 2] != '-' || s[i + 5] != '-') continue;
    bool c = false;
    for (int j = 0; j < 9; j++)
      if (j != 5 && j != 2 && s[i + j] == '-') c = true;
    if (c) continue;
    if (s[i + 6] != '2' || s[i + 7] != '0' || s[i + 8] != '1') continue;
    d = (s[i] - 48) * 10 + (s[i + 1] - 48);
    m = (s[i + 3] - 48) * 10 + (s[i + 4] - 48);
    y = s[i + 9] - 48;
    if (y < 3 || y > 5) continue;
    if (m < 1 || m > 12) continue;
    if (d < 1 || d > arr[m]) continue;
    a[y][m][d]++;
    if (a[y][m][d] > mx) {
      mx = a[y][m][d];
      ans1 = d;
      ans2 = m;
      ans3 = y;
    }
  }
  cout << ans1 / 10 << ans1 % 10 << "-" << ans2 / 10 << ans2 % 10 << "-201"
       << ans3 << endl;
  return 0;
}
