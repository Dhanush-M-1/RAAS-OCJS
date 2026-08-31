#include <bits/stdc++.h>
using namespace std;
string s;
int cnt1;
int cnt2;
int main() {
  int n;
  cin >> n;
  cin >> s;
  cnt1 = 0;
  cnt2 = 0;
  for (int i = 0; i < n; i++) {
    if (s[i] == '8')
      cnt2++;
    else
      cnt1++;
  }
  for (int i = cnt2; i >= 0; i--) {
    if (cnt1 + cnt2 - i >= i * 10) {
      cout << i << endl;
      return 0;
    }
  }
  cout << 0 << endl;
  return 0;
}
