#include <bits/stdc++.h>
using namespace std;
int a, b, c, mul;
bool ok(int mid) {
  int dif = mul - (b * mid);
  int ans = (dif + b - 1) / b;
  if (ans <= c)
    return true;
  else
    return false;
}
void solve() {
  cin >> a >> b >> c;
  mul = a * c;
  int lo = 0;
  int hi = (mul + b - 1) / b;
  while (hi > lo) {
    int mid = (hi + lo) / 2;
    if (ok(mid)) {
      hi = mid;
    } else
      lo = mid + 1;
  }
  cout << lo;
}
int main() { solve(); }
