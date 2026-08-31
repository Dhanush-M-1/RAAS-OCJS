#include <bits/stdc++.h>
using namespace std;
int comp_double(double a, double b) {
  if (fabs(a - b) <= 1e-10) return 0;
  return a < b ? -1 : 1;
}
string s;
char c;
int main() {
  cin >> s;
  sort(s.begin(), s.end());
  for (int i = (s.size() / 2), j = 0; j < s.size(); j++) {
    if ((j & 1) && (j != (s.size() - 1)))
      cout << '+';
    else {
      cout << s[i];
      i++;
    }
  }
}
