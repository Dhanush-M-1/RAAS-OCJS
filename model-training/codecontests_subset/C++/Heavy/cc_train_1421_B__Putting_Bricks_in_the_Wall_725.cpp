#include <bits/stdc++.h>
using namespace std;
namespace chino {
const int maxn = 0x3f3f3f3f;
const int inf = 0x7fffffff;
}  // namespace chino
inline int read() {
  char ch;
  int f = 1, x = 0;
  do {
    ch = getchar();
    if (ch == '-') f = -1;
  } while (!isdigit(ch));
  do {
    x = x * 10 + ch - '0';
    ch = getchar();
  } while (isdigit(ch));
  return f * x;
}
inline void print(int x) {
  if (x < 0) {
    putchar('-');
    x = -x;
  }
  if (x > 9) print(x / 10);
  putchar(x % 10 + '0');
}
const int mod = 1e9 + 7;
string s[220];
int main() {
  int t;
  cin >> t;
  while (t--) {
    int n;
    cin >> n;
    for (int i = 0; i < n; i++) cin >> s[i];
    char a, b, c, d;
    a = s[0][1];
    b = s[1][0];
    c = s[n - 2][n - 1];
    d = s[n - 1][n - 2];
    if (a == b) {
      if (c == d) {
        if (a == c) {
          cout << 2 << endl;
          cout << n << ' ' << n - 1 << endl;
          cout << n - 1 << ' ' << n << endl;
        } else {
          cout << 0 << endl;
        }
      } else {
        if (a == c) {
          cout << 1 << endl;
          cout << n - 1 << ' ' << n << endl;
        } else {
          cout << 1 << endl;
          cout << n << ' ' << n - 1 << endl;
        }
      }
    } else {
      if (c == d) {
        if (a == c) {
          cout << 1 << endl;
          cout << 1 << ' ' << 2 << endl;
        } else {
          cout << 1 << endl;
          cout << 2 << ' ' << 1 << endl;
        }
      } else {
        if (a == c) {
          cout << 2 << endl;
          cout << n - 1 << ' ' << n << endl;
          cout << 2 << ' ' << 1 << endl;
        } else {
          cout << 2 << endl;
          cout << 1 << ' ' << 2 << endl;
          cout << n - 1 << ' ' << n << endl;
        }
      }
    }
  }
}
