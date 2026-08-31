#include <bits/stdc++.h>
using namespace std;
int main() {
  string s1;
  cin >> s1;
  vector<int> v;
  int j = 0;
  for (int i = 0; i < s1.size(); i += 2) v.push_back(s1[i] - 48);
  sort(v.begin(), v.end());
  for (int i = 0; i < v.size(); i++) {
    cout << v.at(i);
    if (i != v.size() - 1) cout << "+";
  }
  cout << endl;
  return 0;
}
