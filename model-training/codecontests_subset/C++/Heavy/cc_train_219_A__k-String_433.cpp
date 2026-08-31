#include <bits/stdc++.h>
using namespace std;
int gcd(int a, int b) {
  if (a == 0) return b;
  if (b == 0) return a;
  if (a == b) return a;
  if (a > b) return gcd(a - b, b);
  return gcd(a, b - a);
}
int k;
string s;
int main() {
  cin >> k;
  cin >> s;
  map<char, int> m;
  int ss = s.size();
  for (int i = 0; i < ss; i++) {
    m[s.at(i)]++;
  }
  vector<char> c;
  for (auto const& [key, val] : m) {
    if (val % k != 0) {
      cout << -1;
      return 0;
    }
    c.push_back(key);
  }
  int cs = c.size();
  int h;
  for (int z = 0; z < k; z++) {
    for (int i = 0; i < cs; i++) {
      h = m[c.at(i)] / k;
      for (int j = 0; j < h; j++) {
        cout << c.at(i);
      }
    }
  }
}
