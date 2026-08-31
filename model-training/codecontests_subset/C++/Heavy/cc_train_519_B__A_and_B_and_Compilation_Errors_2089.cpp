#include <bits/stdc++.h>
using namespace std;
int32_t main() {
  ios_base::sync_with_stdio(0), cin.tie(0);
  long long tc = 1;
  while (tc--) {
    long long n;
    cin >> n;
    unordered_map<long long, long long> cnt;
    vector<long long> a(n), b(n - 1);
    for (auto &x : a) {
      cin >> x;
      cnt[x]++;
    }
    for (auto &x : b) {
      cin >> x;
      cnt[x]--;
    }
    for (auto xy : cnt)
      if (xy.second == 1) {
        cout << xy.first << '\n';
        cnt[xy.first]--;
      }
    for (auto &x : b) {
      cnt[x]++;
    }
    for (long long i = 0; i < n - 2; i++) {
      long long x;
      cin >> x;
      cnt[x]--;
    }
    for (auto xy : cnt)
      if (xy.second == 1) {
        cout << xy.first << '\n';
        cnt[xy.first]--;
      }
  }
  return 0;
}
