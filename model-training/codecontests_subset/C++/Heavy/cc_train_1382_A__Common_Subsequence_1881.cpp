#include <bits/stdc++.h>
using namespace std;
bool compare(int a, int b) { return a < b; }
long long int modd(long long int n, long long int k) {
  return (k + (n % k)) % k;
}
long long int gcd(long long int a, long long int b) {
  if (a == 0) return b;
  return gcd(b % a, a);
}
long long int fastexp(long long int a, long long int b) {
  long long int res = 1;
  while (b > 0) {
    if ((b & 1) != 0) res = (res * a);
    a = (a * a);
    b >>= 1;
  }
  return res;
}
int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  long long int tc;
  cin >> tc;
  while (tc--) {
    long long int n, m;
    cin >> n >> m;
    long long int a[n], b[m];
    for (long long int i = 0; i < n; i++) cin >> a[i];
    for (long long int i = 0; i < m; i++) cin >> b[i];
    long long int freq[2000] = {0};
    for (long long int i = 0; i < n; i++) {
      freq[a[i]] = 1;
    }
    long long int flag = -1;
    for (long long int i = 0; i < m; i++) {
      if (freq[b[i]] == 1) flag = b[i];
    }
    if (flag == -1)
      cout << "NO\n";
    else
      cout << "YES\n"
           << "1 " << flag << "\n";
  }
  return 0;
}
