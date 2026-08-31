#include <bits/stdc++.h>
using namespace std;
const int MOD = 1000000007;
const int oo = 1e9;
const int N = 1e5 + 10;
int t, dp[20][11];
char tmp[21];
string s, p[6];
int calc(int idx, int carry) {
  if (idx == 19) return (carry == 0);
  int &ret = dp[idx][carry];
  if (ret != -1) return ret;
  ret = 0;
  for (int i = 0; i <= 6; ++i)
    for (int j = 0; j + i <= 6; ++j) {
      int cs = i * 7 + j * 4 + carry;
      if (calc(idx + 1, cs / 10) && s[idx] - '0' == cs % 10) ret = 1;
    }
  return ret;
}
void build(int idx, int carry) {
  if (idx == 19) return;
  for (int i = 0; i <= 6; ++i)
    for (int j = 0; j + i <= 6; ++j) {
      int cs = i * 7 + j * 4 + carry;
      if (calc(idx + 1, cs / 10) && s[idx] - '0' == cs % 10) {
        int f = 0;
        for (int k = 0; k < i; ++k) p[f++] += '7';
        for (int k = 0; k < j; ++k) p[f++] += '4';
        for (int k = 0; k < 6 - (i + j); ++k) p[f++] += '0';
        build(idx + 1, cs / 10);
        return;
      }
    }
}
int main() {
  cin >> t;
  while (t--) {
    scanf("%s", tmp);
    s = tmp;
    memset(dp, -1, sizeof dp);
    reverse(s.begin(), s.end());
    while (s.size() <= 18) s += '0';
    for (int i = 0; i < 6; ++i) p[i] = "";
    if (calc(0, 0)) {
      build(0, 0);
      for (int i = 0; i < 6; ++i) reverse(p[i].begin(), p[i].end());
      for (int i = 0; i < 6; ++i) {
        if (i) printf(" ");
        int idx = 0;
        while (idx < p[i].size() && p[i][idx] == '0') idx++;
        if (idx == p[i].size()) {
          printf("0");
        } else {
          for (int j = idx; j < p[i].size(); ++j) printf("%c", p[i][j]);
        }
      }
      puts("");
    } else {
      puts("-1");
    }
  }
  return 0;
}
