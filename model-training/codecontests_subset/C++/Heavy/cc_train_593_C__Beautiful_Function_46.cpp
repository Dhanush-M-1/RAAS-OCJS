#include <bits/stdc++.h>
using namespace std;
string singleFunction(int c, int t_0) {
  string ret = "(";
  if (c < 0)
    ret += "(0-" + to_string(abs(c)) + ")";
  else
    ret += to_string(abs(c));
  ret += "*((t-" + to_string(t_0) + ")+abs((t-" + to_string(t_0) + "))))";
  return ret;
}
string makeFunction(int* x, int n) {
  int* dx = new int[n];
  int* c = new int[n];
  dx[0] = x[0];
  for (int i = 1; i < n; i++) dx[i] = x[i] - x[i - 1];
  c[0] = dx[0] / 2;
  for (int i = 1; i < n; i++) c[i] = (dx[i] - dx[i - 1]) / 2;
  string ret = "";
  for (int i = 0; i < n; i++) {
    if (i != n - 1) ret += "(";
    ret += singleFunction(c[i], i);
    if (i != n - 1) {
      ret += "+";
    }
  }
  for (int i = 0; i < n - 1; i++) ret += ")";
  return ret;
}
int main(void) {
  int n;
  cin >> n;
  int* x = new int[n];
  int* y = new int[n];
  int r;
  for (int i = 0; i < n; i++) {
    cin >> x[i] >> y[i] >> r;
    if (x[i] % 2 == 1) x[i]++;
    if (y[i] % 2 == 1) y[i]++;
  }
  cout << makeFunction(x, n) << endl;
  cout << makeFunction(y, n) << endl;
}
