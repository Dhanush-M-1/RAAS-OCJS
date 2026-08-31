#include <bits/stdc++.h>
using namespace std;
long long gcd(long long a, long long b) {
  if (a == 0) return b;
  return gcd(b % a, a);
}
long long lcm(long long a, long long b) { return (a * b) / gcd(a, b); }
bool isKthBitSet(long long n, long long k) {
  if (n & (1 << (k - 1)))
    return true;
  else
    return false;
}
int main() {
  ios_base::sync_with_stdio(false);
  ;
  long long t = 1, n, sum, k, r, temp, dif, maxi, mini, ans, c, num, x, m, l, a,
            b, i;
  vector<pair<long long, long long>> pairvec;
  bool flag = false;
  cin >> t;
  long long zeros, ones;
  while (t--) {
    pairvec.clear();
    cin >> n;
    string arr[n];
    for (long long i = 0; i < n; ++i) {
      cin >> arr[i];
    }
    if (arr[0][1] + arr[1][0] < arr[n - 1][n - 2] + arr[n - 2][n - 1]) {
      if (arr[0][1] == '1') pairvec.push_back(make_pair(1, 2));
      if (arr[1][0] == '1') pairvec.push_back(make_pair(2, 1));
      if (arr[n - 1][n - 2] == '0') pairvec.push_back(make_pair(n, n - 1));
      if (arr[n - 2][n - 1] == '0') pairvec.push_back(make_pair(n - 1, n));
    } else {
      if (arr[0][1] == '0') pairvec.push_back(make_pair(1, 2));
      if (arr[1][0] == '0') pairvec.push_back(make_pair(2, 1));
      if (arr[n - 1][n - 2] == '1') pairvec.push_back(make_pair(n, n - 1));
      if (arr[n - 2][n - 1] == '1') pairvec.push_back(make_pair(n - 1, n));
    }
    cout << pairvec.size() << endl;
    for (int i = 0; i < pairvec.size(); i++)
      cout << pairvec[i].first << " " << pairvec[i].second << endl;
  }
}
