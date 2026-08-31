#include <bits/stdc++.h>
using namespace std;
int main() {
  string str;
  cin >> str;
  vector<int> v;
  for (int i = 0; str[i] != '\0'; i++) {
    if (str[i] != '+') v.push_back(((int)str[i]) - 48);
  }
  sort(v.begin(), v.end());
  for (auto iter = v.begin(); iter != v.end() - 1; iter++) {
    cout << *iter << "+";
  }
  cout << *(v.end() - 1);
  return 0;
}
