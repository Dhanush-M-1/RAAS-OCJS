#include <bits/stdc++.h>
using namespace std;
int b[200];
int main() {
  int n;
  cin >> n;
  string s;
  cin >> s;
  for (int i = 0; i < s.size(); i++) {
    b[s[i]]++;
  }
  int i = 'I', f = 'F', a = 'A';
  if (!b[i]) {
    cout << b[a] << endl;
  } else if (b[i] == 1) {
    cout << 1 << endl;
  } else {
    cout << 0 << endl;
  }
  return 0;
}
