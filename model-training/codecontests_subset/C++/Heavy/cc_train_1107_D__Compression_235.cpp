#include <bits/stdc++.h>
using namespace std;
long long gcd(long long a, long long b) { return b ? gcd(b, a % b) : a; }
long long lcm(long long a, long long b) { return a / gcd(a, b) * b; }
long long powmod(long long a, long long b, long long MOD) {
  long long ans = 1;
  while (b) {
    if (b % 2) ans = ans * a % MOD;
    a = a * a % MOD;
    b /= 2;
  }
  return ans;
}
inline void getInt(int* p);
const int maxn = 1000010;
const int inf = 0x3f3f3f3f;
bool a[5205][5205];
int n;
int b[250];
void change(int x, int y, char z) {
  int v = b[z];
  for (int i = 1; i <= 4; i++) {
    a[x][(y - 1) * 4 + i] = (v & (1 << (4 - i)));
  }
}
bool check(int x) {
  for (int i = 1; i <= n / x; i++) {
    for (int j = 1; j <= n / x; j++) {
      int flag = 0;
      bool t;
      for (int k = 1; k <= x; k++) {
        for (int z = 1; z <= x; z++) {
          if (flag == 0)
            t = a[(i - 1) * x + k][(j - 1) * x + z], flag = 1;
          else {
            if (t != a[(i - 1) * x + k][(j - 1) * x + z]) {
              return 0;
            }
          }
        }
      }
    }
  }
  return 1;
}
int main() {
  for (int i = 0; i <= 9; i++) {
    b[i + '0'] = i;
  }
  for (int i = 0; i <= 9; i++) {
    b[i + 'A'] = 10 + i;
  }
  getInt(&n);
  for (int i = 1; i <= n; i++) {
    for (int j = 1; j <= n / 4; j++) {
      char x = getchar();
      change(i, j, x);
    }
    getchar();
  }
  vector<int> v;
  int ans = 1;
  for (int i = 2; i <= n; i++) {
    if (n % i == 0) {
      v.push_back(i);
    }
  }
  for (auto x : v) {
    if (check(x)) {
      ans = x;
    }
  }
  printf("%d", ans);
  return 0;
}
inline void getInt(int* p) {
  char ch;
  do {
    ch = getchar();
  } while (ch == ' ' || ch == '\n');
  if (ch == '-') {
    *p = -(getchar() - '0');
    while ((ch = getchar()) >= '0' && ch <= '9') {
      *p = *p * 10 - ch + '0';
    }
  } else {
    *p = ch - '0';
    while ((ch = getchar()) >= '0' && ch <= '9') {
      *p = *p * 10 + ch - '0';
    }
  }
}
