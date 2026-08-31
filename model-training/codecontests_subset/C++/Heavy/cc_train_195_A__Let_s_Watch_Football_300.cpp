#include <bits/stdc++.h>
using namespace std;
const long long maxn = 1e3 + 5;
const long long modulo = 1000000007;
const double pi = 3.14159;
template <class T>
ostream &operator<<(ostream &out, vector<T> &A) {
  for (auto x : A) out << x << " ";
  return out;
}
template <class T>
ostream &operator<<(ostream &out, set<T> &A) {
  for (auto x : A) out << x << " ";
  return out;
}
template <class T>
ostream &operator<<(ostream &out, unordered_set<T> &A) {
  for (auto x : A) out << x << " ";
  return out;
}
long long mceil(long long a, long long b) {
  if (a % b == 0)
    return a / b;
  else
    return a / b + 1;
}
void solve() {
  long long a, b, c;
  cin >> a >> b >> c;
  long long x = a * c;
  long long y = mceil(x, b);
  for (long long i = 0; i <= y; i++) {
    long long s = i * b;
    long long v = s / a;
    long long tt = c - v;
    if (x - (s + v * b) <= b * tt) {
      cout << i;
      return;
    }
  }
}
int32_t main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  solve();
}
