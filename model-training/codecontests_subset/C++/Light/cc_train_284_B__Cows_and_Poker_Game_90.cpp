#include <bits/stdc++.h>
using namespace std;
int main() {
  string s;
  int n;
  int sumA;
  int sumF;
  int sumI;
  while (cin >> n) {
    sumA = sumF = sumI = 0;
    cin >> s;
    for (int i = 0; i < n; ++i) {
      if (s[i] == 'A')
        sumA++;
      else if (s[i] == 'F')
        sumF++;
      else
        sumI++;
    }
    if (sumI == 0)
      cout << sumA << endl;
    else if (sumI == 1)
      cout << "1" << endl;
    else
      cout << "0" << endl;
  }
  return 0;
}
