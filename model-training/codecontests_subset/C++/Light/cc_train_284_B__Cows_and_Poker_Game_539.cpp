#include <bits/stdc++.h>
using namespace std;
template <class stl>
void DBGSTL(stl a) {
  for (__typeof((a).begin()) i = (a).begin(); i != (a).end(); i++) {
    cerr << *i << " ";
  }
  cerr << "\n";
  return;
}
int main() {
  string s;
  int n;
  cin >> n;
  cin >> s;
  int a = 0, in = 0, f = 0;
  for (int i = 0; i < s.size(); i++) {
    if (s[i] == 'A') a++;
    if (s[i] == 'I') in++;
    if (s[i] == 'F') f++;
  }
  if (in == 0) {
    cout << a << "\n";
  } else if (in == 1) {
    cout << 1 << "\n";
  } else {
    cout << 0 << endl;
  }
  return 0;
}
