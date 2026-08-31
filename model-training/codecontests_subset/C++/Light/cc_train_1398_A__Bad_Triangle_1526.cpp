#include <bits/stdc++.h>
using namespace std;
using ll = long long int;
using dl = double;
const int N = 2e5 + 10;
ll aarray[200000 + 10];
ll magic[101][101];
vector<ll> primes;
bool prime[1000001];
int main() {
  ios_base::sync_with_stdio(false);
  string str;
  ll i, j, n, m, k, t;
  cin >> t;
  while (t--) {
    cin >> n;
    for (i = 1; i <= n; i++) {
      cin >> aarray[i];
    }
    if (aarray[1] + aarray[2] <= aarray[n]) {
      cout << 1 << " " << 2 << " " << n << endl;
    } else
      cout << -1 << endl;
  }
  return 0;
}
