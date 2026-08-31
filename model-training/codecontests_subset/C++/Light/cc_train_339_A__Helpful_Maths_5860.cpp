#include <bits/stdc++.h>
using namespace std;
int main() {
  string input;
  cin >> input;
  bool flag = 0;
  if (input.length() == 1) flag = 1;
  for (int j = 0; j < input.length() && flag == 0; j++) {
    for (int i = 0; i < input.length() - 2; i += 2)
      if (input[i] > input[i + 2]) swap(input[i], input[i + 2]);
  }
  cout << input << endl;
  return 0;
}
