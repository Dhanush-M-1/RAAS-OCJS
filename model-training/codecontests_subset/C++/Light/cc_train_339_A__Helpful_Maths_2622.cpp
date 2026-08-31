#include <bits/stdc++.h>
using namespace std;
int main() {
  vector<char> v1;
  string st;
  getline(cin, st);
  int s = st.size();
  for (int i = 0; i < s; i = i + 2) v1.push_back(st.at(i));
  sort(v1.begin(), v1.begin() + v1.size());
  for (int i = 0; i < v1.size() - 1; i++) cout << v1.at(i) << '+';
  cout << v1.back();
}
