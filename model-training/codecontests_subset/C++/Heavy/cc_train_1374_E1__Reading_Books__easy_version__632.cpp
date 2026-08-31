#include <bits/stdc++.h>
using namespace std;
long long n, m, p, q;
long long k;
pair<int, pair<int, int> > a[2000005];
int main() {
  cin >> n >> k;
  for (int i = 0; i < n; i++)
    cin >> a[i].first >> a[i].second.first >> a[i].second.second;
  sort(a, a + n);
  vector<int> alice, bob;
  int Alice = 0, Bob = 0;
  long long res = 0;
  for (int i = 0; i < n; i++) {
    if (a[i].second.first == 0 && a[i].second.second == 0) continue;
    if (Alice >= k && Bob >= k) {
      if (a[i].second.first == 1 && a[i].second.second == 1)
        if (alice.size() > 0 && bob.size() > 0) {
          if (alice[alice.size() - 1] + bob[bob.size() - 1] > a[i].first) {
            res += a[i].first - alice[alice.size() - 1] - bob[bob.size() - 1];
            alice.pop_back();
            bob.pop_back();
          }
        }
    } else {
      Alice += a[i].second.first;
      Bob += a[i].second.second;
      res += a[i].first;
      if (a[i].second.first == 1 && a[i].second.second == 0)
        alice.push_back(a[i].first);
      if (a[i].second.first == 0 && a[i].second.second == 1)
        bob.push_back(a[i].first);
      if (alice.size() > 0 && Alice > k) {
        res -= alice[alice.size() - 1];
        alice.pop_back();
        Alice--;
      }
      if (bob.size() > 0 && Bob > k) {
        res -= bob[bob.size() - 1];
        bob.pop_back();
        Bob--;
      }
    }
  }
  if (Alice < k || Bob < k)
    cout << -1;
  else
    cout << res;
}
