#include <bits/stdc++.h>
using namespace std;
int na, nf, ni;
int main() {
  string s;
  na = nf = ni = 0;
  int n;
  cin >> n;
  cin >> s;
  for (int i = 0; i < s.size(); ++i) {
    na += (s[i] == 'A');
    nf += (s[i] == 'F');
    ni += (s[i] == 'I');
  }
  if (ni == 0)
    cout << na << endl;
  else if (ni == 1)
    cout << 1 << endl;
  else
    cout << 0 << endl;
}
