#include <bits/stdc++.h>
using namespace std;
const int MAX = 200005;
int a[MAX];
int main() {
  int n;
  cin >> n;
  string s;
  cin >> s;
  int a1 = 0, a2 = 0, a3 = 0;
  for (int i = 0; i < n; i++) {
    if (s[i] == 'A') {
      a1++;
    } else if (s[i] == 'I') {
      a2++;
    } else {
      a3++;
    }
  }
  if (a2 == 0) {
    cout << a1 << endl;
  } else {
    if (a2 == 1) {
      cout << 1 << endl;
    } else {
      cout << 0 << endl;
    }
  }
  return 0;
}
