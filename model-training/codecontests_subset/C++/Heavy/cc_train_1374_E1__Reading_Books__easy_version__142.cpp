#include <bits/stdc++.h>
using namespace std;
vector<int> both, alice, bob;
int both_size = 0, alice_size = 0, bob_size = 0;
int main(int argc, char const *argv[]) {
  cin.sync_with_stdio(false);
  int N, k;
  cin >> N >> k;
  int min_, a, b;
  for (int i = 0; i < N; i++) {
    cin >> min_ >> a >> b;
    if (a == 1 and b == 1) {
      both.push_back(min_);
      both_size++;
    } else if (a == 1 and b == 0) {
      alice.push_back(min_);
      alice_size++;
    } else if (a == 0 and b == 1) {
      bob.push_back(min_);
      bob_size++;
    }
  }
  sort(alice.begin(), alice.end());
  sort(bob.begin(), bob.end());
  int m = min(alice_size, bob_size);
  both_size += m;
  if (both_size < k) {
    cout << "-1\n";
    return 0;
  }
  for (int i = 0; i < m; i++) {
    both.push_back(alice[i] + bob[i]);
  }
  sort(both.begin(), both.end());
  int ans = 0;
  for (int i = 0; i < k; i++) {
    ans += both[i];
  }
  cout << ans;
  return 0;
}
