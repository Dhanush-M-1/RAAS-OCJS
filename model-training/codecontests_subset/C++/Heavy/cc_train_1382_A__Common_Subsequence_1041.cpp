#include <bits/stdc++.h>
using namespace std;
long long int power(long long int x, long long int n, long long int p) {
  long long int result = 1;
  while (n > 0) {
    if (n % 2 == 1) result = (result % p * x % p) % p;
    x = (x % p * x % p) % p;
    n = n / 2;
  }
  return result % p;
}
void solve() {
  long long int n, m;
  cin >> n >> m;
  vector<long long int> cnt(1005);
  for (long long int i = 0; i <= n - 1; i++) {
    long long int a1;
    cin >> a1;
    cnt[a1] = 1;
  }
  for (long long int i = 0; i <= m - 1; i++) {
    long long int a2;
    cin >> a2;
    if (cnt[a2] == 1) cnt[a2]++;
  }
  for (long long int i = 1; i <= 1000; i++) {
    if (cnt[i] >= 2) {
      cout << "YES" << endl;
      cout << "1 " << i << endl;
      return;
    }
  }
  cout << "NO" << endl;
  return;
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  long long int t = 1;
  cin >> t;
  while (t--) {
    solve();
  }
}
