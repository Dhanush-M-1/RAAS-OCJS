#include <bits/stdc++.h>
using namespace std;
const int MN = 55;
int x[55], y[55];
string part[55];
int main() {
  ios ::sync_with_stdio(0);
  cin.tie(0);
  cout << (fixed) << setprecision(9);
  int n;
  while (cin >> n) {
    for (int i = (1), _b = (n); i <= _b; ++i) {
      cin >> x[i] >> y[i];
      x[i] /= 2;
      y[i] /= 2;
      int r;
      cin >> r;
    }
    for (int turn = 0, _a = (2); turn < _a; ++turn) {
      for (int i = (1), _b = (n); i <= _b; ++i) {
        stringstream ss;
        int cur = (turn == 0) ? x[i] : y[i];
        ss << '(' << cur << '*' << "((1-abs((t-" << i << ")))+abs((abs((t-" << i
           << "))-1)))" << ')';
        part[i] = ss.str();
      }
      string res = "";
      for (int i = (1), _b = (n); i <= _b; ++i) {
        if (i == 1)
          res = part[i];
        else
          res = '(' + res + '+' + part[i] + ')';
      }
      cout << res << endl;
    }
  }
}
