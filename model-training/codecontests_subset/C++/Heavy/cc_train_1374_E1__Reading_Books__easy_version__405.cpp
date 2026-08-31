#include <bits/stdc++.h>
using namespace std;
int32_t main() {
  ios::sync_with_stdio(false);
  cin.tie(nullptr);
  long long t = 1;
  while (t--) {
    long long n, k;
    ;
    cin >> n >> k;
    multiset<long long> alice, bob, both;
    for (long long i = 0; i < n; i++) {
      long long ti, ai, bi;
      cin >> ti >> ai >> bi;
      if (ai == 1 && bi == 1)
        both.insert(ti);
      else if (ai == 1)
        alice.insert(ti);
      else if (bi == 1)
        bob.insert(ti);
    }
    long long ans = 0;
    while (k > 0) {
      if (!alice.empty() && !bob.empty() && !both.empty()) {
        long long a = *alice.begin();
        long long b = *bob.begin();
        long long c = *both.begin();
        if (a + b < c) {
          ans += a + b;
          alice.erase(alice.find(a));
          bob.erase(bob.find(b));
        } else {
          ans += c;
          both.erase(both.find(c));
        }
      } else if (!both.empty()) {
        long long x = *both.begin();
        ans += x;
        both.erase(both.find(x));
      } else if (!alice.empty() && !bob.empty()) {
        long long a = *alice.begin();
        long long b = *bob.begin();
        ans += a + b;
        alice.erase(alice.find(a));
        bob.erase(bob.find(b));
      } else {
        ans = -1;
        break;
      }
      k--;
    }
    cout << ans << endl;
  }
}
