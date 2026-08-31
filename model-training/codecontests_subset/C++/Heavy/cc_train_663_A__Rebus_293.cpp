#include <bits/stdc++.h>
using namespace std;
int positive = -1, negative = -1;
int pluses = 1, minuses;
int n;
bool can_divide(int N, int x) {
  if (N / x < 1) return 0;
  return (N / x) + (N % x > 0) >= 1 && (N / x) + (N % x > 0) <= n;
}
int main() {
  string s;
  getline(cin, s);
  n = s.length();
  int eq = 0;
  bool test = 0;
  for (int i = 0; i < n; ++i)
    if (s[i] == '+')
      pluses++;
    else if (s[i] == '-')
      minuses++;
    else if (s[i] == '=')
      eq = i;
    else if (s[i] == '?')
      test = 1;
  if (!test) {
    cout << "Possible\n";
    cout << s;
    return 0;
  }
  int tmp = 0;
  eq += 2;
  while (eq < n) {
    tmp = tmp * 10 + (s[eq] - '0');
    ++eq;
  }
  n = tmp;
  if (n == 1 && !(pluses - minuses == 1)) {
    cout << "Impossible";
    return 0;
  }
  for (int i = 0; i <= n * 50; ++i) {
    if (pluses >= minuses) {
      int neg = i;
      int pos = i + n;
      if (minuses == 0 && neg > 0) continue;
      if ((minuses == 0 || can_divide(neg, minuses)) &&
          can_divide(pos, pluses)) {
        negative = neg, positive = pos;
        break;
      }
    } else {
      int neg = i - n;
      int pos = i;
      if (minuses == 0 && neg > 0) continue;
      if (neg >= 1 && (minuses == 0 || can_divide(neg, minuses)) &&
          can_divide(pos, pluses)) {
        negative = neg, positive = pos;
        break;
      }
    }
  }
  if (positive == -1) {
    cout << "Impossible";
    return 0;
  }
  cout << "Possible\n";
  cout << (positive / pluses) + (positive % pluses > 0);
  if (positive % pluses) --positive;
  for (int i = 1; i < (int)s.length(); ++i) {
    if (s[i] != '?')
      cout << s[i];
    else {
      if (s[i - 2] == '+') {
        cout << (positive / pluses) + (positive % pluses > 0);
        if (positive % pluses) --positive;
      } else {
        cout << (negative / minuses) + (negative % minuses > 0);
        if (negative % minuses) --negative;
      }
    }
  }
  return 0;
}
