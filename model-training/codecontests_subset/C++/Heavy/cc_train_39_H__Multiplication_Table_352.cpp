#include <bits/stdc++.h>
using namespace std;
const int mx = 1e5 + 7;
long long gcd(long long a, long long b) {
  if (b == 0) return a;
  return gcd(b, a % b);
}
long long power(long long a, long long b) {
  long long ans = 1;
  while (b) {
    if (b & 1) {
      ans = ans * a;
      b--;
    }
    b /= 2;
    a = a * a;
  }
  return ans;
}
string ans(int n, int k, string second = "") {
  vector<int> arr;
  while (n) {
    arr.push_back(n % k);
    n /= k;
  }
  reverse((arr).begin(), (arr).end());
  for (auto x : arr) {
    second += char(x + '0');
  }
  return second;
}
void solve() {
  int k;
  cin >> k;
  for (int i = 1; i < k; i++) {
    for (int j = 1; j < k; j++) {
      cout << ans(i * j, k) << " ";
    }
    cout << endl;
  }
}
int main() {
  long long t = 1;
  long long i = 0;
  while (i++ < t) {
    solve();
  }
  return 0;
}
