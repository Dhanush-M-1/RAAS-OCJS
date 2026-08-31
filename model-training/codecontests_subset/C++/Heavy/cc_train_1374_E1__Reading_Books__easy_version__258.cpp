#include <bits/stdc++.h>
using namespace std;
long long gcd(long long a, long long b) {
  if (b == 0) return a;
  return gcd(b, a % b);
}
long long lcm(long long a, long long b) { return (a * b) / gcd(a, b); }
void print(vector<long long> a) {
  for (int i = 0; i < a.size(); i++) {
    cout << a[i] << ' ';
  }
  cout << endl;
}
vector<long long> inp(int n) {
  vector<long long> a;
  long long x;
  for (int i = 0; i < n; i++) {
    cin >> x;
    a.push_back(x);
  }
  return a;
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  long long t, n, i, j, k, l, c1, cnt, flag, m1, m, m2, maxi, mini, x, y, z;
  vector<long long> a, b, c;
  string s, s1, s2;
  cin >> n >> k;
  for (i = 0; i < n; i++) {
    cin >> x >> y >> z;
    if (y + z == 2) {
      c.push_back(x);
    } else {
      if (y == 1) {
        a.push_back(x);
      }
      if (z == 1) {
        b.push_back(x);
      }
    }
  }
  sort(a.begin(), a.end());
  sort(b.begin(), b.end());
  sort(c.begin(), c.end());
  cnt = 0;
  if (c.size() + a.size() >= k && c.size() + b.size() >= k) {
    i = 0, j = 0, l = 0;
    while (i != k) {
      if (j < a.size() && j < b.size()) {
        if (l < c.size()) {
          if (a[j] + b[j] < c[l]) {
            cnt = cnt + a[j] + b[j];
            j++;
          } else {
            cnt = cnt + c[l];
            l++;
          }
        } else {
          cnt = cnt + a[j] + b[j];
          j++;
        }
      } else {
        cnt = cnt + c[l];
        l++;
      }
      i++;
    }
    cout << cnt << endl;
  } else {
    cout << -1 << endl;
  }
}
