#include <bits/stdc++.h>
using namespace std;
string s;
int dp[20][54][7];
string ans[7];
int fun(int pos, int sum, int lf) {
  if (pos == ((int)(s.size()))) {
    return sum == 0;
  }
  int& ret = dp[pos][sum][lf];
  if (ret != -1) return ret;
  ret = 0;
  int t1;
  if (!lf) {
    t1 = sum % 10;
    if (t1 == (s[pos] - '0')) {
      ret |= fun(pos + 1, sum / 10, 6);
    }
    return ret;
  }
  ret |= fun(pos, sum, lf - 1);
  ret |= fun(pos, sum + 4, lf - 1);
  ret |= fun(pos, sum + 7, lf - 1);
  return ret;
}
void fun2(int pos, int sum, int lf) {
  if (pos == ((int)(s.size()))) {
    return;
  }
  int ret;
  ret = 0;
  int t1;
  if (!lf) {
    fun2(pos + 1, sum / 10, 6);
    return;
  }
  ret |= fun(pos, sum, lf - 1);
  if (ret) {
    ans[lf] += "0";
    fun2(pos, sum, lf - 1);
    return;
  }
  ret |= fun(pos, sum + 4, lf - 1);
  if (ret) {
    ans[lf] += "4";
    fun2(pos, sum + 4, lf - 1);
    return;
  }
  ret |= fun(pos, sum + 7, lf - 1);
  if (ret) {
    ans[lf] += "7";
    fun2(pos, sum + 7, lf - 1);
    return;
  }
}
string form(string s) {
  string ret = "";
  for (int i(0), _n(((int)(s.size()))); i < _n; ++i) {
    if (s[i] == '0') {
      if (((int)(ret.size()))) ret += s[i];
    } else
      ret += s[i];
  }
  if (!((int)(ret.size()))) return "0";
  return ret;
}
int main() {
  int test;
  cin >> test;
  for (int i(0), _n(test); i < _n; ++i) {
    cin >> s;
    reverse(s.begin(), s.end());
    memset(dp, -1, sizeof(dp));
    for (int i(0), _n(7); i < _n; ++i) ans[i] = "";
    if (!fun(0, 0, 6)) {
      cout << -1 << endl;
    } else {
      fun2(0, 0, 6);
      for (int i(0), _n(7); i < _n; ++i) reverse(ans[i].begin(), ans[i].end());
      for (int i(0), _n(6); i < _n; ++i) cout << form(ans[i + 1]) << " ";
      cout << endl;
    }
  }
}
