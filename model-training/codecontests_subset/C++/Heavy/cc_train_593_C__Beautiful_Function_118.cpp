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
int n;
vector<int> X, Y, R;
int main() {
  cin >> n;
  X.resize(n);
  Y.resize(n);
  R.resize(n);
  for (int i = 0; i < (int)n; i++) {
    cin >> X[i] >> Y[i] >> R[i];
  }
  for (int i = 0; i < (int)n; i++) {
    if (i == 0) {
      for (int j = 1; j < (int)n; j++) cout << "(";
    }
    if (i > 0) cout << "+";
    cout << "(";
    cout << X[i] / 2;
    cout << "*((1-abs((t-";
    cout << i;
    cout << ")))+abs((abs((t-";
    cout << i;
    cout << "))-1))))";
    if (i > 0) cout << ")";
  }
  cout << endl;
  for (int i = 0; i < (int)n; i++) {
    if (i == 0) {
      for (int j = 1; j < (int)n; j++) cout << "(";
    }
    if (i > 0) cout << "+";
    cout << "(";
    cout << Y[i] / 2;
    cout << "*((1-abs((t-";
    cout << i;
    cout << ")))+abs((abs((t-";
    cout << i;
    cout << "))-1))))";
    if (i > 0) cout << ")";
  }
  cout << endl;
  return 0;
}
