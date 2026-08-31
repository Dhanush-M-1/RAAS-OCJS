#include <bits/stdc++.h>
#pragma comment(linker, "/STACK:64000000")
using namespace std;
int gcd(int a, int b) {
  while (b) {
    a %= b;
    if (b > a) swap(a, b);
  }
  return a;
}
int main() {
  string s, ans;
  int k;
  cin >> k >> s;
  map<char, int> m;
  for (int i = 0; i < s.length(); i++) m[s[i]]++;
  for (map<char, int>::iterator it = m.begin(); it != m.end(); it++)
    if (it->second % k != 0) {
      cout << "-1";
      return 0;
    }
  for (int ki = 0; ki < k; ki++) {
    for (map<char, int>::iterator it = m.begin(); it != m.end(); it++)
      for (int i = 0; i < it->second / k; i++) cout << it->first;
  }
  return 0;
}
