#include <bits/stdc++.h>
using namespace std;
int dx[] = {1, -1, 0, 0, 1, 1, -1, -1};
int dy[] = {0, 0, 1, -1, 1, -1, 1, -1};
void dance() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
}
void file() {
  freopen(".in", "r", stdin);
  freopen(".out", "w", stdout);
}
long long gcd(long long a, long long b) { return !b ? a : gcd(b, a % b); }
long long lcm(long long a, long long b) { return a / gcd(a, b) * b; }
template <typename t>
void printV(vector<t> v) {
  for (int i = 0; i < v.size(); i++) {
    cout << v[i] << ' ';
  }
  cout << endl;
}
bool isPrime(int n) {
  if (n == 2) return true;
  if (n < 2 || n % 2 == 0) return false;
  for (int i = 3; i * i <= n; i += 2)
    if (n % i == 0) return false;
  return true;
}
int main() {
  dance();
  int n;
  cin >> n;
  string s;
  cin >> s;
  int e = 0;
  for (int i = 0; i < n; i++) {
    if (s[i] == '8') e++;
  }
  cout << min(e, n / 11) << endl;
  return 0;
}
