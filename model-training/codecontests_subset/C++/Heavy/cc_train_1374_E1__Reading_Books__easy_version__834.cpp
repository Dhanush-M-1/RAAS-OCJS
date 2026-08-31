#include <bits/stdc++.h>
using namespace std;
const int md = 1000000007;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  int tt{}, T{};
  tt = 1;
  while (tt--) {
    long long n{}, m{}, k{}, a{}, b{}, c{}, f{}, p = -1, sum = 0;
    long long ans{};
    cin >> n >> k;
    std::vector<long long> alice, bob, both;
    for (long long i = 0; i < n; ++i) {
      cin >> a >> b >> c;
      if (b * c) {
        both.push_back(a);
        f += a;
      } else if (b) {
        alice.push_back(a);
      } else if (c) {
        bob.push_back(a);
      } else {
        p = max(a, p);
      }
      sum += a;
    }
    sort(both.begin(), both.end());
    sort(alice.begin(), alice.end());
    sort(bob.begin(), bob.end());
    a = alice.size();
    b = bob.size();
    c = both.size();
    if (k > c + min(a, b)) {
      cout << "-1\n";
      return 0;
    }
    for (int i = 0; i < min(a, b); ++i) {
      both.push_back(alice[i] + bob[i]);
    }
    sort(both.begin(), both.end());
    cout << accumulate(both.begin(), both.begin() + k, 0LL) << "\n";
  }
  return 0;
}
