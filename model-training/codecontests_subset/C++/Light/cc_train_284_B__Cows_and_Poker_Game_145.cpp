#include <bits/stdc++.h>
using namespace std;
int main() {
  int countI = 0, countA = 0, countF = 0;
  int n;
  char c;
  string s = "";
  cin >> n;
  for (int i = 0; i < n; i++) {
    cin >> c;
    s += c;
  }
  for (int j = 0; j < s.length(); j++) {
    if (s.at(j) == 'I')
      countI++;
    else if (s.at(j) == 'A')
      countA++;
    else
      countF++;
  }
  if (countI == 1)
    cout << countI;
  else if (countI > 1)
    cout << "0";
  else if (countI == 0)
    cout << countA;
  return 0;
}
