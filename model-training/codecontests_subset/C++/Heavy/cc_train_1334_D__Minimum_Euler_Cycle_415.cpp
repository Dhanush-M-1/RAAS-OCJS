#include <bits/stdc++.h>
using namespace std;
const long long N = 500005;
const long long M = 1000000007;
int main() {
  long long t;
  cin >> t;
  while (t--) {
    long long n, l, r;
    cin >> n >> l >> r;
    vector<long long> v;
    v.push_back(1);
    for (long long i = 1; i < n; i++) {
      v.push_back(2 * i);
    }
    reverse(v.begin(), v.end());
    vector<long long> v1;
    v1.push_back(v[0]);
    long long sum = v[0];
    for (long long i = 1; i < n; i++) {
      sum += v[i];
      v1.push_back(sum);
    }
    vector<long long>::iterator it = lower_bound(v1.begin(), v1.end(), l);
    vector<long long>::iterator it1 = lower_bound(v1.begin(), v1.end(), r);
    long long z = it - v1.begin();
    long long z1 = it1 - v1.begin();
    long long num = v1[z];
    long long num1 = v1[z1];
    if (z == n - 1) {
      cout << 1;
    } else {
      long long chk = 0;
      long long a, b, c, d;
      long long w = num - l;
      b = n - w / 2;
      a = z + 1;
      if (z1 == n - 1) {
        chk = 1;
      } else {
        c = z1 + 1;
        long long w = num1 - r;
        d = n - w / 2;
      }
      if (chk == 1) {
        if (l % 2 == 0) {
          cout << b << " ";
          long long nu = b + 1;
          while (nu <= n) {
            cout << a << " " << nu << " ";
            nu++;
          }
        } else {
          long long nu = b;
          while (nu <= n) {
            cout << a << " " << nu << " ";
            nu++;
          }
        }
        for (long long j = a + 1; j < n; j++) {
          long long nu = j + 1;
          while (nu <= n) {
            cout << j << " " << nu << " ";
            nu++;
          }
        }
        cout << 1 << " ";
      } else if (a == c) {
        if (l % 2 == 0 && r % 2 == 0) {
          cout << b << " ";
          long long nu = b + 1;
          while (nu <= d) {
            cout << a << " " << nu << " ";
            nu++;
          }
        } else if (l % 2 == 0 && r % 2 != 0) {
          cout << b << " ";
          long long nu = b + 1;
          while (nu < d) {
            cout << a << " " << nu << " ";
            nu++;
          }
          cout << a << " ";
        } else if (l % 2 != 0 && r % 2 == 0) {
          long long nu = b;
          while (nu <= d) {
            cout << a << " " << nu << " ";
            nu++;
          }
        } else {
          long long nu = b;
          while (nu < d) {
            cout << a << " " << nu << " ";
            nu++;
          }
          cout << a << " ";
        }
      } else {
        if (l % 2 == 0) {
          cout << b << " ";
          long long nu = b + 1;
          while (nu <= n) {
            cout << a << " " << nu << " ";
            nu++;
          }
        } else {
          long long nu = b;
          while (nu <= n) {
            cout << a << " " << nu << " ";
            nu++;
          }
        }
        if (a + 1 < c) {
          for (long long j = a + 1; j < c; j++) {
            long long nu = j + 1;
            while (nu <= n) {
              cout << j << " " << nu << " ";
              nu++;
            }
          }
        }
        if (r % 2 == 0) {
          long long nu = c + 1;
          while (nu <= d) {
            cout << c << " " << nu << " ";
            nu++;
          }
        } else {
          long long nu = c + 1;
          while (nu < d) {
            cout << c << " " << nu << " ";
            nu++;
          }
          cout << c << " ";
        }
      }
    }
    cout << endl;
  }
}
