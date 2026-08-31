#include <bits/stdc++.h>
inline int two(int n) { return 1 << n; }
inline int test(int n, int b) { return (n >> b) & 1; }
inline void set_bit(int& n, int b) { n |= two(b); }
inline void unset_bit(int& n, int b) { n &= ~two(b); }
inline int last_bit(int n) { return n & (-n); }
inline int ones(int n) {
  int res = 0;
  while (n && ++res) n -= n & (-n);
  return res;
}
long long int gcd(long long int a, long long int b) {
  return (a ? gcd(b % a, a) : b);
}
long long int modPow(long long int a, long long int b, long long int MOD) {
  long long int x = 1, y = a;
  while (b > 0) {
    if (b % 2 == 1) {
      x = (x * y) % MOD;
    }
    b /= 2;
    y = (y * y) % MOD;
  }
  return x;
}
long long int modInverse(long long int a, long long int p) {
  return modPow(a, p - 2, p);
}
using namespace std;
const int N = 1e6 + 6;
long long int arr[3 * N];
long long int rot_b4_zero[3 * N];
pair<long long int, long long int> ans;
long long int poscnt;
long long int curr;
int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  long long int n, i, j, k, dev, idx;
  cin >> n;
  for (int i = (1); i <= (n); i++) {
    cin >> arr[i];
    ans.first += abs(arr[i] - i);
    if (arr[i] > i) {
      rot_b4_zero[arr[i] - i]++;
      poscnt++;
    }
  }
  curr = ans.first;
  for (int k = (1); k <= (n - 1); k++) {
    curr -= abs(arr[n + 1 - k] - n);
    curr += abs(arr[n + 1 - k] - 1);
    curr -= poscnt;
    curr += n - 1 - poscnt;
    poscnt -= rot_b4_zero[k];
    if (curr < ans.first) ans = {curr, k};
    if (arr[n + 1 - k] > 1) {
      poscnt++;
      rot_b4_zero[k + arr[n + 1 - k] - 1]++;
    }
  }
  cout << ans.first << " " << ans.second << "\n";
  return 0;
}
