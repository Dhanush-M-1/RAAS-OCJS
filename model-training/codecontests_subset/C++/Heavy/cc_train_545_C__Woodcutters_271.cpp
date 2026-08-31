#include <bits/stdc++.h>
using namespace std;
long long power(long long b, long long e) {
  if (e == 0) return 1;
  if (e & 1) return b * power(b * b, e / 2);
  return power(b * b, e / 2);
}
long long power(long long b, long long e, long long m) {
  if (e == 0) return 1;
  if (e & 1) return b * power(b * b % m, e / 2, m) % m;
  return power(b * b % m, e / 2, m);
}
bool sortinrev(const pair<int, int> &a, const pair<int, int> &b) {
  return (a.first > b.first);
}
long long modinv(long long a, long long m) { return power(a, m - 2, m); }
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(NULL);
  cout.tie(NULL);
  long long int t = 1;
  for (long long int g = 0; g < t; g++) {
    long long int n, x, y, ans = 2;
    cin >> n;
    vector<pair<long long int, long long int>> v;
    for (long long int i = 0; i < n; i++) {
      cin >> x >> y;
      v.push_back(make_pair(x, y));
    }
    if (n == 1) {
      cout << 1;
      return 0;
    }
    for (long long int i = 1; i < (int)v.size() - 1; i++) {
      if (v[i].first - v[i].second > v[i - 1].first)
        ans++;
      else if (v[i].first + v[i].second < v[i + 1].first) {
        ans++;
        v[i].first = v[i].first + v[i].second;
      }
    }
    cout << ans;
  }
  return 0;
}
