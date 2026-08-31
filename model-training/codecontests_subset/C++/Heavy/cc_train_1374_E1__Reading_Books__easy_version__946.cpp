#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  long long int n, count;
  cin >> n >> count;
  vector<long long int> both, alice, bob;
  long long int time, b, c;
  for (int i = 0; i < n; i++) {
    cin >> time >> b >> c;
    if (b == 1 && c == 1)
      both.push_back(time);
    else if (b == 1 || c == 1) {
      if (b == 1)
        alice.push_back(time);
      else
        bob.push_back(time);
    }
  }
  long long int minsize = both.size() + 0LL + min(alice.size(), bob.size());
  if (minsize < count) {
    cout << -1;
    return 0;
  }
  minsize -= both.size();
  if (both.size() > 0) sort(both.begin(), both.end());
  if (alice.size() > 0) sort(alice.begin(), alice.end());
  if (bob.size() > 0) sort(bob.begin(), bob.end());
  long long int total = count;
  vector<long long int> both_sum(both.size() + 1, 0),
      alice_sum(alice.size() + 1, 0), bob_sum(bob.size() + 1, 0);
  both_sum[0] = 0;
  alice_sum[0] = 0;
  bob_sum[0] = 0;
  for (long long int i = 0; i < both.size(); i++)
    both_sum[i + 1] = both[i] + both_sum[i];
  for (long long int i = 0; i < alice.size(); i++)
    alice_sum[i + 1] = alice[i] + alice_sum[i];
  for (long long int i = 0; i < bob.size(); i++)
    bob_sum[i + 1] = bob[i] + bob_sum[i];
  long long int ans = LLONG_MAX;
  minsize = min(minsize, count);
  for (long long int i = minsize; i >= 0; i--) {
    long long int right = total - i;
    if (right >= both_sum.size()) break;
    long long int rightval = both_sum[right] + alice_sum[i] + bob_sum[i];
    ans = min(ans, rightval);
  }
  if (ans == LLONG_MAX)
    cout << -1;
  else
    cout << ans;
  return 0;
}
