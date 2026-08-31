#include <bits/stdc++.h>
using namespace std;
const int maxint = -1u >> 1;
int main() {
  int n;
  cin >> n;
  string str;
  cin >> str;
  int a, f, t;
  a = f = t = 0;
  for (int i = 0; i < str.size(); i++) {
    if (str[i] == 'A') a++;
    if (str[i] == 'I') t++;
    if (str[i] == 'F') f++;
  }
  if (t == 0) {
    cout << a << endl;
    return 0;
  }
  if (t == 1) {
    cout << t << endl;
    return 0;
  }
  cout << 0 << endl;
  return 0;
}
