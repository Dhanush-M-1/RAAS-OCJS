#include <bits/stdc++.h>
using namespace std;
int main(int argc, const char* argv[]) {
  string sum;
  cin >> sum;
  int size = sum.length();
  vector<char> numbers;
  for (int i = 0; i < size; i++) {
    if (sum[i] != '+') {
      numbers.push_back(sum[i]);
    }
  }
  sort(numbers.begin(), numbers.end());
  for (int i = 0; i < numbers.size(); i++) {
    if (i != numbers.size() - 1) {
      cout << numbers.at(i) << '+';
    } else {
      cout << numbers.at(i);
    }
  }
  return 0;
}
