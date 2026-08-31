#include <bits/stdc++.h>
using namespace std;
map<char, string> we;
int n, x;
int a[5202][5202];
int pass(int bx) {
  int div = n / bx, cc, dd;
  int d = div * div, b = bx * bx, f = 0;
  for (int i = bx - 1; i < n; i += bx) {
    for (int j = bx - 1; j < n; j += bx) {
      cc = i - bx;
      dd = j - bx;
      int long long t = a[i][j];
      if (cc >= 0) t -= a[cc][j];
      if (dd >= 0) t -= a[i][dd];
      if (cc >= 0 && dd >= 0) t += a[cc][dd];
      if (t == 0 || t == b) f++;
    }
  }
  if (f == d)
    return 0;
  else
    return 1;
}
int main() {
  we['0'] = "0000";
  we['1'] = "0001";
  we['2'] = "0010";
  we['3'] = "0011";
  we['4'] = "0100";
  we['5'] = "0101";
  we['6'] = "0110";
  we['7'] = "0111";
  we['8'] = "1000";
  we['9'] = "1001";
  we['A'] = "1010";
  we['B'] = "1011";
  we['C'] = "1100";
  we['D'] = "1101";
  we['E'] = "1110";
  we['F'] = "1111";
  scanf("%d", &n);
  vector<int> v;
  for (int i = 1; i * i <= n; i++) {
    if (n % i == 0) {
      v.push_back(i);
      v.push_back(n / i);
    }
  }
  sort(v.begin(), v.end());
  x = n / 4;
  char cd, c;
  for (int i = 0; i < n; i++) {
    scanf("%c", &cd);
    for (int j = 0; j < n; j += 4) {
      scanf("%c", &c);
      string s = we[c];
      a[i][j] = 1;
      a[i][j + 1] = 1;
      a[i][j + 2] = 1;
      a[i][j + 3] = 1;
      if (s[0] == '0') a[i][j] = 0;
      if (s[1] == '0') a[i][j + 1] = 0;
      if (s[2] == '0') a[i][j + 2] = 0;
      if (s[3] == '0') a[i][j + 3] = 0;
    }
  }
  for (int i = 1; i < n; i++) {
    for (int j = 0; j < n; j++) {
      a[i][j] += a[i - 1][j];
    }
  }
  for (int i = 1; i < n; i++) {
    for (int j = 0; j < n; j++) {
      a[j][i] += a[j][i - 1];
    }
  }
  int cnt = v.size() - 1;
  while (cnt != 0 && pass(v[cnt]) == 1) {
    cnt--;
  }
  printf("%d", v[cnt]);
  return 0;
}
