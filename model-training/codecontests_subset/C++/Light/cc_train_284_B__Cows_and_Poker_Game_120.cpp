#include <bits/stdc++.h>
using namespace std;
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  long long n, A(0), I(0);
  string s;
  cin >> n >> s;
  for (int i = 0; i < n; i++) {
    if (s[i] == 'A') {
      A++;
    } else if (s[i] == 'I') {
      I++;
    }
  }
  if (I == 0) {
    cout << A << endl;
  }
  if (I == 1) {
    cout << I << endl;
  } else if (I > 1) {
    cout << 0 << endl;
  }
  return 0;
}
