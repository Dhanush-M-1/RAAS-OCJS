#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  long long int t;
  cin >> t;
  while (t--) {
    long long int n, p, i, c, d, e, f, q = 0, r = 0, l = 0, m = 0;
    cin >> n;
    p = n * n;
    for (i = 0; i < p; i++) {
      char s;
      cin >> s;
      if (i == 1) {
        c = s - '0';
      } else if (i == n) {
        d = s - '0';
      } else if (i == p - n - 1) {
        e = s - '0';
      } else if (i == p - 2) {
        f = s - '0';
      }
    }
    if (c == d) {
      if (e == c || e == d) {
        q = 1;
        r++;
        l = 1;
      }
      if (f == c || f == d) {
        q = 1;
        r++;
        m = 1;
      }
      if (l == 1 && r == 1) {
        cout << r << endl;
        cout << (p - n) / n << " " << n << endl;
      } else if (m == 1 && r == 1) {
        cout << r << endl;
        cout << n << " " << n - 1 << endl;
      } else if (r == 2) {
        cout << r << endl;
        cout << (p - n) / n << " " << n << endl;
        cout << n << " " << n - 1 << endl;
      }
    } else if (e == f) {
      if (c == e || c == f) {
        q = 1;
        l = 1;
        r++;
      }
      if (d == e || d == f) {
        q = 1;
        r++;
        m = 1;
      }
      if (l == 1 && r == 1) {
        cout << r << endl;
        cout << 1 << " " << 2 << endl;
      } else if (m == 1 && r == 1) {
        cout << r << endl;
        cout << 2 << " " << 1 << endl;
      } else if (r == 2) {
        cout << r << endl;
        cout << 1 << " " << 2 << endl;
        cout << 2 << " " << 1 << endl;
      }
    } else if (c != d && e != f) {
      if (c == 1) {
        q = 1;
        r++;
        l = 1;
      } else if (d == 1) {
        q = 1;
        r++;
        l = 1;
      }
      if (e == 0) {
        q = 1;
        r++;
        m = 1;
      } else if (f == 0) {
        q = 1;
        r++;
        m = 1;
      }
      cout << r << endl;
      if (l == 1) {
        if (c == 1) {
          cout << 1 << " " << 2 << endl;
        } else if (d == 1) {
          cout << 2 << " " << 1 << endl;
        }
      }
      if (m == 1) {
        if (e == 0) {
          cout << (p - n) / n << " " << n << endl;
        } else if (f == 0) {
          cout << n << " " << n - 1 << endl;
        }
      }
    }
    if (q == 0) {
      cout << 0 << endl;
    }
  }
  return 0;
}
