#include <bits/stdc++.h>
using namespace std;
int minv(int plus, int minus, int n) { return plus - minus * n; }
int maxv(int plus, int minus, int n) { return plus * n - minus; }
int main() {
  ios_base::sync_with_stdio(0);
  string s;
  getline(cin, s);
  int plus = 0, minus = 0, n = 0;
  char prev = '+';
  vector<int> order;
  for (int i = 0; i < (int)s.size(); i++) {
    if (s[i] == ' ')
      continue;
    else if (s[i] == '+' || s[i] == '-')
      prev = s[i];
    else if (s[i] == '?') {
      if (prev == '+')
        plus++, order.push_back(1);
      else
        minus++, order.push_back(0);
    } else if (isdigit(s[i])) {
      n *= 10;
      n += s[i] - '0';
    }
  }
  if (maxv(plus, minus, n) < n || minv(plus, minus, n) > n) {
    cout << "Impossible";
    return 0;
  }
  cout << "Possible\n";
  int cur = 0;
  vector<int> p, m;
  while (plus > 0) {
    for (int i = 1; i < n + 1; i++) {
      cur += i;
      if (minv(plus - 1, minus, n) + cur > n ||
          maxv(plus - 1, minus, n) + cur < n) {
        cur -= i;
      } else {
        p.push_back(i);
        break;
      }
    }
    plus--;
  }
  while (minus > 0) {
    for (int i = 1; i < n + 1; i++) {
      cur -= i;
      if (minv(plus, minus - 1, n) + cur > n ||
          maxv(plus, minus - 1, n) + cur < n) {
        cur += i;
      } else {
        m.push_back(i);
        break;
      }
    }
    minus--;
  }
  for (int i = 0; i < (int)order.size(); i++) {
    if (order[i] == 1) {
      if (i != 0) cout << " + ";
      cout << p.back();
      p.pop_back();
    } else {
      cout << " - ";
      cout << m.back();
      m.pop_back();
    }
  }
  cout << " = " << n;
}
