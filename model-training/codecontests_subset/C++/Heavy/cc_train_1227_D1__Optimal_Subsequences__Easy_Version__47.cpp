#include <bits/stdc++.h>
using namespace std;
struct hash_pair {
  template <class T1, class T2>
  size_t operator()(const pair<T1, T2>& p) const {
    auto hash1 = hash<T1>{}(p.first);
    auto hash2 = hash<T2>{}(p.second);
    return hash1 ^ hash2;
  }
};
long long int gcd(long long int a, long long int b) {
  if (a == 0) {
    return b;
  }
  if (b == 0) {
    return a;
  }
  return gcd(b, a % b);
}
long long int power(long long int x, long long int n) {
  long long ans = 1;
  while (n > 0) {
    if (n & 1) ans = (ans * x) % 1000000007;
    x = (x * x) % 1000000007;
    n /= 2;
  }
  if (x == 0) ans = 0;
  return ans;
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  int t = 1;
  while (t--) {
    long long int n, i;
    cin >> n;
    vector<pair<long long int, long long int> > a;
    long long int pre[n];
    for (i = 0; i < n; i++) {
      cin >> pre[i];
      a.push_back(make_pair(pre[i], -1 * i));
    }
    sort(a.begin(), a.end());
    for (i = 1; i < n; i++) {
      a[i].first += (a[i - 1].first);
    }
    long long int m;
    cin >> m;
    for (i = 0; i < m; i++) {
      long long int k, r;
      cin >> k >> r;
      long long int maxs = INT_MIN, l;
      for (int j = n - 1; j >= k - 1; j--) {
        if (j != k - 1) {
          if (a[j].first - a[j - k].first >= maxs) {
            maxs = a[j].first - a[j - k].first;
            l = j - k + 1;
          }
        } else {
          if (a[j].first >= maxs) {
            maxs = a[j].first;
            l = 0;
          }
        }
      }
      vector<pair<long long int, long long int> > tmp;
      if (l == 0) {
        tmp.push_back(make_pair(-1 * a[0].second, a[0].first));
      }
      for (int z = l; z < l + k; z++) {
        long long int x = a[z].first, y = -1 * a[z].second;
        if (z) {
          tmp.push_back(make_pair(y, x - a[z - 1].first));
        }
      }
      sort(tmp.begin(), tmp.end());
      cout << tmp[r - 1].second << endl;
    }
  }
}
