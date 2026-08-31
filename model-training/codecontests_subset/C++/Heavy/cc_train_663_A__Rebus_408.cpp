#include <bits/stdc++.h>
using namespace std;
const int MAXN = 110;
int pos, neg, n;
int sz;
int vpos[1010];
void solve(int val) {
  cout << "Possible\n";
  int posr = val;
  int negr = val - n;
  bool first = true;
  for (int i = 0; i < (sz); ++i) {
    if (vpos[i] == 1) {
      int x = min(min(n, posr - pos + 1), posr);
      posr -= x;
      if (!first)
        cout << " + ";
      else
        first = false;
      cout << " " << x;
      --pos;
    } else {
      int x = min(min(n, negr - neg + 1), negr);
      negr -= x;
      cout << " " << -x;
      --neg;
    }
  }
  cout << " = " << n << endl;
}
int main() {
  ios::sync_with_stdio(false);
  ;
  int sign = 1;
  char c;
  while (cin >> c && c != '=') {
    if (c == '?') {
      if (sign == 1)
        ++pos;
      else
        ++neg;
      vpos[sz++] = sign;
    } else {
      if (c == '+')
        sign = 1;
      else
        sign = -1;
    }
  }
  cin >> n;
  int r = n + neg;
  int s = n + n * neg;
  int p = pos;
  int q = n * pos;
  if (s >= p && s <= q)
    solve(s);
  else if (r >= p && r <= q)
    solve(r);
  else
    cout << "Impossible\n";
  return 0;
}
