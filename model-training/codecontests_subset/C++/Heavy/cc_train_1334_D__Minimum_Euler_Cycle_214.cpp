#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  long long t;
  t = 1;
  cin >> t;
  for (int i1 = 0; i1 < t; ++i1) {
    long long n, l, r;
    cin >> n >> l >> r;
    vector<long long> v;
    long long c = (n - 1) * 2;
    long long s = c;
    vector<long long> v1;
    for (int i = 0; i < n - 1; ++i) {
      v.push_back(s);
      v1.push_back(c / 2);
      c -= 2;
      s += c;
    }
    long long x = lower_bound(v.begin(), v.end(), l) - v.begin();
    long long y = lower_bound(v.begin(), v.end(), r) - v.begin();
    if (x == v.size()) {
      cout << 1 << "\n";
      continue;
    }
    long long res1 = v[x] - l + 1;
    if (res1 % 2) {
      res1 /= 2;
      cout << n - res1 << " ";
      l++;
    } else
      res1 /= 2;
    if (x == y) {
      long long dif = r - l + 1;
      while (dif > 1) {
        res1--;
        cout << x + 1 << " " << n - res1 << " ";
        dif -= 2;
      }
      if (dif == 1) cout << x + 1 << "\n";
      continue;
    }
    for (int i = 0; i < res1; ++i) {
      cout << x + 1 << " " << n - res1 + 1 + i << " ";
    }
    x++;
    while (x < y) {
      for (int i = 0; i < v1[x]; ++i) {
        cout << x + 1 << " " << x + i + 2 << " ";
      }
      x++;
    }
    if (y == v.size()) {
      cout << 1 << "\n";
      continue;
    }
    long long res2 = r - v[y - 1];
    res1 = res2;
    res2 /= 2;
    for (int i = 0; i < res2; ++i) {
      cout << y + 1 << " " << y + 2 + i << " ";
    }
    if (res1 % 2) cout << y + 1;
    cout << "\n";
  }
  return 0;
}
