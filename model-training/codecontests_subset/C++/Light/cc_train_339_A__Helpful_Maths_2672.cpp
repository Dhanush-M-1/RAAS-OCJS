#include <bits/stdc++.h>
using namespace std;
int main() {
  string s;
  cin >> s;
  string sum;
  for (int i = 0; i < s.length(); i++) {
    if (isdigit(s[i])) {
      sum = sum + s[i];
    }
  }
  sort(sum.begin(), sum.end());
  for (int i = 0; i < sum.length(); i++) {
    cout << sum[i];
    if (i != sum.length() - 1) cout << "+";
  }
  return 0;
}
