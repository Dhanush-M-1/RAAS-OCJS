#include <bits/stdc++.h>
using namespace std;
const int MAX_N = 1e5 + 5;
const long long MOD = 1e9 + 7;
const long long INF = 1e9 + 7;
vector<long long> get_factor(long long q) {
  vector<long long> factor;
  for (long long i = 2; i <= (sqrt(q)); i++) {
    if (q % i == 0) {
      factor.push_back(i);
      if (q / i != i) factor.push_back(q / i);
    }
  }
  sort(factor.begin(), factor.end());
  return factor;
}
void solve() {
  long long q;
  cin >> q;
  vector<long long> factor = get_factor(q);
  if (factor.size() == 0)
    cout << 1 << "\n" << 0 << "\n";
  else if (factor.size() == 1)
    cout << 2 << "\n";
  else if (get_factor(factor[1]).size() != 0)
    cout << 1 << "\n" << factor[1] << "\n";
  else {
    if (factor[1] * factor[0] == q)
      cout << 2 << "\n";
    else
      cout << 1 << "\n" << factor[1] * factor[0] << "\n";
  }
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(nullptr);
  cout.tie(nullptr);
  solve();
}
