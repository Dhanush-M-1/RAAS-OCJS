#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, A = 0, I = 0, F = 0;
  cin >> n;
  string s;
  cin >> s;
  for (int i = 0; i < n; i++) {
    if (s[i] == 'I') I++;
    if (s[i] == 'F') F++;
    if (s[i] == 'A') A++;
  }
  if (I == 0)
    cout << A;
  else if (I == 1)
    cout << 1;
  else
    cout << 0;
  return 0;
}
