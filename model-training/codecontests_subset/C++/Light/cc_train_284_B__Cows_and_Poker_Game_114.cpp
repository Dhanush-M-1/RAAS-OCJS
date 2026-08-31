#include <bits/stdc++.h>
using namespace std;
int main() {
  long long int n, i, j, l, a[4] = {}, cnt = 0, maxi = 0;
  string s;
  cin >> n >> s;
  l = s.length();
  for (i = 0; i < l; i++) {
    if (s[i] == 'A') {
      a[1]++;
    } else if (s[i] == 'F') {
      a[2]++;
    } else if (s[i] == 'I') {
      a[3]++;
    }
  }
  if (a[3] >= 2) {
    cout << "0\n";
  } else if (a[3] == 1) {
    cout << "1\n";
    return 0;
  } else {
    cout << a[1];
  }
  return 0;
}
