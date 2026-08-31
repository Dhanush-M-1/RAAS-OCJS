#include <bits/stdc++.h>
using namespace std;
int main() {
  int n[3] = {0, 0, 0}, first = 0;
  string s;
  cin >> s;
  for (int i = 0; i < s.size(); i += 2) {
    ++n[s[i] - '1'];
  }
  if (n[0]) {
    cout << '1';
    ++first;
    --n[0];
  }
  if (n[1] && !first) {
    cout << '2';
    ++first;
    --n[1];
  }
  if (n[2] && !first) {
    cout << '3';
    --n[2];
  }
  for (int i = 0; i < 3; ++i) {
    for (int o = 0; o < n[i]; ++o) {
      cout << '+' << i + 1;
    }
  }
  cout << endl;
  return 0;
}
