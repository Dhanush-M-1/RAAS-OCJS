#include <bits/stdc++.h>
using namespace std;
int main() {
  int x, i, id = 0, id2 = 0;
  cin >> x;
  string s;
  cin >> s;
  char ch = s[x - 1];
  for (i = 0; i < x - 1; i++) {
    if ((s[i] - '0') > s[i + 1] - '0') {
      id = i + 1;
      id2 = i + 2;
      break;
    }
  }
  if (id > 0) {
    cout << "YES" << endl;
    cout << id << " " << id2 << endl;
  } else
    cout << "NO" << endl;
  return 0;
}
