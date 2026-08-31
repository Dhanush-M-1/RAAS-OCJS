#include <bits/stdc++.h>
using namespace std;
int main() {
  int i, j, k, cnt, n;
  string s;
  cin >> n >> s;
  cnt = 0;
  for (i = 0; s[i]; i++) {
    if (s[i] == '8') cnt++;
  }
  k = n / 11;
  k = (k < cnt) ? k : cnt;
  cout << k << endl;
  return 0;
}
