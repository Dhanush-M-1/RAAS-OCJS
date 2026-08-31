#include <bits/stdc++.h>
using namespace std;
int main() {
  int tosub = 0;
  int pls = 1;
  int mins = 0;
  string s;
  char a;
  cin >> a;
  while (a != '=') {
    if (a == '+') {
      s.push_back(a);
      pls++;
    } else if (a == '-') {
      mins++;
      s.push_back(a);
    }
    cin >> a;
  }
  int tmp;
  cin >> tmp;
  int mn = pls - mins * tmp;
  int mx = pls * tmp - mins;
  if (tmp < mn || tmp > mx) {
    cout << "Impossible\n";
    return 0;
  }
  cout << "Possible\n";
  int curr = 0;
  for (int i = (-1); i < (int)s.size(); ++i) {
    if (!(~i) || s[i] == '+') {
      if (i >= 0) {
        cout << s[i] << " ";
      }
      for (int j = 1; j <= tmp; ++j) {
        int mn = (pls - 1) - mins * tmp;
        int mx = (pls - 1) * tmp - mins;
        if (mn <= tmp - (curr + j) && mx >= tmp - (curr + j)) {
          cout << j << " ";
          pls--;
          curr += j;
          break;
        }
      }
    } else {
      cout << s[i] << " ";
      for (int j = 1; j <= tmp; ++j) {
        int mn = pls - (mins - 1) * tmp;
        int mx = pls * tmp - (mins - 1);
        if (mn <= tmp - (curr - j) && mx >= tmp - (curr - j)) {
          cout << j << " ";
          mins--;
          curr -= j;
          break;
        }
      }
    }
  }
  cout << " = " << tmp << "\n";
  return 0;
}
