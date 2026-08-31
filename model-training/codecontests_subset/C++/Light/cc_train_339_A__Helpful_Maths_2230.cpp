#include <bits/stdc++.h>
using namespace std;
int main() {
  string str;
  cin >> str;
  int size;
  vector<char> vec;
  for (int i = 0; i < str.size(); i += 2) {
    vec.push_back(str[i]);
  }
  sort(vec.begin(), vec.end());
  size = vec.size();
  for (int i = 0; i < size - 1; i++) cout << vec[i] << "+";
  cout << vec.back();
  return 0;
}
