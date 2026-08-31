#include <bits/stdc++.h>
using namespace std;
int n, a[15][15];
string change(int);
int main() {
  std::ios::sync_with_stdio(false);
  cin >> n;
  for (int i = 1; i <= n - 1; i++)
    for (int j = 1; j <= n - 1; j++) a[i][j] = i * j;
  if (n != 10) {
    for (int i = 1; i <= n - 1; i++)
      for (int j = 1; j <= n - 1; j++) {
        stringstream ss;
        ss.clear();
        ss.str("");
        ss << change(a[i][j]);
        ss >> a[i][j];
      }
  }
  for (int i = 1; i <= n - 1; i++) {
    for (int j = 1; j <= n - 1; j++) cout << a[i][j] << " ";
    cout << endl;
  }
  return 0;
}
string change(int x) {
  stringstream ss;
  string s, temp;
  s = "";
  while (x > 0) {
    ss.clear();
    ss.str("");
    ss << x % n;
    ss >> temp;
    s = temp + s;
    x /= n;
  }
  return s;
}
