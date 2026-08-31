#include <bits/stdc++.h>
using namespace std;
string a;
int cnt[40][20][10];
int m[13] = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
int main() {
  cin >> a;
  int n = a.size(), mx = 0, ansd = 0, ansm = 0, ansy = 0;
  for (int i = 0; i + 9 < n; i++) {
    if (a[i] == '-' || a[i + 1] == '-' || a[i + 2] != '-' || a[i + 3] == '-' ||
        a[i + 4] == '-' || a[i + 5] != '-' || a[i + 6] != '2' ||
        a[i + 7] != '0' || a[i + 8] != '1' || a[i + 9] == '-')
      continue;
    int dd = (a[i] - 48) * 10 + a[i + 1] - 48;
    int mm = (a[i + 3] - 48) * 10 + a[i + 4] - 48;
    int yy = a[i + 9] - 48;
    if (3 <= yy && yy <= 5 && 1 <= mm && mm <= 12 && 1 <= dd && dd <= m[mm]) {
      cnt[dd][mm][yy]++;
      if (cnt[dd][mm][yy] > mx) {
        mx = cnt[dd][mm][yy];
        ansd = dd;
        ansm = mm;
        ansy = yy;
      }
    }
  }
  printf("%d%d-%d%d-%d\n", ansd / 10, ansd % 10, ansm / 10, ansm % 10,
         2010 + ansy);
  return 0;
}
