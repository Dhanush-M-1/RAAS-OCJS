#include <bits/stdc++.h>
using namespace std;
void IO() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
}
template <typename... T>
void read(T&... args) {
  ((cin >> args), ...);
}
template <typename... T>
void write(T&&... args) {
  ((cout << args << " "), ...);
}
int mpow(int, int);
long long int n;
void solve() {
  read(n);
  int a[n];
  for (int i = 0; i < n; i += 1) read(a[i]);
  int a1 = a[0];
  int b = a[1];
  int c = a[n - 1];
  if ((a1 + b) <= c) {
    write(1, 2, n);
  } else {
    cout << -1;
  }
  cout << "\n";
}
int main() {
  IO();
  int t = 1;
  cin >> t;
  while (t--) {
    solve();
  }
  return 0;
}
int mpow(int base, int exp) {
  base %= 1000000007;
  int result = 1;
  while (exp > 0) {
    if (exp & 1) result = ((long long int)result * base) % 1000000007;
    base = ((long long int)base * base) % 1000000007;
    exp >>= 1;
  }
  return result;
}
