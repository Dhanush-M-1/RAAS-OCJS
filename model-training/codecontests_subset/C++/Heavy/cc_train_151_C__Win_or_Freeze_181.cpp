#include <bits/stdc++.h>
using namespace std;
using lli = long long int;
using pii = pair<int, int>;
using vi = vector<int>;
using vb = vector<bool>;
using vvi = vector<vector<int>>;
using vlli = vector<long long int>;
using vpii = vector<pair<int, int>>;
lli num, n, ans;
vi fac;
void solve() {
  n = num;
  if (n != 2)
    while (n % 2 == 0) {
      fac.push_back(2);
      n /= 2;
    }
  for (int i = 3; i <= sqrt(n); i += 2)
    while (n % i == 0) {
      fac.push_back(i);
      n /= i;
    }
  if (n != num && n != 1) fac.push_back(n);
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  cin >> num;
  solve();
  if (fac.size() >= 3) {
    ans = 1;
    for (int i = 0; i < 2; i++) ans *= fac[i];
    cout << 1 << '\n' << ans;
  } else if (fac.empty())
    cout << 1 << '\n' << 0;
  else
    cout << 2;
}
