#include <bits/stdc++.h>
using namespace std;
const int MAXN = 1000002;
const int MOD2 = 998244353;
const int MOD = 1000000007;
const int INF = 1e8;
const long double EPS = 1e-7;
long long int mul(long long int x, long long int y) {
  return (x * 1ll * y) % MOD;
}
long long int fastpow(long long int x, long long int y) {
  long long int z = 1;
  while (y) {
    if (y & 1) z = mul(z, x);
    x = mul(x, x);
    y >>= 1;
  }
  return z;
}
long long int modinv(long long int n, long long int p) {
  return fastpow(n, p - 2);
}
struct Comp {
  bool operator()(const std::pair<int, int>& a, const std::pair<int, int>& b) {
    if (a.first != b.first) {
      return a.first > b.first;
    }
    return a.second > b.second;
  }
};
int main(int argc, char** argv) {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  ;
  cout << setprecision(10);
  int tt;
  cin >> tt;
  while (tt--) {
    long long int n;
    cin >> n;
    string s[n];
    for (int i = 0; i < (int)n; i++) cin >> s[i];
    long long int c = (s[n - 2][n - 1] - '0'), d = (s[n - 1][n - 2] - '0');
    long long int a = (s[0][1] - '0'), b = (s[1][0] - '0');
    if (a + b + c + d == 4 || a + b + c + d == 0) {
      cout << 2 << "\n";
      cout << 1 << " " << 2 << "\n";
      cout << 2 << " " << 1 << "\n";
      continue;
    } else if (a + b + c + d == 1) {
      cout << 1 << "\n";
      if (a == 1) {
        cout << 2 << " " << 1 << "\n";
      } else if (b == 1) {
        cout << 1 << " " << 2 << "\n";
      } else if (c == 1)
        cout << n << " " << n - 1 << "\n";
      else
        cout << n - 1 << " " << n << "\n";
      continue;
    } else if (a + b + c + d == 3) {
      cout << 1 << "\n";
      if (a == 0) {
        cout << 2 << " " << 1 << "\n";
      } else if (b == 0) {
        cout << 1 << " " << 2 << "\n";
      } else if (c == 0)
        cout << n << " " << n - 1 << "\n";
      else
        cout << n - 1 << " " << n << "\n";
    } else {
      if (a == b) {
        cout << 0 << "\n";
      } else {
        if (a == c) {
          cout << 2 << "\n";
          cout << 1 << " " << 2 << "\n";
          cout << n << " " << n - 1 << "\n";
        } else {
          cout << 2 << "\n";
          cout << 1 << " " << 2 << "\n";
          cout << n - 1 << " " << n << "\n";
        }
      }
    }
  }
  return 0;
}
