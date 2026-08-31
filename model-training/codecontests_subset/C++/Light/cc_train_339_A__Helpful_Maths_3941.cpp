#include <bits/stdc++.h>
using namespace std;
int main() {
  string num;
  cin >> num;
  for (int i = 0; i < num.size() - 1; i += 2) {
    for (int j = 0; j < num.size() - i - 2; j += 2) {
      if (num[j] > num[j + 2]) {
        char temp = num[j];
        num[j] = num[j + 2];
        num[j + 2] = temp;
      }
    }
  }
  cout << num;
}
