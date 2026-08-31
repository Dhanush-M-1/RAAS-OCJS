#include <bits/stdc++.h>
using namespace std;
const int N = 1e4 + 100;
string a[N];
int n, ans = 1;
string toBinary(int x) {
  string res = "";
  while (x > 0) {
    res += (x % 2 ? '1' : '0');
    x /= 2;
  }
  while (res.length() < 4) res += '0';
  reverse(res.begin(), res.end());
  return res;
}
string convert(string s) {
  string res = "";
  for (int i = 0; i < s.size(); i++) {
    if (s[i] >= '0' && s[i] <= '9')
      res += toBinary(s[i] - '0');
    else
      res += toBinary(10 + s[i] - 'A');
  }
  return res;
}
bool check(int x) {
  bool ok = true;
  for (int i = 0; i < n && ok; i += x)
    for (int j = 0; j < n && ok; j += x)
      for (int k = 0; k < x && ok; k++)
        for (int l = 0; l < x && ok; l++)
          if (a[i + k][j + l] != a[i][j]) ok = false;
  return ok;
}
int main() {
  ios_base::sync_with_stdio(false), cin.tie(0), cout.tie(0);
  cin >> n;
  for (int i = 0; i < n; i++) {
    string s;
    cin >> s;
    a[i] = convert(s);
  }
  for (int i = 2; i <= n; i++) {
    if (n % i == 0) {
      if (check(i)) ans = i;
    }
  }
  return cout << ans, 0;
}
