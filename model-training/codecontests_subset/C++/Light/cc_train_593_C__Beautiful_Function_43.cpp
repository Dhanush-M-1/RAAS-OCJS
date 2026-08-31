#include <bits/stdc++.h>
using namespace std;
string getone(int x, int i) {
  x /= 2;
  char tmp[10005];
  sprintf(tmp, "(%d*((1-abs((t-%d)))+abs((abs((t-%d))-1))))", x, i, i);
  string res(tmp);
  return res;
}
string getans(int n, int *X) {
  string ans = "";
  for (int i = 1; i <= n; ++i) {
    if (i == 1)
      ans = getone(X[i], i - 1);
    else
      ans = '(' + ans + '+' + getone(X[i], i - 1) + ')';
  }
  return ans;
}
int main() {
  int n;
  int X[55], Y[55], r;
  cin >> n;
  for (int i = 1; i <= n; ++i) {
    cin >> X[i] >> Y[i] >> r;
  }
  cout << getans(n, X) << endl << getans(n, Y) << endl;
}
