#include <bits/stdc++.h>
using namespace std;
int main() {
  string sum;
  cin >> sum;
  vector<char> sym;
  for (int i = 0; i < sum.length(); ++i) {
    if (sum[i] != '+') sym.push_back(sum[i]);
  }
  sort(sym.begin(), sym.end());
  for (int i = 0; i < sym.size(); ++i) {
    if (i == 0) {
      cout << sym[i];
    } else {
      cout << "+" << sym[i];
    }
  }
  return 0;
}
