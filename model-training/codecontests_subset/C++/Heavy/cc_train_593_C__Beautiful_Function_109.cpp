#include <bits/stdc++.h>
using namespace std;
bool debug = 0;
int n, m, k;
int dx[4] = {0, 1, 0, -1}, dy[4] = {1, 0, -1, 0};
long long ln, lk, lm;
int x[105], y[105], r[105];
string vs[2];
void add(int id, int i, int x) {
  string str = "(((1-abs((t-";
  str += to_string(i);
  str += ")))+abs((abs((t-";
  str += to_string(i);
  str += "))-1)))*";
  str += to_string(x);
  str += ")";
  if (vs[id] == "")
    vs[id] = str;
  else {
    vs[id] = "(" + vs[id] + "+" + str + ")";
  }
}
void fmain() {
  scanf("%d", &n);
  for (int(i) = 0; (i) < (int)(2); (i)++) vs[i] = "";
  for (int(i) = 0; (i) < (int)(n); (i)++) {
    scanf("%d%d%d", x + i, y + i, r + i);
    add(0, i + 1, x[i] / 2);
    add(1, i + 1, y[i] / 2);
  }
  for (int(i) = 0; (i) < (int)(2); (i)++) cout << vs[i] << endl;
}
int main() {
  fmain();
  return 0;
}
