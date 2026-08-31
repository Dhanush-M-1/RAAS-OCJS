#include <bits/stdc++.h>
using namespace std;
long long modPower(long long num, long long r) {
  if (r == 0) return 1;
  if (r == 1) return num % 1000000007;
  long long ans = modPower(num, r / 2) % 1000000007;
  if (r % 2 == 0) {
    return (ans * ans) % 1000000007;
  }
  return (((ans * ans) % 1000000007) * num) % 1000000007;
}
long long nCr(long long n, long long r) {
  long long res = 1;
  if (r > n - r) {
    r = n - r;
  }
  for (long long i = 0; i < r; i++) {
    res *= (n - i);
    res /= (i + 1);
  }
  return res;
}
bool isPrime(long long n) {
  if (n <= 1) return false;
  if (n <= 3) return true;
  if (n % 2 == 0 || n % 3 == 0) return false;
  for (int i = 5; i * i <= n; i = i + 6)
    if (n % i == 0 || n % (i + 2) == 0) return false;
  return true;
}
void solve() {
  long long n, m, num;
  unordered_map<long long, long long> one;
  cin >> n >> m;
  int a[m];
  for (long long i = 0; i < n; i++) {
    cin >> num;
    one[num]++;
  }
  for (long long i = 0; i < m; i++) {
    cin >> a[i];
  }
  for (long long i = 0; i < m; i++) {
    if (one[a[i]] >= 1) {
      cout << "YES"
           << "\n";
      cout << 1 << " " << a[i] << "\n";
      return;
    }
  }
  cout << "NO"
       << "\n";
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  int tc;
  cin >> tc;
  while (tc--) {
    solve();
  }
  return 0;
}
