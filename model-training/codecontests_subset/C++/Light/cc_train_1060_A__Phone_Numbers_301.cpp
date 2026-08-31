#include <bits/stdc++.h>
using namespace std;
int sonuc1, sonuc2, n, sayac1, sayac2;
string s;
int main() {
  cin >> n;
  cin >> s;
  for (int i = 0; i < n; ++i) {
    if (s[i] >= '0' and s[i] <= '9') {
      sayac1++;
    }
    if (s[i] == '8') {
      sayac2++;
    }
  }
  if (sayac1 == n and sayac2 >= n / 11) {
    cout << n / 11;
  } else if (sayac2 < n / 11 and sayac2 > 0) {
    cout << sayac2;
  } else {
    cout << 0;
  }
  return 0;
}
