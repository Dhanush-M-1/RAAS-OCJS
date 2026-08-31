#include <bits/stdc++.h>
using namespace std;
string debug(long long x) {
  if (x == 0) cout << 0;
  stack<int> q;
  while (x != 0) {
    q.push(x % 2);
    x /= 2;
  }
  while (!q.empty()) {
    cout << q.top();
    q.pop();
  }
  return "";
}
int cmp(int x, int y) {
  if (x > y) return 1;
  if (x < y) return -1;
  return 0;
}
int main() {
  int ans, ans1, ans2;
  cout << "? 0 0" << endl;
  fflush(stdout);
  cin >> ans;
  long long r1 = 0, r2 = 0;
  long long tmp1, tmp2;
  for (int i = 29; i >= 0; --i) {
    if (ans == 0) ans = 1;
    tmp1 = r1, tmp2 = r2;
    tmp1 |= (1 << i);
    tmp2 |= (1 << i);
    cout << "? " << r1 << " " << tmp2 << endl;
    fflush(stdout);
    cin >> ans1;
    cout << "? " << tmp1 << " " << r2 << endl;
    fflush(stdout);
    cin >> ans2;
    if (ans1 == 0) ans1 = 1;
    if (ans2 == 0) ans2 = 1;
    if (ans == 1) {
      if (ans1 == 1 && ans2 == -1) {
        r1 |= (1 << i);
        r2 |= (1 << i);
        ans = 1;
      }
      if (ans1 == -1 && ans2 == 1) {
        ans = 1;
      }
      if (ans1 == 1 && ans2 == 1) {
        r1 |= (1 << i);
        ans = 1;
      }
      if (ans1 == -1 && ans2 == -1) {
        r1 |= (1 << i);
        ans = -1;
      }
    } else {
      if (ans1 == 1 && ans2 == -1) {
        r1 |= (1 << i);
        r2 |= (1 << i);
        ans = -1;
      }
      if (ans1 == -1 && ans2 == 1) {
        ans = -1;
      }
      if (ans1 == -1 && ans2 == -1) {
        r2 |= (1 << i);
        ans = -1;
      }
      if (ans1 == 1 && ans2 == 1) {
        r2 |= (1 << i);
        ans = 1;
      }
    }
  }
  cout << "! " << r1 << " " << r2 << endl;
  fflush(stdout);
  return 0;
}
