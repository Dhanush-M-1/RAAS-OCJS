#include <bits/stdc++.h>
using namespace std;
long long a, b, c, cnt = 0, ans = 0, rem = 0;
string s, s1, s2, s3, s4;
deque<char> d, d1, d2;
vector<long long> v, v1, v2, v3;
int main() {
  cin >> s;
  for (int i = 0; i < s.size(); i++) {
    if (i % 2 == 0) {
      d.push_back(s[i]);
    }
  }
  sort(d.begin(), d.end());
  for (int i = 0; i < d.size(); i++) {
    if (i != d.size() - 1) {
      cout << d[i] << "+";
    } else {
      cout << d[i];
    }
  }
}
