#include <bits/stdc++.h>
using namespace std;
long long n, k, t, a, b, boths, alices, bobs, cnt[2], ans;
vector<int> both, alice, bob;
int main() {
  ios::sync_with_stdio(false), cin.tie(NULL), cout.tie(NULL);
  cin >> n >> k;
  for (int i = 0; i < n; i++) {
    cin >> t >> a >> b;
    if (a && b)
      both.push_back(t);
    else if (a)
      alice.push_back(t);
    else if (b)
      bob.push_back(t);
  }
  boths = both.size();
  alices = alice.size();
  bobs = bob.size();
  sort(both.begin(), both.end());
  sort(alice.begin(), alice.end());
  sort(bob.begin(), bob.end());
  while (k) {
    int s1 = 1 << 30, s2 = 1 << 30;
    if (boths <= cnt[0]) break;
    if (boths > cnt[0]) s1 = both[cnt[0]];
    if (cnt[1] < min(alices, bobs)) s2 = alice[cnt[1]] + bob[cnt[1]];
    if (s1 < s2)
      ans += s1, cnt[0]++, k--;
    else
      ans += s2, cnt[1]++, k--;
  }
  while (k--) {
    if (cnt[1] < min(alices, bobs))
      ans += alice[cnt[1]] + bob[cnt[1]], cnt[1]++;
    else
      return cout << "-1\n", 0;
  }
  cout << ans << '\n';
  return 0;
}
