#include <bits/stdc++.h>
using namespace std;
int read() {
  int x = 0;
  char c = getchar();
  int q = 1;
  while (c < '0' || c > '9') {
    if (c == '-') q = -1;
    c = getchar();
  }
  while (c >= '0' && c <= '9') {
    x = (x << 3) + (x << 1) + c - '0';
    c = getchar();
  }
  x = x * q;
  return x;
}
void out(int x) {
  if (x < 0) x = -x, putchar('-');
  if (x >= 10) out(x / 10);
  putchar(x % 10 + '0');
  return;
}
int n;
string s;
int main() {
  n = read();
  cin >> s;
  for (int i = 0; i <= n - 2; i++) {
    if (s[i] > s[i + 1]) {
      cout << "YES\n";
      cout << i + 1 << " " << i + 2;
      return 0;
    }
  }
  cout << "NO";
  return 0;
}
