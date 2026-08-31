#include <bits/stdc++.h>
using namespace std;
int main() {
  string str;
  cin >> str;
  vector<int> ans;
  for (int i = 0; i < str.length() / 2 + 1; i++) {
    ans.push_back(str[2 * i] - 48);
  }
  sort(ans.begin(), ans.end());
  for (int i = 0; i < ans.size(); i++) {
    cout << ans[i];
    if (i + 1 != ans.size())
      cout << "+";
    else
      cout << endl;
  }
}
