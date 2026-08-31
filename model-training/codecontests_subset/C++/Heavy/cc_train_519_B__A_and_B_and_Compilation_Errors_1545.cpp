#include <bits/stdc++.h>
using namespace std;
unsigned long long bpow(unsigned long long a, int n) {
  return n ? n & 1 ? bpow(a, n - 1) * a : bpow(a * a, n >> 1) : 1;
}
unsigned long long prod_range_tree(int l, int r) {
  if (l == r) return l;
  if (r - l == 1) return (unsigned long long)r * l;
  int m = (l + r) / 2;
  return prod_range_tree(l, m) * prod_range_tree(m + 1, r);
}
unsigned long long fact(int n) {
  if (n < 0) return 0;
  if (n == 0) return 1;
  if (n == 1 || n == 2) return n;
  return prod_range_tree(2, n);
}
bool is_upper(char c) { return (c >= 65 && c <= 90); }
bool is_lower(char c) { return (c >= 97 && c <= 122); }
int get_digit(long long num, int len, int index) {
  return num / bpow(10, len - index - 1) % 10;
}
long long digit_sum(long long num) {
  long long dig_sum = 0;
  while (num > 0) {
    dig_sum += num % 10;
    num /= 10;
  }
  return dig_sum;
}
const int INF = 1000000000;
long long n, m, k, p, q, sum = 0, cnt = 0;
long long mx = INT64_MIN;
long long mn = INT64_MAX;
bool flag = 0;
vector<long long> v;
string s = "", s1, s2;
void solve() {
  cin >> n;
  long long temp;
  m = 0;
  k = 0;
  p = 0;
  for (long long i = 0; i < n; ++i) {
    cin >> temp;
    m += temp;
  }
  for (long long i = 0; i < n - 1; ++i) {
    cin >> temp;
    k += temp;
  }
  cout << m - k << endl;
  for (long long i = 0; i < n - 2; ++i) {
    cin >> temp;
    p += temp;
  }
  cout << k - p;
}
int main() {
  solve();
  return 0;
}
