#include <bits/stdc++.h>
using namespace std;
int main() {
  string s;
  vector<char> signs;
  signs.push_back('+');
  while (cin >> s, s[0] != '=') {
    if (s[0] == '?') continue;
    signs.push_back(s[0]);
  }
  int n;
  cin >> n;
  int plus = count(signs.begin(), signs.end(), '+');
  int minus = count(signs.begin(), signs.end(), '-');
  int minPos = plus;
  int maxPos = plus * n;
  int minNeg = minus;
  int maxNeg = minus * n;
  if (minNeg + n > maxPos || maxNeg + n < minPos) {
    cout << "Impossible" << endl;
    return 0;
  }
  cout << "Possible" << endl;
  vector<int> nums(signs.size());
  int l = max(minPos, minNeg + n);
  int r = min(maxPos, maxNeg + n);
  int takePos = l;
  int takeNeg = takePos - n;
  takeNeg -= minus;
  takePos -= plus;
  for (size_t i = 0; i < nums.size(); ++i) {
    if (signs[i] == '+') {
      nums[i] = 1 + min(n - 1, takePos);
      takePos -= min(n - 1, takePos);
    } else {
      nums[i] = 1 + min(n - 1, takeNeg);
      takeNeg -= min(n - 1, takeNeg);
    }
  }
  cout << nums[0] << ' ';
  for (size_t i = 1; i < nums.size(); ++i) {
    cout << signs[i] << ' ' << nums[i] << ' ';
  }
  cout << '=' << ' ' << n << endl;
}
