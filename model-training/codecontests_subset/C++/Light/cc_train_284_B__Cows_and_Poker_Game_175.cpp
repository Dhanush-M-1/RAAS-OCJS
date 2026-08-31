#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  cin >> n;
  string s;
  cin >> s;
  int f = 0, a = 0, ii = 0;
  for (int j = 0; j < s.size(); j++) {
    if (s[j] == 'F') {
      f = 1;
    } else if (s[j] == 'A') {
      a++;
    } else {
      ii++;
    }
  }
  int res = 0;
  if (ii == 0) {
    for (int i = 0; i < s.size(); i++) {
      if (s[i] == 'A') res++;
    }
  } else if (ii > 1) {
    res = 0;
  } else if (ii == 1) {
    res = 1;
  }
  cout << res;
}
