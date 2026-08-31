#include <bits/stdc++.h>
using namespace std;
int main(int argc, char *argv[]) {
  int one = 0, two = 0, three = 0;
  vector<char> output;
  string input;
  cin >> input;
  for (int i = 0; i < input.size(); i++) {
    if (input[i] == '1') {
      one++;
    }
    if (input[i] == '2') {
      two++;
    }
    if (input[i] == '3') {
      three++;
    }
  }
  for (int i = 0; i < one; i++) {
    output.push_back('1');
  }
  for (int i = 0; i < two; i++) {
    output.push_back('2');
  }
  for (int i = 0; i < three; i++) {
    output.push_back('3');
  }
  for (int i = 0; i < output.size(); i++) {
    cout << output[i];
    if (i == output.size() - 1) {
      return 0;
    }
    cout << '+';
  }
  return 0;
}
