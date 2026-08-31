#include <bits/stdc++.h>
using namespace std;
const int inf = (int)1e9;
long long A(long long x) {
  if (x >= 0)
    return x;
  else
    return -x;
}
long long gcd(long long a, long long b) {
  if (b > a) {
    long long tmp = b;
    b = a;
    a = tmp;
  }
  if (a % b == 0)
    return b;
  else
    return gcd(b, a % b);
}
unsigned long long popcount(unsigned long long x) {
  x = ((x & 0xaaaaaaaaaaaaaaaaUL) >> 1) + (x & 0x5555555555555555UL);
  x = ((x & 0xccccccccccccccccUL) >> 2) + (x & 0x3333333333333333UL);
  x = ((x & 0xf0f0f0f0f0f0f0f0UL) >> 4) + (x & 0x0f0f0f0f0f0f0f0fUL);
  x = ((x & 0xff00ff00ff00ff00UL) >> 8) + (x & 0x00ff00ff00ff00ffUL);
  x = ((x & 0xffff0000ffff0000UL) >> 16) + (x & 0x0000ffff0000ffffUL);
  x = ((x & 0xffffffff00000000UL) >> 32) + (x & 0x00000000ffffffffUL);
  return x;
}
int main(void) {
  int T;
  T = 1;
  for (int query = 0; query < T; query++) {
    int n, k;
    cin >> n >> k;
    priority_queue<long long, vector<long long>, greater<long long> > both, bob,
        alice;
    for (int i = 0; i < n; i++) {
      long long t;
      int a, b;
      cin >> t >> a >> b;
      if (a == 1) {
        if (b == 0)
          alice.push(t);
        else
          both.push(t);
      } else {
        if (b == 1) bob.push(t);
      }
    }
    if (alice.size() + both.size() < k || bob.size() + both.size() < k) {
      cout << -1 << endl;
    } else {
      long long ans = 0;
      while (k > 0) {
        if (both.size() == 0) {
          while (k > 0) {
            long long ali = alice.top();
            long long bo = bob.top();
            alice.pop();
            bob.pop();
            ans += ali + bo;
            k--;
          }
        } else {
          if (alice.size() == 0) {
            while (k > 0) {
              long long c = both.top();
              both.pop();
              ans += c;
              k--;
            }
            break;
          }
          if (bob.size() == 0) {
            while (k > 0) {
              long long c = both.top();
              both.pop();
              ans += c;
              k--;
            }
            break;
          }
          long long a = alice.top();
          long long b = bob.top();
          long long c = both.top();
          if (c > a + b) {
            ans += a + b;
            k--;
            bob.pop();
            alice.pop();
          } else {
            ans += c;
            k--;
            both.pop();
          }
        }
      }
      cout << ans << endl;
    }
  }
  return 0;
}
