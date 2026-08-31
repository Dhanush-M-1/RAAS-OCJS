#include <bits/stdc++.h>
using namespace std;
int main() {
  string s;
  cin >> s;
  vector<int> v;
  for (int i = (0); i < (s.size()); ++i) {
    v.push_back(s[i] - '0');
    ++i;
  }
  sort(v.begin(), v.end());
  for (int i = (0); i < (v.size()); ++i) {
    if (i) printf("+");
    printf("%d", v[i]);
  }
  return 0;
}
