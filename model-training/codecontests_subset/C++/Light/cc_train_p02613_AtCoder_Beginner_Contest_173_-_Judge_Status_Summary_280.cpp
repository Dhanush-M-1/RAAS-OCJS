#include <bits/stdc++.h>
using namespace std;

int main() {
  int n;
  cin >> n;
  
  map<string, int> cut;
  for (int i = 0; i < n; i++) {
    string s;
    cin >> s;
    cut[s]++;
  }
  
  for (string s : {"AC", "WA", "TLE", "RE"}) {
    cout << s << " x " << cut[s] << endl;
  }
  return 0;
}