#include <bits/stdc++.h>
using namespace std;
bool compare(pair<int, int> a, pair<int, int> b) { return a.first < b.first; }
int main() {
  float r1, r2, c1, c2, d1, d2;
  cin >> r1 >> r2 >> c1 >> c2 >> d1 >> d2;
  float a = c1 / 2 + (d1 + r1 - d2 - r2) / 4;
  float c = c1 / 2 - (d1 + r1 - d2 - r2) / 4;
  float b = c2 / 2 + (r1 + d2 - r2 - d1) / 4;
  float d = c2 / 2 - (r1 + d2 - r2 - d1) / 4;
  if (a > 9 || a < 1) {
    cout << -1;
    return 0;
  }
  if (b > 9 || b < 1) {
    cout << -1;
    return 0;
  }
  if (c > 9 || c < 1) {
    cout << -1;
    return 0;
  }
  if (d > 9 || d < 1) {
    cout << -1;
    return 0;
  }
  if (a + b != r1) {
    cout << -1;
    return 0;
  }
  if (d + c != r2) {
    cout << -1;
    return 0;
  }
  if (a + c != c1) {
    cout << -1;
    return 0;
  }
  if (d + b != c2) {
    cout << -1;
    return 0;
  }
  if (a + d != d1) {
    cout << -1;
    return 0;
  }
  if (c + b != d2) {
    cout << -1;
    return 0;
  }
  if (a == b || a == c || a == d || b == c || b == d || c == d) {
    cout << -1;
    return 0;
  }
  cout << (int)a << " " << (int)b << endl << (int)c << " " << (int)d;
  return 0;
}
