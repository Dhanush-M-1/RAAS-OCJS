#include <bits/stdc++.h>
using namespace std;
int main() {
  vector<int> arr;
  string s;
  cin >> s;
  for (int i = 0; i != s.size(); i++) {
    if (s[i] != '+') arr.push_back(s[i] - '0');
  }
  sort(arr.begin(), arr.end());
  for (int i = 0; i != arr.size(); ++i) {
    if (i) cout << "+";
    cout << arr[i];
  }
  cout << endl;
}
