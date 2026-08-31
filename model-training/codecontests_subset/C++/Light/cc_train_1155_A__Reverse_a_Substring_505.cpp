#include <bits/stdc++.h>
using namespace std;
const int MOD1 = 1e9 + 7;
const int MOD2 = 998244353;
const long long INF = 2 * 1e18;
const long double PI = 3.14159265358979323846;
int main() {
  long long n, cur = -1, cnt = -1;
  string s;
  cin >> n >> s;
  for (long long i = 0; i < n; i++) {
    if (i == 0) {
      cnt++;
      cur = s[i] - 'a';
      continue;
    }
    if (cur > s[i] - 'a') {
      cout << "YES\n" << cnt + 1 << " " << i + 1;
      return 0;
    } else {
      cur = s[i] - 'a';
      cnt++;
    }
  }
  cout << "NO";
}
