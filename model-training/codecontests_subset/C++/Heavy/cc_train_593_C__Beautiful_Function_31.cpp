#include <bits/stdc++.h>
using namespace std;
string generateOne(int k, int A) {
  int B = A / 2;
  char temp[1000];
  sprintf(temp, "((1-abs((t-%d)))+abs((1-abs((t-%d)))))", k, k);
  string s(temp);
  sprintf(temp, "(%d*%s)", B, s.c_str());
  string res(temp);
  return res;
}
string generate(int n, const vector<int>& vals) {
  string res = "";
  for (int i = 0; i < n; i++) {
    string ff = generateOne(i, vals[i]);
    if (i == 0)
      res = ff;
    else
      res = "(" + res + "+" + ff + ")";
  }
  return res;
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  int n;
  cin >> n;
  vector<int> x(n), y(n), r(n);
  for (int i = 0; i < n; i++) cin >> x[i] >> y[i] >> r[i];
  string f = generate(n, x);
  string g = generate(n, y);
  cout << f << "\n";
  cout << g << "\n";
  return 0;
}
