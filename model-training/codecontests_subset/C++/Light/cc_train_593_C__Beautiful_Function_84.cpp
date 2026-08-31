#include <bits/stdc++.h>
using namespace std;
string foo(int t, int x) {
  char tmp[256];
  sprintf(tmp, "(%d*((1-abs((t-%d)))+abs((1-abs((t-%d))))))", x / 2, t, t);
  string res(tmp);
  return res;
}
int main() {
  int n;
  scanf("%d", &n);
  int x, y, r;
  scanf("%d %d %d", &x, &y, &r);
  string f = foo(0, x);
  string g = foo(0, y);
  for (int i = 1; i < n; i++) {
    scanf("%d %d %d", &x, &y, &r);
    f = '(' + f + '+' + foo(i, x) + ')';
    g = '(' + g + '+' + foo(i, y) + ')';
  }
  cout << f << endl << g;
  return 0;
}
