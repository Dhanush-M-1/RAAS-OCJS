#include <bits/stdc++.h>
using namespace std;
mt19937 rng(chrono::steady_clock::now().time_since_epoch().count());
inline long long ceili(long long x, long long y) { return (x + y - 1) / y; }
void solve() {
  string pass;
  cin >> pass;
  long long n;
  cin >> n;
  vector<string> word(n);
  for (long long i = 0; i < n; ++i) {
    cin >> word[i];
    if (word[i] == pass) {
      cout << "YES"
           << "\n";
      return;
    }
  }
  bool first, second;
  first = second = false;
  for (long long i = 0; i < n; ++i) {
    if (pass[0] == word[i][1]) {
      first = true;
      break;
    }
  }
  for (long long i = 0; i < n; ++i) {
    if (pass[1] == word[i][0]) {
      second = true;
      break;
    }
  }
  if (first && second)
    cout << "YES"
         << "\n";
  else
    cout << "NO"
         << "\n";
}
int32_t main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  solve();
  return 0;
}
