#include <bits/stdc++.h>
using namespace std;
void solve() {
  string s, s1;
  cin >> s;
  int count = 0;
  sort(s.begin(), s.end());
  for (int i = 0; i < s.length(); ++i) {
    if (s[i] == '+') count++;
  }
  std::vector<string> v(s.length());
  for (int i = count; i < s.length(); ++i) {
    v[i] = s[i];
  }
  if (count != 0)
    for (int i = count; i < v.size() - 1; ++i) {
      cout << v[i] << "+";
    }
  cout << v[v.size() - 1];
}
int main() { solve(); }
