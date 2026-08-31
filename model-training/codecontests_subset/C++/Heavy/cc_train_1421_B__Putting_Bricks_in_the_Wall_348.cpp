#include <bits/stdc++.h>
using namespace std;
const long long int INF = 2e18;
const long long int N = 2e5 + 5;
bool isPrime(long long int n) {
  if (n <= 1) return false;
  if (n <= 3) return true;
  if (n % 2 == 0 || n % 3 == 0) return false;
  for (long long int i = 5; i * i <= n; i = i + 6) {
    if (n % i == 0 || n % (i + 2) == 0) return false;
  }
  return true;
}
long long int factorial(long long int n) {
  long long int ans = 1;
  for (long long int i = 1; i <= n; i++) ans = (ans * i) % 1000000007;
  return ans;
}
long long int exp(long long int x, long long int n) {
  long long int res = 1;
  while (n > 0) {
    if (n % 2 == 1) res = (res * x) % 1000000007;
    x = (x * x) % 1000000007;
    n = n / 2;
  }
  return res;
}
void null() {
  long long int n;
  cin >> n;
  char a[n][n];
  for (long long int i = 0; i < n; i++) {
    for (long long int j = 0; j < n; j++) {
      cin >> a[i][j];
    }
  }
  long long int ans = 0;
  if (a[0][1] == a[1][0]) {
    if (a[n - 1][n - 2] == a[n - 2][n - 1]) {
      if (a[n - 1][n - 2] == a[0][1]) {
        cout << 2 << '\n';
        cout << 1 << " " << 2 << '\n';
        cout << 2 << " " << 1 << '\n';
        return;
      } else {
        cout << 0 << '\n';
        return;
      }
    }
    if (a[n - 1][n - 2] != a[n - 2][n - 1]) {
      if (a[n - 1][n - 2] == a[0][1]) {
        cout << 1 << '\n';
        cout << n << " " << n - 1 << '\n';
        return;
      } else if (a[n - 2][n - 1] == a[0][1]) {
        cout << 1 << '\n';
        cout << n - 1 << " " << n << '\n';
        return;
      }
    }
  } else {
    if (a[n - 1][n - 2] == a[n - 2][n - 1]) {
      if (a[0][1] == a[n - 1][n - 2]) {
        cout << 1 << '\n';
        cout << 1 << " " << 2 << '\n';
        return;
      } else {
        cout << 1 << '\n';
        cout << 2 << " " << 1 << '\n';
        return;
      }
    } else {
      cout << 2 << '\n';
      if (a[0][1] == a[n - 1][n - 2]) {
        cout << 1 << " " << 2 << '\n';
        cout << n - 1 << " " << n << '\n';
        return;
      } else if (a[0][1] == a[n - 2][n - 1]) {
        cout << 1 << " " << 2 << '\n';
        cout << n << " " << n - 1 << '\n';
        return;
      }
    }
  }
}
signed main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  long long int t = 1;
  clock_t start, end;
  start = clock();
  cin >> t;
  while (t--) {
    null();
  }
  end = clock();
  double time_taken = double(end - start) / double(CLOCKS_PER_SEC);
}
