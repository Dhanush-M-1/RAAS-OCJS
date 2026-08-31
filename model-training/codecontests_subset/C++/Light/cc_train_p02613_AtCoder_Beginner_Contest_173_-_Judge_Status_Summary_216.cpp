#include <bits/stdc++.h>
using namespace std;

int n;
string s;
map<string, int> m;

int main() {
  cin >> n;
  while(n--) {
    cin >> s;
    m[s]++;
  }
  for(auto str : {"AC", "WA", "TLE", "RE"})
    cout << str << " x " << m[str] << endl;
  return 0;
}