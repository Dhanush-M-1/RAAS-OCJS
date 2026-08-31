#include <bits/stdc++.h>
using namespace std;
string s;
int n, d;
int main() {
  cin >> s >> n;
  d = s.size();
  for (int i = 0; i < d; i++) {
    if (s[i] <= 'Z') s[i] += 32;
    if (s[i] < 'a' + n) s[i] -= 32;
  }
  cout << s;
  return 0;
}
