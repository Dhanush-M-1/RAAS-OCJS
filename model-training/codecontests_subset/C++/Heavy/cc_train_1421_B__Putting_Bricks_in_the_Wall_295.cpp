#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(false);
  long long t;
  cin >> t;
  long long n;
  long long ans = 0;
  long long f1 = 0, f2 = 0;
  while (t--) {
    f1 = f2 = 0;
    ans = 0;
    cin >> n;
    string s = "";
    string t = "";
    for (long long i = 0; i < n; i++) {
      cin >> t;
      s += t;
    }
    if (s[1] == '0' && s[n] == '1') {
      if (s[n * n - n - 1] == '1' && s[n * n - 2] == '1') {
        ans++;
        f1 = 2;
      }
      if (s[n * n - n - 1] == '0' && s[n * n - 2] == '0') {
        ans++;
        f1 = 1;
      }
      if (s[n * n - n - 1] == '0' && s[n * n - 2] == '1') {
        ans += 2;
        f1 = 1;
        f2 = 2;
      }
      if (s[n * n - n - 1] == '1' && s[n * n - 2] == '0') {
        ans += 2;
        f1 = 1;
        f2 = 1;
      }
    } else if (s[1] == '1' && s[n] == '0') {
      if (s[n * n - n - 1] == '0' && s[n * n - 2] == '0') {
        ans++;
        f1 = 2;
      }
      if (s[n * n - n - 1] == '1' && s[n * n - 2] == '1') {
        ans++;
        f1 = 1;
      }
      if (s[n * n - n - 1] == '1' && s[n * n - 2] == '0') {
        ans += 2;
        f1 = 1;
        f2 = 2;
      }
      if (s[n * n - n - 1] == '0' && s[n * n - 2] == '1') {
        ans += 2;
        f1 = 1;
        f2 = 1;
      }
    } else if (s[1] == '0' && s[n] == '0') {
      if (s[n * n - n - 1] == '0' && s[n * n - 2] == '0') {
        ans += 2;
        f1 = 3;
      }
      if (s[n * n - n - 1] == '0' && s[n * n - 2] == '1') {
        ans++;
        f2 = 1;
      }
      if (s[n * n - n - 1] == '1' && s[n * n - 2] == '0') {
        ans++;
        f2 = 2;
      }
    } else if (s[1] == '1' && s[n] == '1') {
      if (s[n * n - n - 1] == '1' && s[n * n - 2] == '1') {
        ans += 2;
        f1 = 3;
      }
      if (s[n * n - n - 1] == '0' && s[n * n - 2] == '1') {
        ans++;
        f2 = 2;
      }
      if (s[n * n - n - 1] == '1' && s[n * n - 2] == '0') {
        ans++;
        f2 = 1;
      }
    }
    cout << ans << endl;
    if (f1 == 1) {
      cout << 1 << " " << 2 << endl;
    }
    if (f1 == 2) {
      cout << 2 << " " << 1 << endl;
    }
    if (f1 == 3) {
      cout << 1 << " " << 2 << endl;
      cout << 2 << " " << 1 << endl;
    }
    if (f2 == 1) {
      cout << n - 1 << " " << n << endl;
    }
    if (f2 == 2) {
      cout << n << " " << n - 1 << endl;
    }
  }
  return 0;
}
