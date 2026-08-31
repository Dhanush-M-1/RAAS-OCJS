#include <bits/stdc++.h>
using namespace std;
int main() {
  string str;
  int n;
  cin >> str >> n;
  for (int i = 0; i < str.length(); i++) {
    if (str[i] >= 'A' && str[i] <= 'Z') str[i] += 32;
    if (str[i] < (n + 97)) {
      str[i] -= 32;
    }
  }
  cout << str << endl;
  return 0;
}
