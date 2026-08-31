#include <bits/stdc++.h>
using namespace std;
template <typename T>
T gcd(T a, T b) {
  if (a == 0) return b;
  return gcd(b % a, a);
}
template <typename T>
void read(T &x) {
  register T c = getchar();
  x = 0;
  int t = 0;
  if (c == '-') t = 1, c = getchar();
  for (; (c < 48 || c > 57); c = getchar())
    ;
  for (; c > 47 && c < 58; c = getchar()) {
    x = (x << 1) + (x << 3) + c - 48;
  }
  if (t) x = -x;
}
template <typename T>
T pow(T x, T y) {
  T ans = 1;
  while (y > 0) {
    if (y % 2 == 1) ans = (ans * x) % 1000000007;
    y /= 2;
    x = (x * x) % 1000000007;
  }
  return ans;
}
template <typename T>
long long int roundp(T x) {
  long long int ans = x;
  if (x - floor(x) <= 0.001)
    ans = floor(x);
  else if (ceil(x) - x <= 0.001)
    ans = ceil(x);
  return ans;
}
int main() {
  int n, x;
  cin >> n;
  map<int, int> m1, m2;
  for (long long(i) = (0); i < (n); i++) {
    cin >> x;
    ++m1[x];
  }
  for (long long(i) = (0); i < (n - 1); i++) {
    cin >> x;
    --m1[x];
    ++m2[x];
  }
  for (long long(i) = (0); i < (n - 2); i++) {
    cin >> x;
    --m2[x];
  }
  for (auto x : m1) {
    if (x.second > 0) {
      cout << x.first << '\n';
      break;
    }
  }
  for (auto x : m2) {
    if (x.second > 0) {
      cout << x.first << '\n';
      break;
    }
  }
}
