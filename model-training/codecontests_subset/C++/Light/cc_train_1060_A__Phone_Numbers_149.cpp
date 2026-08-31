#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  cin >> n;
  int k = n;
  string s;
  cin >> s;
  int cn = 0;
  for (int i = 0; i < n; i++) {
    if (s[i] == '8') cn++;
  }
  int rem = n / 11;
  if (rem <= cn)
    cout << rem;
  else
    cout << cn;
  return 0;
}
