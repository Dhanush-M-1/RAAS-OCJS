#include <bits/stdc++.h>
using namespace std;
void solve(vector<int> v) {
  int n = v.size();
  int x = v[0], y = v.back();
  v.insert(v.begin(), x);
  v.push_back(y);
  int D = (x + y) / 2;
  string s = to_string(D);
  assert(D >= 0 && D <= 50);
  for (int i = 1; i <= n; i++) {
    int d = (v[i + 1] + v[i - 1]) / 2 - v[i];
    assert(abs(d) <= 50);
    string aa = "abs((t-" + to_string(i - 1) + "))";
    string bb = "(" + to_string(abs(d)) + "*" + aa + ")";
    if (d > 0) {
      s = "(" + s + "+" + bb + ")";
    } else {
      s = "(" + s + "-" + bb + ")";
    }
  }
  cout << s << endl;
}
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  int n;
  cin >> n;
  vector<int> v1, v2;
  for (int i = 0; i < n; i++) {
    int x, y, r;
    cin >> x >> y >> r;
    if (x % 2) x++;
    if (y % 2) y++;
    v1.push_back(x);
    v2.push_back(y);
  }
  solve(v1);
  solve(v2);
}
