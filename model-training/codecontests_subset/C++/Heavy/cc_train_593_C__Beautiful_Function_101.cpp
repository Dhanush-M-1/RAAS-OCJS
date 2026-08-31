#include <bits/stdc++.h>
using namespace std;
const long long mod = 1000000007;
string ati(int i) {
  string s;
  s = "abs((t";
  if (i < 0) {
    i = -i;
    s += "+";
  } else
    s += "-";
  s += to_string(i);
  s += "))";
  return s;
}
int main() {
  int n;
  cin >> n;
  string f = "0";
  string g = "0";
  int x, y, r;
  for (int i = 0; i < n; i++) {
    cin >> x >> y >> r;
    if (x % 2) x++;
    if (y % 2) y++;
    f = "(" + f + "+" + "(" + to_string(x / 2) + "*((" + ati(i - 1) + "+" +
        ati(i + 1) + ")-(" + ati(i) + "+" + ati(i) + ")))" + ")";
    g = "(" + g + "+" + "(" + to_string(y / 2) + "*((" + ati(i - 1) + "+" +
        ati(i + 1) + ")-(" + ati(i) + "+" + ati(i) + ")))" + ")";
  }
  cout << f << endl << g;
}
