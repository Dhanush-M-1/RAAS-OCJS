#include <bits/stdc++.h>
using namespace std;
int main() {
  string input;
  int k, letters[26] = {0};
  cin >> k >> input;
  for (int i = 0; i < input.size(); i++) letters[input[i] - 'a']++;
  for (int i = 0; i < 26; i++)
    if (letters[i] % k != 0) {
      cout << "-1";
      return 0;
    }
  for (int i = 0; i < k; i++)
    for (int j = 0; j < 26; j++)
      for (int m = 0; m < letters[j] / k; m++) cout << (char)(j + 'a');
}
