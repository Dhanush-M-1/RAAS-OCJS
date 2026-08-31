#include <bits/stdc++.h>
using namespace std;
int fun(int a, int b, int c) {
  int count = 0;
  while (c > 1 && b > 0) {
    count += 3;
    c -= 2;
    b--;
  }
  if (b < 1) return count;
  while (a > 0 && b > 1) {
    count += 3;
    a--;
    b -= 2;
  }
  return count;
}
int main() {
  int T;
  cin >> T;
  while (T--) {
    int a, b, c;
    cin >> a >> b >> c;
    cout << fun(a, b, c) << endl;
  }
}
