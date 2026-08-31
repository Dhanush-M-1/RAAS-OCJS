#include <bits/stdc++.h>
using namespace std;
const int MAXN = 1e3;
int x[MAXN], y[MAXN], r[MAXN];
string intTo(int k) {
  if (k == 0) return "0";
  string s = "";
  while (k > 0) s += '0' + k % 10, k /= 10;
  reverse((s).begin(), (s).end());
  return s;
}
int main() {
  int n;
  scanf("%d", &n);
  for (int i = 0; (i) < (n); ++i) scanf("%d%d%d", &x[i], &y[i], &r[i]);
  string f = "0", g = "0";
  for (int i = 0; (i) < (n); ++i) {
    string t = intTo(i);
    f = "(" + f + "+(" + intTo(x[i] / 2) + "*" + "(abs((abs((t-" + t +
        "))-1))-(abs((t-" + t + "))-1))" + "))";
    g = "(" + g + "+(" + intTo(y[i] / 2) + "*" + "(abs((abs((t-" + t +
        "))-1))-(abs((t-" + t + "))-1))" + "))";
  }
  cout << f << endl;
  cout << g << endl;
  return 0;
}
