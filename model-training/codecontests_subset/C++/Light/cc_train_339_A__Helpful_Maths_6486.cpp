#include <bits/stdc++.h>
using namespace std;
void sortString(string &str) {
  sort(str.begin(), str.end());
  int size = str.length();
  for (int i = 0; i < size - 1; i++) {
    cout << str[i] << "+";
  }
  cout << str[size - 1] << "\n";
}
int main() {
  ios_base::sync_with_stdio(false), cin.tie(nullptr), cout.tie(nullptr);
  string str;
  cin >> str;
  str.erase(remove(str.begin(), str.end(), '+'), str.end());
  sortString(str);
  return 0;
}
