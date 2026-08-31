#include <bits/stdc++.h>
using namespace std;
using lint = long long int;

int main() {
  lint N;
  cin >> N;

  map<string, lint> mp;
  while(N--) {
    string s;
    cin >> s;
    mp[s]++;
  }

  for(auto s : {"AC", "WA", "TLE", "RE"}) {
    cout << s << " x " << mp[s] << endl;
  }
}