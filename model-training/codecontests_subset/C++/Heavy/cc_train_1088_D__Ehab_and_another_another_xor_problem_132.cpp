#include <bits/stdc++.h>
using namespace std;
long long ask(long long c, long long d) {
  cout << '?' << ' ' << c << ' ' << d << endl;
  cout.flush();
  long long ans;
  cin >> ans;
  return ans;
}
signed main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  long long a = 0, b = 0;
  long long ans = ask(0, 0);
  bool flag;
  if (ans == 1)
    flag = true;
  else
    flag = false;
  for (long long i = 30 - 1; i >= 0; i--) {
    long long ans1 = ask(a + (1 << i), b);
    long long ans2 = ask(a, b + (1 << i));
    if (ans1 == 1 && ans2 == -1) {
      continue;
    } else if (ans1 == -1 && ans2 == 1) {
      a += (1 << i);
      b += (1 << i);
    } else if (flag) {
      a += (1 << i);
      if (ans1 == 1)
        flag = true;
      else
        flag = false;
    } else {
      b += (1 << i);
      if (ans1 == 1)
        flag = true;
      else
        flag = false;
    }
  }
  cout << '!' << ' ' << a << ' ' << b << endl;
  cout.flush();
  return 0;
}
