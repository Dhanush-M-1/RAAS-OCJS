#include <bits/stdc++.h>
using namespace std;
long long a, b, u, v, x, y, o;
bool check(long long a, long long b) {
  if (!o) return (a == u && b == v);
  return ((u - a) * x + (v - b) * y) % o == 0 &&
         ((a - u) * y + (v - b) * x) % o == 0;
}
int main() {
  cin >> a >> b >> u >> v >> x >> y;
  o = x * x + y * y;
  if (check(a, b) || check(b, -a) || check(-a, -b) || check(-b, a))
    cout << "YES";
  else
    cout << "NO";
  return 0;
}
