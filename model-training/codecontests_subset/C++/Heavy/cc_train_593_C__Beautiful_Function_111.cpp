#include <bits/stdc++.h>
using namespace std;
string num(int x) {
  if (x > 50) return "(50+" + num(x - 50) + ")";
  return to_string(x);
}
string pt(int t, int x) {
  string v = "(t-" + to_string(t) + ")";
  return "(((abs((" + v + "-1))+abs((" + v + "+1)))-(abs(" + v + ")+abs(" + v +
         ")))*" + to_string(x / 2) + ")";
}
string solve(vector<int> &arr) {
  string res = pt(0, arr[0]);
  for (int i = 1; i < arr.size(); i++)
    res = "(" + res + "+" + pt(i, arr[i]) + ")";
  return res;
}
signed main() {
  std::ios::sync_with_stdio(false);
  cin.tie(0);
  int n, r;
  cin >> n;
  vector<int> x(n), y(n);
  for (int i = 0; i < n; i++) cin >> x[i] >> y[i] >> r;
  cout << solve(x) << "\n" << solve(y) << "\n";
}
