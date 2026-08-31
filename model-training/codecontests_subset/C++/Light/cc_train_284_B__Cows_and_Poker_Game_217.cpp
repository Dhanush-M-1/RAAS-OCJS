#include <bits/stdc++.h>
using namespace std;
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  ;
  int t;
  cin >> t;
  string s;
  cin >> s;
  int countA = 0;
  int countI = 0;
  for (int i = 0; i < s.size(); i++) {
    if (s[i] == 'A') {
      countA++;
    } else if (s[i] == 'I') {
      countI++;
    }
  }
  if (countI == 0) {
    cout << countA << endl;
  } else {
    if (countI == 1) {
      cout << 1 << endl;
    } else {
      cout << 0 << endl;
    }
  }
}
