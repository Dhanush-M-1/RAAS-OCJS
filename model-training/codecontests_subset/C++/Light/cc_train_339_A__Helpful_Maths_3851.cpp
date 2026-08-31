#include <bits/stdc++.h>
using namespace std;
int main() {
  string input, ans;
  vector<int> arr;
  stringstream ss;
  while (cin >> input) {
    for (int i = 0; input[i] != '\0'; i++) {
      if (input[i] != '+') {
        arr.push_back(input[i] - '0');
      }
    }
    sort(arr.begin(), arr.end());
    for (auto j = arr.begin(); j < arr.end(); j++) {
      if (j != arr.end() - 1) {
        ss << *j << '+';
      } else {
        ss << *j;
      }
    }
    ans = ss.str();
    cout << ans;
  }
  return 0;
}
