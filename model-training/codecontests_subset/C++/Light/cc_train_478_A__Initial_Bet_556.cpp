#include <bits/stdc++.h>
using namespace std;
bool compare(pair<int, int> a, pair<int, int> b) {
  if (a.second == b.second) {
    return a.first < b.first;
  }
  return a.second > b.second;
}
int main() {
  int a, b, c, d, e;
  cin >> a >> b >> c >> d >> e;
  if ((a + b + c + d + e) % 5 != 0 ||
      (a == 0 && b == 0 && c == 0 && d == 0 && e == 0))
    cout << -1 << endl;
  else
    cout << (a + b + c + d + e) / 5 << endl;
  return 0;
}
