#include <bits/stdc++.h>
using namespace std;
const long long mod = 1000000007;
long long powmod(long long a, long long b) {
  long long res = 1;
  a %= mod;
  for (; b; b >>= 1) {
    if (b & 1) res = res * a % mod;
    a = a * a % mod;
  }
  return res;
}
int dr[8] = {1, 1, 0, -1, -1, -1, 0, 1};
int dc[8] = {0, 1, 1, 1, 0, -1, -1, -1};
int dh[4] = {0, 1, 0, -1};
int dv[4] = {-1, 0, 1, 0};
int n;
void gen(vector<int> v) {
  int i;
  for (i = 0; i < n - 1; i++) cout << "(";
  for (i = 0; i < n; i++) {
    cout << "(";
    cout << v[i] / 2;
    cout << "*((1-abs((t-" << i << ")))+abs((abs((t-" << i << "))-1))))";
    if (i > 0) cout << ")";
    if (i < n - 1) cout << "+";
  }
  cout << endl;
}
int main() {
  cin >> n;
  int i, a, b, r;
  vector<int> X, Y;
  for (i = 0; i < n; i++) {
    cin >> a >> b >> r;
    X.push_back(a);
    Y.push_back(b);
  }
  gen(X);
  gen(Y);
  return 0;
}
