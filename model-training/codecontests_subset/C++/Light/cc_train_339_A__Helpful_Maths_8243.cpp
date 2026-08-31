#include <bits/stdc++.h>
using namespace std;
int main() {
  string s;
  int i, l, j;
  cin >> s;
  l = s.size();
  for (i = 0; i < l; i = i + 2) {
    for (j = 0; j < l - i - 2; j = j + 2) {
      if (s[j] > s[j + 2]) swap(s[j], s[j + 2]);
    }
  }
  cout << s;
}
