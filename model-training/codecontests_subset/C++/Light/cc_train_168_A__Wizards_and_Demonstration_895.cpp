#include <bits/stdc++.h>
using namespace std;
struct s1 {
  int a;
  int b;
};
bool cp(s1 a2, s1 b2) {
  if (a2.a != b2.a)
    return a2.a > b2.a;
  else
    return a2.b < b2.b;
}
int main() {
  float n, x, y, i, buf = 0;
  float f, d;
  cin >> n >> x >> y;
  f = n * y / 100;
  if (f == int(f))
    d = int(f);
  else
    d = int(f) + 1;
  d = d - x;
  if (d < 0)
    cout << 0;
  else
    cout << d;
  return 0;
}
