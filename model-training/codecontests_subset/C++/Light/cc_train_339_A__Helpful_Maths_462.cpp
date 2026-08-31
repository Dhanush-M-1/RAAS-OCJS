#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(false), cin.tie(0), cout.tie(0);
  string str;
  vector<char> vec;
  cin >> str;
  for (long long int i = 0; i < str.length(); i++) {
    if (str[i] == '1' || str[i] == '2' || str[i] == '3') vec.push_back(str[i]);
  }
  sort(vec.begin(), vec.end());
  cout << vec[0];
  vec.erase(vec.begin());
  while (vec.size()) {
    cout << "+" << vec[0];
    vec.erase(vec.begin());
  }
  return 0;
}
