#include <bits/stdc++.h>
const int N = 100;
using namespace std;
map<char, int> mp;
int main() {
  ios::sync_with_stdio(false);
  int t;
  cin >> t;
  while (t--) {
    char ch;
    cin >> ch;
    mp[ch]++;
  }
  if (mp['I'] == 1) {
    cout << 1 << endl;
  } else if (mp['I'] >= 2) {
    cout << 0 << endl;
  } else {
    cout << mp['A'] << endl;
  }
  return 0;
}
