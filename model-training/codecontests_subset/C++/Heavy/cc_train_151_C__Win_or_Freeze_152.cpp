#include <bits/stdc++.h>
using namespace std;
const int N = 2e5 + 500;
const long long mod = 1e9 + 7;
const long long INF = 1LL << 57;
const int M = 1e6 + 500;
long long int prime(long long int x) {
  long long int i = 2;
  while (i * i <= x) {
    if (x % i == 0) return i;
    i++;
  }
  return 0;
}
void solve() {
  long long int n;
  cin >> n;
  long long int a = prime(n);
  if (a == 0) {
    cout << 1 << endl;
    cout << 0;
    return;
  }
  long long int b = prime(n / a);
  if (b == 0) {
    cout << 2;
  } else {
    cout << 1 << endl;
    cout << a * b;
  }
  return;
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  long long int t;
  t = 1;
  while (t--) {
    solve();
  }
  return 0;
}
