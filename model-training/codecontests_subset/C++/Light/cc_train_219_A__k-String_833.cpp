#include <bits/stdc++.h>
using namespace std;
vector<int> num(30);
int main() {
  int k;
  cin >> k;
  string s, ans;
  cin >> s;
  for (int i = 0; i < s.size(); i++) num[s[i] - 'a']++;
  for (int i = 0; i < 30; i++)
    if (num[i] % k) {
      cout << "-1" << endl;
      return 0;
    }
  for (int i = 0; i < 30; i++)
    for (int j = 0; j < num[i] / k; j++) ans.push_back('a' + i);
  for (int i = 0; i < k; i++) cout << ans;
  cout << endl;
}
