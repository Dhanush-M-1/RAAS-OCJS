#include <bits/stdc++.h>
using namespace std;
template <typename T>
void read(T& x) {
  x = 0;
  T f = 1;
  char ch = getchar();
  while (!isdigit(ch)) f = ch == '-' ? -f : f, ch = getchar();
  while (isdigit(ch)) x = x * 10 + ch - '0', ch = getchar();
  x *= f;
}
template <typename T>
void viet(T x) {
  if (x > 9) viet(x / 10);
  putchar(x % 10 + '0');
}
int n, cnt, ret;
string s;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cin >> n >> s;
  for (int i = 0; i < s.size(); i++) {
    if (s[i] == '8') cnt++;
  }
  n -= cnt;
  int foo = min(cnt, n / 10);
  ret += foo;
  cnt -= foo;
  n -= foo * 10;
  if (cnt > 0) ret += (cnt + n) / 11;
  cout << ret << endl;
}
