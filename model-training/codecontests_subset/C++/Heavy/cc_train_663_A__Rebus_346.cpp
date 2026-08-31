#include <bits/stdc++.h>
using namespace std;
const long long maxn = 1e9, mxs = 1e6 + 100;
string s, Str;
long long Ans, first = 1, c;
long long x1 = 1, x2;
void Sum1() {
  cout << Ans << ' ', --x1;
  long long Save = (x1 * Ans), cp;
  cp = Save % x2;
  Save /= x2;
  for (long long i = 1; i < Str.size() - c - 1; i += 2) {
    if (Str[i] == '+')
      cout << "+ " << Ans << ' ';
    else {
      if (cp)
        cout << "- " << Save + 1 << ' ', --cp, --x2;
      else if (x2)
        cout << "- " << Save << ' ', --x2;
    }
  }
  cout << "= " << Ans;
}
void Sum2() {
  cout << (Ans + Ans * x2) / x1 << ' ';
  long long o = (Ans + Ans * x2), z = o / x1;
  --x1;
  if (x1 == 0)
    cout << "= " << Ans;
  else {
    long long Save = (o - z), cp;
    cp = Save % x1, Save /= x1;
    for (long long i = 1; i < Str.size() - c - 1; i += 2) {
      if (Str[i] == '-')
        cout << "- " << Ans << ' ';
      else {
        if (cp)
          cout << "+ " << Save + 1 << ' ', --cp, --x1;
        else if (x1)
          cout << "+ " << Save << ' ', --x1;
      }
    }
    cout << "= " << Ans;
  }
}
int main() {
  getline(cin, s);
  for (long long t = 0; t < s.size(); ++t) {
    if (s[t] == '+')
      x1++;
    else if (s[t] == '-')
      x2++;
    if (s[t] != ' ') Str += s[t];
  }
  for (long long t = s.size() - 1; t >= 0; --t) {
    if ('0' <= s[t] && s[t] <= '9') {
      Ans += (s[t] - '0') * first;
      first *= 10;
      c++;
    }
  }
  if (Ans * x1 - x2 < Ans || x1 - Ans * x2 > Ans)
    return cout << "Impossible", 0;
  else {
    cout << "Possible\n", (x1 <= x2 ? Sum1() : Sum2());
  }
}
