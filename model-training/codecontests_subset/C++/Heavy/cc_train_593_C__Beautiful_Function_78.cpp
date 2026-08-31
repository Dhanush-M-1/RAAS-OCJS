#include <bits/stdc++.h>
using namespace std;
int n, y[101], x[101];
vector<string> xs, ys;
string constant(int c) {
  stringstream s;
  (c < 0) ? s << "(0-" << -c << ")" : s << c;
  return s.str();
}
void print_func(vector<string> &terms, int c) {
  if (terms.size() == 0)
    cout << constant(c) << endl;
  else if (terms.size() == 1)
    cout << "(" << terms[0] << "+" << constant(c) << ")" << endl;
  else {
    for (int i = 0; i < terms.size(); i++) cout << "(";
    cout << terms[0] << "+";
    for (int i = 1; i < terms.size(); i++) cout << terms[i] << ")+";
    cout << constant(c) << ")" << endl;
  }
}
int main() {
  cin >> n;
  for (int i = 0, r; i < n; i++) {
    cin >> x[i] >> y[i] >> r;
    if (x[i] % 2) x[i] ? x[i]-- : x[i]++;
    if (y[i] % 2) y[i] ? y[i]-- : y[i]++;
  }
  int c = 0;
  for (int i = 1; i < n; i++) {
    stringstream s;
    int m = (x[i] - x[i - 1]) / 2;
    s << "(" << constant(m) << "*";
    s << "(abs((t-" << i << "))-abs((" << i + 1 << "-t))))";
    xs.push_back(s.str());
    c -= m;
  }
  print_func(xs, x[0] - c);
  c = 0;
  for (int i = 1; i < n; i++) {
    stringstream s;
    int m = (y[i] - y[i - 1]) / 2;
    s << "(" << constant(m) << "*";
    s << "(abs((t-" << i << "))-abs((" << i + 1 << "-t))))";
    ys.push_back(s.str());
    c -= m;
  }
  print_func(ys, y[0] - c);
}
