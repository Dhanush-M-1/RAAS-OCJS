#include <bits/stdc++.h>
using namespace std;
long long binpow(long long a, long long b) {
  long long res = 1;
  while (b != 0) {
    if (1 & b) res *= a;
    b >>= 1;
    a *= a;
  }
  return res;
}
void solve() {
  long long n, m;
  cin >> n;
  long long a, b, c, d, temp;
  string s;
  for (long long i = 1; i < n + 1; i++) {
    cin >> s;
    if (i == 1) {
      a = s[1];
    }
    if (i == 2) {
      b = s[0];
    }
    if (i == n - 1) {
      c = s[n - 1];
    }
    if (i == n) {
      d = s[n - 2];
    }
  }
  if (a == b && c == d && a != c) {
    cout << "0\n";
  } else if (a == b && c == d && a == b) {
    cout << "2\n1 2\n";
    cout << "2 1\n";
  } else if (a == b && c != d) {
    if (c == a) {
      cout << "1\n" << n - 1 << " " << n << "\n";
    }
    if (d == a) {
      cout << "1\n" << n << " " << n - 1 << "\n";
    }
  } else if (a != b && c == d) {
    if (c == a) {
      cout << "1\n1 2\n";
    }
    if (c == b) {
      cout << "1\n2 1\n";
    }
  } else {
    if (a == c) {
      cout << "2\n1 2\n" << n << " " << n - 1 << "\n";
    }
    if (a == d) {
      cout << "2\n1 2\n" << n - 1 << " " << n << "\n";
    }
  }
}
int32_t main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  long long tt;
  cin >> tt;
  while (tt--) {
    solve();
  }
  return 0;
}
