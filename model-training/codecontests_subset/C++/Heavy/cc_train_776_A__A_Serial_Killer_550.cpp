#include <bits/stdc++.h>
using namespace std;
const int inf = 0x7f7f7f7f;
template <typename t>
t read() {
  t x = 0;
  int f = 1;
  char c = getchar();
  while (c > '9' || c < '0') f = c == '-' ? -1 : 1, c = getchar();
  while (c >= '0' && c <= '9') x = x * 10 + c - 48, c = getchar();
  return x * f;
}
template <typename t>
void write(t x) {
  if (x < 0) {
    putchar('-'), write(-x);
    return;
  }
  if (x >= 10) write(x / 10);
  putchar(x % 10 + 48);
}
string a, b, ans[1010][2];
int n;
int main() {
  cin >> ans[0][0] >> ans[0][1];
  cin >> n;
  for (int i = 1; i <= n; i++) {
    cin >> a >> b;
    if (ans[i - 1][0] == a) {
      ans[i][0] = b;
      ans[i][1] = ans[i - 1][1];
    } else {
      ans[i][1] = b;
      ans[i][0] = ans[i - 1][0];
    }
  }
  for (int i = 0; i <= n; i++) cout << ans[i][0] << " " << ans[i][1] << endl;
}
