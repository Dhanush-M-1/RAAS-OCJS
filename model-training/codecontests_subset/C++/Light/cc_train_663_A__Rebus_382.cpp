#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(false);
  string t = "+";
  int n = 0, p = 0, m = 0;
  string s;
  vector<int> P;
  while (cin >> s) {
    if (s == "?") {
      if (t == "+")
        p++, P.push_back(0);
      else
        m++, P.push_back(1);
    } else if (s == "+" || s == "-")
      t = s;
    else
      n = atoi(s.c_str());
  }
  if (p - n * m > n || n > n * p - m)
    cout << "Impossible\n";
  else {
    cout << "Possible\n";
    int xm = 1, xp = 1, S = 0;
    for (int i = 0; i < P.size(); ++i) {
      if (P[i]) {
        m--;
        while (S - xm + p - n * m > n || n > S - xm + n * p - m) xm++;
        cout << xm << " ";
        S -= xm;
      } else {
        p--;
        while (S + xp + p - n * m > n || n > S + xp + n * p - m) xp++;
        cout << xp << " ";
        S += xp;
      }
      if (i == P.size() - 1) break;
      if (P[i + 1] == 0)
        cout << "+ ";
      else
        cout << "- ";
    }
    cout << "= " << n << "\n";
  }
  return 0;
}
