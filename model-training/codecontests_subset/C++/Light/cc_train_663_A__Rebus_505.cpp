#include <bits/stdc++.h>
using namespace std;
const long long MAX1 = 3e5 + 10;
long long a, b, c, d, e, cnt, x, y, flag, num[100];
char nu[100], ch;
int main() {
  cin >> ch;
  nu[0] = '+';
  while (ch != '=') {
    if (ch == '?')
      ++a;
    else {
      ++cnt;
      nu[cnt] = ch;
    }
    cin >> ch;
  }
  fill(num, num + a, 1);
  cin >> b;
  for (int i = 0; i < a; ++i) {
    if (nu[i] == '+')
      ++flag;
    else
      --flag;
  }
  if (flag > b) {
    flag *= -1;
    b *= -1;
    e = 1;
    for (int i = 0; i < a; ++i) {
      if (nu[i] == '+')
        nu[i] = '-';
      else
        nu[i] = '+';
    }
  }
  x = abs(b) - 1;
  cnt = b - flag;
  for (int i = 0; i < a; ++i) {
    if (nu[i] == '+') {
      y = min(x, cnt);
      num[i] += y;
      cnt -= y;
    }
  }
  if (cnt) {
    cout << "Impossible";
    return 0;
  }
  cout << "Possible\n" << num[0] << ' ';
  if (e) {
    for (int i = 1; i < a; ++i) {
      if (nu[i] == '+')
        nu[i] = '-';
      else
        nu[i] = '+';
    }
  }
  for (int i = 1; i < a; ++i) {
    cout << nu[i] << ' ' << num[i] << ' ';
  }
  cout << '=' << ' ' << abs(b);
  return 0;
}
