#include <bits/stdc++.h>
using namespace std;
void solve() {
  auto get = [&](long long c, long long d) {
    cout << "? " << c << " " << d << endl;
    cout.flush();
    long long val;
    cin >> val;
    return val;
  };
  auto print = [&](long long a, long long b) {
    cout << "! " << a << " " << b << endl;
    cout.flush();
  };
  long long AgrtB = get(0, 0);
  long long curA = 0, curB = 0;
  for (long long i = 29; i >= 0; i--) {
    long long bit = 1 << i;
    long long v1 = get(curA ^ bit, curB);
    long long v2 = get(curA, curB ^ bit);
    if (v1 != v2) {
      if (v1 == -1) {
        curA = curA ^ bit;
        curB = curB ^ bit;
      }
    } else {
      if (AgrtB == 1) {
        curA = curA ^ bit;
      } else {
        curB = curB ^ bit;
      }
      AgrtB = v1;
    }
  }
  print(curA, curB);
}
int32_t main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  long long t;
  t = 1;
  while (t--) {
    solve();
  }
}
