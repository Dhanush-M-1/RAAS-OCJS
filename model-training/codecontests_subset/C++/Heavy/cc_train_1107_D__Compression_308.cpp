#include <bits/stdc++.h>
using namespace std;
int const N = 1e6 + 100;
long long int const LINF = numeric_limits<long long int>::max();
int const INF = numeric_limits<int>::max();
int const BN = 31;
long long int gcd(long long int a, long long int b) {
  return b ? gcd(b, a % b) : a;
}
long long int pow_mod(long long int a, long long int e, long long int m) {
  long long int res = 1;
  while (e) {
    if (e & 1) res = res * a % m;
    a = a * a % m;
    e >>= 1;
  }
  return res;
}
long long int inv_mod(long long int b, long long int m) {
  b %= m;
  long long int x = 0, y = 1, r, q, a = m;
  while (b) {
    q = a / b;
    r = a % b;
    a = b;
    b = r;
    r = x;
    x = y;
    y = r - q * y;
  }
  x += m;
  return x % m;
}
int row_gcd(string str[], int n) {
  int ret = 0;
  for (int i = 0; i < n; i++) {
    char ch = 'a';
    int cnt = 0;
    for (int j = 0; j < n; j++) {
      if (ch != str[i][j]) {
        ret = gcd(ret, cnt);
        cnt = 1;
      } else
        cnt++;
      ch = str[i][j];
    }
    ret = gcd(ret, cnt);
  }
  return ret;
}
int col_gcd(string str[], int n) {
  int ret = 0;
  for (int j = 0; j < n; j++) {
    char ch = 'a';
    int cnt = 0;
    for (int i = 0; i < n; i++) {
      if (ch != str[i][j]) {
        ret = gcd(ret, cnt);
        cnt = 1;
      } else
        cnt++;
      ch = str[i][j];
    }
    ret = gcd(ret, cnt);
  }
  return ret;
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  int n, m;
  cin >> n;
  string mat[n];
  m = n / 4;
  for (int i = 0; i < n; i++) {
    string str;
    cin >> str;
    mat[i] = "";
    for (int j = 0; j < m; j++) {
      if (str[j] <= '9') {
        mat[i] += bitset<4>(str[j] - '0').to_string();
      } else {
        mat[i] += bitset<4>(str[j] - 'A' + 10).to_string();
      }
    }
  }
  int g1 = row_gcd(mat, n);
  int g2 = col_gcd(mat, n);
  int ans = gcd(n, gcd(g1, g2));
  cout << ans << endl;
}
