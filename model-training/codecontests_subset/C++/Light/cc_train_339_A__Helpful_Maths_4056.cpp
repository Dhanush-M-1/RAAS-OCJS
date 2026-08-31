#include <bits/stdc++.h>
using namespace std;
int main() {
  string str;
  cin >> str;
  vector<char> v, v1;
  for (int i = 0; i < str.length(); i += 2) {
    v.push_back(str[i]);
  }
  sort(v.begin(), v.end());
  for (int i = 0; i < v.size() - 1; i++) {
    v1.push_back(v[i]);
    v1.push_back('+');
  }
  v1.push_back(v[v.size() - 1]);
  for (int i = 0; i < v1.size(); i++) cout << v1[i];
}
