#include <bits/stdc++.h>
using namespace std;
#pragma GCC optimize("Ofast")
#pragma GCC optimize("unroll-loops")
#pragma GCC optimize("-ffloat-store")
#pragma GCC optimize("-fno-defer-pop")
long long int power(long long int a, long long int b, long long int m) {
  if (b == 0) return 1;
  if (b == 1) return a % m;
  long long int t = power(a, b / 2, m) % m;
  t = (t * t) % m;
  if (b & 1) t = ((t % m) * (a % m)) % m;
  return t;
}
long long int modInverse(long long int a, long long int m) {
  return power(a, m - 2, m);
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  long long int i, j, k, l, n;
  cin >> n >> k;
  long long int a, b, c;
  vector<long long int> v1, v2, v3;
  for (i = 1; i <= n; i++) {
    cin >> a >> b >> c;
    if (b * c == 1)
      v1.push_back(a);
    else if (b == 1)
      v2.push_back(a);
    else if (c == 1)
      v3.push_back(a);
  }
  sort(v1.begin(), v1.end());
  sort(v2.begin(), v2.end());
  sort(v3.begin(), v3.end());
  a = 0;
  b = 0;
  c = 0;
  long long int ans = 0, c1 = 0, c2 = 0;
  while (c1 < k && c2 < k) {
    long long int x = 1e18, y = 1e18;
    if (a < v1.size()) {
      x = v1[a];
    }
    if (b < v2.size() && c < v3.size()) {
      y = v2[b] + v3[c];
    }
    if (x == 1e18 && y == 1e18) {
      cout << "-1"
           << "\n";
      return 0;
    }
    if (x <= y) {
      ans += x;
      a++;
      c1++;
      c2++;
    } else {
      ans += y;
      b++;
      c++;
      c1++;
      c2++;
    }
  }
  if (a < v1.size()) {
    if (c1 < k) {
      while (a < v1.size()) {
        v2.push_back(v1[a]);
        a++;
      }
      sort(v2.begin() + b, v2.end());
    } else {
      while (a < v1.size()) {
        v3.push_back(v1[a]);
        a++;
      }
      sort(v3.begin() + b, v3.end());
    }
  }
  while (c1 < k && b < v2.size()) {
    ans += v2[b];
    b++;
    c1++;
  }
  while (c2 < k && c < v3.size()) {
    ans += v3[c];
    c++;
    c2++;
  }
  if (c1 < k || c2 < k) {
    cout << "-1"
         << "\n";
  } else
    cout << ans << "\n";
  return 0;
}
