#include <bits/stdc++.h>
using namespace std;
int main() {
  string num;
  cin >> num;
  int freq[100000] = {};
  for (int i = 0; i < num.size(); i++) {
    freq[num[i]]++;
  }
  int j = 0;
  for (char i = '1'; i <= '3'; i++) {
    while (freq[i] > 0) {
      if (j != 0) {
        cout << "+";
      }
      cout << i;
      freq[i]--;
      j++;
    }
  }
  return 0;
}
