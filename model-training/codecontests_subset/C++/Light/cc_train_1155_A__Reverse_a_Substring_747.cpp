#include <bits/stdc++.h>
using namespace std;
bool cmp(char a, char b) { return a <= b; }
int main() {
  int n;
  cin >> n;
  string s;
  cin >> s;
  int i;
  for (i = 1; i < n; i++) {
    if (s[i] < s[i - 1]) {
      cout << "YES" << endl;
      cout << i << " " << i + 1 << endl;
      return 0;
    }
  }
  cout << "NO" << endl;
  return 0;
}
