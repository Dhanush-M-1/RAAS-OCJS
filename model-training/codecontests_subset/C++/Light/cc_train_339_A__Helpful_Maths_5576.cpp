#include <bits/stdc++.h>
using namespace std;
int main() {
  string s;
  string s1;
  cin >> s;
  vector<int> v;
  long int i;
  int a;
  for (i = 0; i < s.size(); i++) {
    if (s[i] == '1') {
      s1 = s[i];
      a = stoi(s1);
      v.push_back(a);
      s1.clear();
    } else if (s[i] == '2') {
      s1 = s[i];
      a = stoi(s1);
      v.push_back(a);
      s1.clear();
    } else if (s[i] == '3') {
      s1 = s[i];
      a = stoi(s1);
      v.push_back(a);
      s1.clear();
    }
  }
  sort(v.begin(), v.end());
  for (i = 0; i < v.size() - 1; i++) cout << v[i] << "+";
  cout << v[v.size() - 1];
}
