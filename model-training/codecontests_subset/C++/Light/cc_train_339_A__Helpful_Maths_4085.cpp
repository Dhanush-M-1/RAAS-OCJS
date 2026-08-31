#include <bits/stdc++.h>
using namespace std;
int i, n, p;
vector<int> v;
string s, s1;
int j, m, a[52];
bool x = false;
int main() {
  cin >> s;
  for (i = 0; i < s.size(); i += 2) {
    v.push_back(s[i] - '0');
  }
  sort(v.begin(), v.end());
  cout << v[0];
  for (i = 1; i < v.size(); i++) {
    cout << '+' << v[i];
  }
  cout << endl;
  return 0;
}
