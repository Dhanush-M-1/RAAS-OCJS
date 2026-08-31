#include <bits/stdc++.h>
using namespace std;
const int N = 55;
string s1, s2;
int n;
void adds(string& s, int x[], int id) {
  if (id == n) {
    s += "0";
    return;
  }
  char buf[50], buf1[100];
  sprintf(buf, "(1-abs((t-%d)))", id);
  sprintf(buf1, "(%d*(%s+abs(%s)))", x[id] / 2, buf, buf);
  s += "(";
  s += buf1;
  s += "+";
  adds(s, x, id + 1);
  s += ")";
}
int main() {
  int x[N], y[N];
  cin >> n;
  for (int i = 0; i < n; ++i) {
    int r;
    cin >> x[i] >> y[i] >> r;
  }
  adds(s1, x, 0);
  adds(s2, y, 0);
  cout << s1 << "\n" << s2 << endl;
  return 0;
}
