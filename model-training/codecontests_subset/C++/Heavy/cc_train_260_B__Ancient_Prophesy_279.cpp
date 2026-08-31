#include <bits/stdc++.h>
using namespace std;
int cnt[42][42][42];
char s[555555];
int every_month[13] = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
int main() {
  scanf("%s", s);
  int n = strlen(s);
  int mx = 0, ad = 0, am = 0, ay = 0;
  memset(cnt, 0, sizeof(cnt));
  for (int i = 0; i + 9 < n; i++) {
    if (s[i + 2] != '-' || s[i + 5] != '-') continue;
    int flag = 1;
    for (int j = 0; j < 10; j++) {
      if (j != 2 && j != 5 && s[i + j] == '-') flag = 0;
    }
    if (!flag) continue;
    int dd = (s[i] - '0') * 10 + (s[i + 1] - '0');
    int mm = (s[i + 3] - '0') * 10 + (s[i + 4] - '0');
    if (s[i + 6] != '2' || s[i + 7] != '0' || s[i + 8] != '1') continue;
    int yy = s[i + 9] - '0';
    if (yy < 3 || yy > 5) continue;
    if (mm < 1 || mm > 12) continue;
    if (dd < 1 || dd > every_month[mm]) continue;
    cnt[dd][mm][yy]++;
    if (cnt[dd][mm][yy] > mx) {
      mx = cnt[dd][mm][yy];
      ad = dd, am = mm, ay = yy;
    }
  }
  printf("%02d-%02d-%d", ad, am, ay + 2010);
  return 0;
}
