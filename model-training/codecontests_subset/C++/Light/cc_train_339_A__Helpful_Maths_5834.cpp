#include <bits/stdc++.h>
using namespace std;
set<char> st;
priority_queue<int> pq;
vector<char> v;
int main() {
  string s;
  cin >> s;
  for (int(i) = (0); (i) < (s.length()); (i)++) {
    if (s[i] != '+') v.push_back(s[i]);
  }
  sort(v.begin(), v.end());
  for (int(i) = (0); (i) < (v.size()); (i)++) {
    printf("%c", v[i]);
    if (i != v.size() - 1) {
      printf("+");
    }
  }
  return 0;
}
