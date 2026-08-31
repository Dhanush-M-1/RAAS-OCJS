#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, sum = 0, sum1 = 0, sum2 = 0;
  cin >> n;
  string str;
  cin >> str;
  for (int i = 0; i < str.length(); i++) {
    if (str[i] == 'A') {
      sum++;
    } else if (str[i] == 'I') {
      sum1++;
    } else {
      sum2++;
    }
  }
  if (sum && sum1 == 0) {
    cout << sum << endl;
  } else if ((sum1 == 1 && sum) || (sum1 == 1 && sum2)) {
    cout << sum1 << endl;
  } else {
    cout << 0 << endl;
  }
  return 0;
}
