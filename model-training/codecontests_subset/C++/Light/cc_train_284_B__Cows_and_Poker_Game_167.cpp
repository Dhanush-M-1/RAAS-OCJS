#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  string s;
  cin >> n >> s;
  int A = 0, I = 0, F = 0;
  for (int i = 0; i < s.size(); i++) {
    if (s[i] == 'A')
      A++;
    else if (s[i] == 'I')
      I++;
    else
      F++;
  }
  if (!I)
    cout << A;
  else if (I == 1)
    cout << 1;
  else
    cout << 0;
  return 0;
}
