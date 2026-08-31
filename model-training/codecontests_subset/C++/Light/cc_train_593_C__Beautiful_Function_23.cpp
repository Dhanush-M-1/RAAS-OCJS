#include <bits/stdc++.h>
using namespace std;
int n;
string make(int i, int a) {
  char st[10];
  sprintf(st, "%d", i);
  string num = string(st);
  string ret = "((1-abs((t-" + num + ")))+abs((1-abs((t-" + num + ")))))";
  sprintf(st, "%d", a / 2);
  num = string(st);
  return "(" + num + "*" + ret + ")";
}
int main() {
  scanf("%d", &n);
  string f = string("0");
  string g = string("0");
  for (int i = 0; i < n; i++) {
    int x, y, r;
    scanf("%d%d%d", &x, &y, &r);
    f = "(" + f + "+" + make(i, x) + ")";
    g = "(" + g + "+" + make(i, y) + ")";
  }
  cout << f << endl;
  cout << g << endl;
  return 0;
}
