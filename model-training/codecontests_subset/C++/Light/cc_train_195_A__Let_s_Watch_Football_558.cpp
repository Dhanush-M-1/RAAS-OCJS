#include <bits/stdc++.h>
using namespace std;
long double a, b, c, theta, tot;
long long st, en, mid, last;
bool check() {
  tot = 0.0;
  long double now = mid * b / a;
  int cnt = 0;
  while (cnt <= 100000) {
    tot += now;
    if (tot + 0.000000001 > c) return true;
    now = now * theta;
    cnt++;
  }
  return false;
}
int main() {
  cin >> a >> b >> c;
  st = 0, en = c * a;
  theta = b / a;
  check();
  while (st <= en) {
    mid = (st + en) / 2;
    if (check()) {
      last = mid;
      en = mid - 1;
    } else
      st = mid + 1;
  }
  cout << last << endl;
}
