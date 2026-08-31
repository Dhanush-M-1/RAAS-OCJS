#include <bits/stdc++.h>
using namespace std;
vector<int> v;
int main() {
  ios::sync_with_stdio(0);
  string s;
  v.push_back(1);
  while (cin >> s) {
    if (s == "=") break;
    if (s == "-") v.push_back(-1);
    if (s == "+") v.push_back(+1);
  }
  int n;
  cin >> n;
  int mn = 0;
  for (auto &x : v) {
    if (x < 0) x *= n;
    mn += x;
  }
  int sum = mn;
  if (mn > n) {
    cout << "Impossible" << endl;
    return 0;
  };
  for (auto &x : v) {
    x += min(n - 1, n - sum);
    sum += min(n - 1, n - sum);
  }
  if (sum != n) {
    cout << "Impossible" << endl;
    return 0;
  };
  cout << "Possible" << endl;
  cout << v[0] << " ";
  for (int i = 1; i < v.size(); i++)
    if (v[i] < 0)
      cout << "- " << -1 * v[i] << " ";
    else
      cout << "+ " << v[i] << " ";
  cout << "= " << n << endl;
  return 0;
}
