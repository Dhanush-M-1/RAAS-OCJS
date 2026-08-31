#include <bits/stdc++.h>
using namespace std;
const int MAXN = 55;
int n;
int c[MAXN][3];
void load() {
  ios::sync_with_stdio(false);
  cin >> n;
  for (int i = 0; i < n; ++i) cin >> c[i][0] >> c[i][1] >> c[i][2];
}
void create(int x, int i, string &s) {
  char buff[50];
  sprintf(buff, "(%d*((1-abs((t-%d)))+abs((1-abs((t-%d))))))", x / 2, i, i);
  s = string(buff, strlen(buff));
}
void solve() {
  string x = "", y = "";
  for (int i = 0; i < n; ++i) {
    string w;
    create(c[i][0], i + 1, w);
    if (x.length())
      x = "(" + x + "+" + w + ")";
    else
      x = w;
    create(c[i][1], i + 1, w);
    if (y.length())
      y = "(" + y + "+" + w + ")";
    else
      y = w;
  }
  cout << x << endl;
  cout << y << endl;
}
int main() {
  load();
  solve();
  return 0;
}
