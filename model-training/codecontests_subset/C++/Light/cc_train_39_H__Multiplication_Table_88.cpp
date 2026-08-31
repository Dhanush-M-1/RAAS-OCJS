#include <bits/stdc++.h>
using namespace std;
string fromDeci(int base, int inputNum) {
  string result;
  while (inputNum > 0) {
    result = result + to_string(inputNum % base);
    inputNum = inputNum / base;
  }
  reverse(result.begin(), result.end());
  return result;
}
int main() {
  int k, i, j;
  cin >> k;
  for (i = 1; i < k; i++) {
    for (j = 1; j < k; j++) cout << fromDeci(k, i * j) << " ";
    cout << endl;
  }
  return 0;
}
