#include <bits/stdc++.h>
using namespace std;
int main() {
  string s;
  vector<int> nums;
  getline(cin, s);
  for (int i = 0; i < s.length(); ++i) {
    if (s[i] != '+') {
      nums.push_back(s[i] - '0');
    }
  }
  sort(nums.begin(), nums.end());
  for (int i = 0; i < nums.size() - 1; ++i) {
    cout << nums[i] << '+';
  }
  cout << nums[nums.size() - 1];
}
