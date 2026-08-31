#include <bits/stdc++.h>
using namespace std;
int main() {
  string inpt, outpt = "";
  vector<char> digits;
  getline(cin, inpt);
  for (int i = 0; i < inpt.size(); i++) {
    if (inpt[i] != '+') {
      digits.push_back(inpt[i]);
    }
  }
  sort(digits.begin(), digits.end());
  for (int i = 0; i < digits.size() - 1; i++) {
    outpt += digits[i];
    outpt += '+';
  }
  outpt += digits[digits.size() - 1];
  cout << outpt << endl;
  return 0;
}
