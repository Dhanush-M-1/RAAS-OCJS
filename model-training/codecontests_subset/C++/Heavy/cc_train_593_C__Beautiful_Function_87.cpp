#include <bits/stdc++.h>
using namespace std;
string B(int i) {
  return "((1-abs((t-" + to_string(i) + ")))+abs((1-abs((t-" + to_string(i) +
         ")))))";
}
void printcomp(int i, int j) { cout << "(" << i / 2 << "*" << B(j) << ")"; }
int main() {
  int n;
  vector<int> xs, ys;
  int r;
  cin >> n;
  xs.resize(n);
  ys.resize(n);
  for (int c = 0; c < n; c++) {
    cin >> xs[c] >> ys[c] >> r;
    if (c) cout << "(";
  }
  for (int c = 0; c < n; c++) {
    if (c) cout << "+";
    printcomp(xs[c], c);
    if (c) cout << ")";
  }
  cout << endl;
  for (int c = 1; c < n; c++) cout << "(";
  for (int c = 0; c < n; c++) {
    if (c) cout << "+";
    printcomp(ys[c], c);
    if (c) cout << ")";
  }
  cout << endl;
  return 0;
}
