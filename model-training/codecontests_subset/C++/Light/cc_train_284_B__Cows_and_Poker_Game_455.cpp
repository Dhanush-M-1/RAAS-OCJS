#include <bits/stdc++.h>
using namespace std;
int main() {
  int p;
  cin >> p;
  string S;
  cin >> S;
  int numA = 0, numF = 0, numI = 0;
  for (int i = (0); i < (int((S).size())); ++i) {
    if (S[i] == 'A')
      numA++;
    else if (S[i] == 'F')
      numF++;
    else
      numI++;
  }
  if (numI == 0)
    cout << numA << endl;
  else if (numI == 1)
    cout << 1 << endl;
  else
    cout << 0 << endl;
}
