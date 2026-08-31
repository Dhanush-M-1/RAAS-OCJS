#include <bits/stdc++.h>
using namespace std;
int n, x[55], y[55], r[55];
string s[55], ans;
int main() {
  scanf("%d", &n);
  for (int i = 1; i <= n; ++i) scanf("%d%d%d", &x[i], &y[i], &r[i]);
  for (int i = 1; i <= n; ++i) {
    s[i] = "";
    x[i] /= 2;
    if (x[i] < 10)
      s[i] += '0' + x[i];
    else {
      s[i] += ('0' + x[i] / 10);
      s[i] += ('0' + x[i] % 10);
    }
    s[i] += '*';
    s[i] += '(';
    s[i] += '(';
    s[i] += '1';
    s[i] += '-';
    s[i] += "abs(";
    s[i] += "(t-";
    if (i < 10)
      s[i] += '0' + i;
    else {
      s[i] += ('0' + i / 10);
      s[i] += ('0' + i % 10);
    }
    s[i] += ")))+abs((1-abs((t-";
    if (i < 10)
      s[i] += '0' + i;
    else {
      s[i] += ('0' + i / 10);
      s[i] += ('0' + i % 10);
    }
    s[i] += ")))))";
    s[i] = '(' + s[i] + ')';
  }
  ans = s[1];
  for (int i = 2; i <= n; ++i) {
    ans = '(' + ans + '+' + s[i] + ')';
  }
  cout << ans << endl;
  for (int i = 1; i <= n; ++i) x[i] = y[i];
  for (int i = 1; i <= n; ++i) {
    s[i] = "";
    x[i] /= 2;
    if (x[i] < 10)
      s[i] += '0' + x[i];
    else {
      s[i] += ('0' + x[i] / 10);
      s[i] += ('0' + x[i] % 10);
    }
    s[i] += '*';
    s[i] += '(';
    s[i] += '(';
    s[i] += '1';
    s[i] += '-';
    s[i] += "abs(";
    s[i] += "(t-";
    if (i < 10)
      s[i] += '0' + i;
    else {
      s[i] += ('0' + i / 10);
      s[i] += ('0' + i % 10);
    }
    s[i] += ")))+abs((1-abs((t-";
    if (i < 10)
      s[i] += '0' + i;
    else {
      s[i] += ('0' + i / 10);
      s[i] += ('0' + i % 10);
    }
    s[i] += ")))))";
    s[i] = '(' + s[i] + ')';
  }
  ans = s[1];
  for (int i = 2; i <= n; ++i) {
    ans = '(' + ans + '+' + s[i] + ')';
  }
  cout << ans << endl;
  return 0;
}
