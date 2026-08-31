#include <bits/stdc++.h>
using namespace std;
int n, k, ans;
multiset<int> alice, bob, both;
int main() {
  cin >> n >> k;
  for (int i = 0; i < n; i++) {
    int t, a, b;
    cin >> t >> a >> b;
    if (a + b == 2)
      both.insert(t);
    else if (a)
      alice.insert(t);
    else if (b)
      bob.insert(t);
  }
  if (alice.size() + both.size() < k || bob.size() + both.size() < k)
    return cout << -1, 0;
  while (k && !both.empty() && !alice.empty() && !bob.empty()) {
    int fromAlice = *alice.begin(), fromBob = *bob.begin(),
        fromBoth = *both.begin();
    if (fromBoth > fromAlice + fromBob) {
      alice.erase(alice.begin());
      bob.erase(bob.begin());
      ans += fromAlice + fromBob;
    } else {
      both.erase(both.begin());
      ans += fromBoth;
    }
    k--;
  }
  while (k && !both.empty()) {
    ans += *both.begin();
    both.erase(both.begin());
    k--;
  }
  while (k && !alice.empty() && !bob.empty()) {
    ans += *alice.begin() + *bob.begin();
    alice.erase(alice.begin());
    bob.erase(bob.begin());
    k--;
  }
  cout << ans;
}
