#include <bits/stdc++.h>
using namespace std;
float n, x, y;
float f, o;
int ans, s;
inline void input() {
  cin >> n >> x >> y;
  f = n / 100;
  f *= y;
  ans = f / 1;
  f -= ans;
  if (f > 0)
    f = ans + 1;
  else
    f = ans;
  s = x;
  ans = f;
  cout << max(0, ans - s);
}
int main() { input(); }
