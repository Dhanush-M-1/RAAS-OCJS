#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  long long int n, k, t, a, b;
  cin >> n >> k;
  vector<long long int> time, alice, bob, both;
  for (long long int i = 0; i < n; i++) {
    cin >> t >> a >> b;
    if (a && b) {
      both.push_back(t);
    } else if (a) {
      alice.push_back(t);
    } else if (b) {
      bob.push_back(t);
    }
  }
  if (alice.size() + both.size() < k || bob.size() + both.size() < k) {
    cout << "-1\n";
    return 0;
  }
  sort(alice.begin(), alice.end());
  sort(bob.begin(), bob.end());
  sort(both.begin(), both.end());
  long long int i_a = 0, i_b = 0, idx = 0, cost = 0;
  while (true) {
    if (i_a < alice.size() && i_b < bob.size()) {
      if (idx < both.size()) {
        if (alice[i_a] + bob[i_b] <= both[idx]) {
          cost += (alice[i_a] + bob[i_b]);
          i_a++;
          i_b++;
        } else {
          cost += both[idx];
          idx++;
        }
      } else {
        cost += (alice[i_a] + bob[i_b]);
        i_a++;
        i_b++;
      }
    } else {
      cost += both[idx];
      idx++;
    }
    if ((i_a == k - idx) && (i_b == k - idx)) {
      break;
    }
  }
  cout << cost;
}
