#include <bits/stdc++.h>
using namespace std;
const long long mod = 1e9 + 7;
int32_t main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  string s;
  cin >> s;
  long long n;
  cin >> n;
  long long flag = 0, cnt = 0, cnt1 = 0;
  for (long long i = 0; i < n; ++i) {
    string s1;
    cin >> s1;
    if (s1 == s || (s1[0] == s[1] && s1[1] == s[0])) {
      flag = 1;
    }
    if (s1[1] == s[0]) {
      ++cnt;
    }
    if (s1[0] == s[1]) {
      ++cnt1;
    }
    if (cnt >= 1 && cnt1 >= 1) {
      flag = 1;
    }
  }
  cout << (flag ? "YES" : "NO");
  return 0;
}
