#include <bits/stdc++.h>
const int MAX_N = (int)1e5 + 123;
const double eps = 1e-6;
const int inf = (int)1e9 + 123;
using namespace std;
string first, second;
int n;
string tostr(int x) {
  string now = (x > 0 ? "" : "0");
  while (x) {
    now += char(x % 10 + '0');
    x /= 10;
  }
  reverse(now.begin(), now.end());
  return now;
}
int main() {
  cin >> n;
  for (int i = 1, x, y, R; i <= n; i++) {
    cin >> x >> y >> R;
    string a = "1";
    string b = "abs((t-" + tostr(i) + "))";
    string now = "((" + a + "-" + b + ")" + "+abs((" + a + "-" + b + ")))";
    string l = "(" + tostr(x / 2) + "*" + now + ")";
    string r = "(" + tostr(y / 2) + "*" + now + ")";
    if (i == 1) {
      first = l, second = r;
    } else {
      first = "(" + first + "+" + l + ")";
      second = "(" + second + "+" + r + ")";
    }
  }
  cout << first << endl << second;
  return 0;
}
