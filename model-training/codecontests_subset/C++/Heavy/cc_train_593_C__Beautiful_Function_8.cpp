#include <bits/stdc++.h>
using namespace std;
string f1, f2;
int main() {
  int n;
  cin >> n;
  for (int i = 0; i < n; i++) {
    int x, y, r;
    cin >> x >> y >> r;
    if (i) f1 += "+";
    if (i)
      f1 += "(" + to_string(x / 2) + "*(2-abs(((0-abs((t-" + to_string(i - 1) +
            ")))+abs((t-" + to_string(i + 1) + "))))))";
    else
      f1 += "(" + to_string(x / 2) + "*(2-abs(((0-abs((t+1)))+abs((t-" +
            to_string(i + 1) + "))))))";
    if (i) f2 += "+";
    if (i)
      f2 += "(" + to_string(y / 2) + "*(2-abs(((0-abs((t-" + to_string(i - 1) +
            ")))+abs((t-" + to_string(i + 1) + "))))))";
    else
      f2 += "(" + to_string(y / 2) + "*(2-abs(((0-abs((t+1)))+abs((t-" +
            to_string(i + 1) + "))))))";
    if (i) {
      f1 = "(" + f1 + ")";
      f2 = "(" + f2 + ")";
    }
  }
  cout << f1 << endl << f2;
}
