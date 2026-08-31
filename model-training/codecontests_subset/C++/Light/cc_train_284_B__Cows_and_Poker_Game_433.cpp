#include <bits/stdc++.h>
using namespace std;
int n, cnt = 0;
string s;
int cnta, cnti, cntf;
int main() {
  cin >> n >> s;
  for (int i = 0; i < n; i++) {
    if (s[i] == 'F')
      cntf++;
    else if (s[i] == 'I')
      cnti++;
    else
      cnta++;
  }
  if (cnti == 0)
    cout << cnta << endl;
  else if (cnti == 1)
    cout << "1\n";
  else
    cout << "0\n" << endl;
  return 0;
}
