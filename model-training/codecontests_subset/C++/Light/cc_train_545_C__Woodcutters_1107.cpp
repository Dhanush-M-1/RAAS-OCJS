#include <bits/stdc++.h>
using namespace std;
struct point {
  int coord;
  int length;
};
int main() {
  int n;
  cin >> n;
  if (n < 3) {
    cout << n << endl;
    return 0;
  }
  int sum = 1;
  point p1, p2, p3;
  cin >> p1.coord >> p1.length;
  cin >> p2.coord >> p2.length;
  cin >> p3.coord >> p3.length;
  for (int i = 0; i < n - 2; ++i) {
    if (p2.coord - p1.coord > p2.length) {
      sum++;
    } else if (p3.coord - p2.coord > p2.length) {
      sum++;
      p2.coord += p2.length;
    }
    p1 = p2;
    p2 = p3;
    if (i != n - 3) cin >> p3.coord >> p3.length;
  }
  cout << sum + 1 << endl;
  return 0;
}
