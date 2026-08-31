#include <bits/stdc++.h>
using namespace std;

long long n;
map<string, int> mp;
string st[] = {"AC", "WA", "TLE", "RE"};

int main() {
  cin >> n;
  for (int i = 0; i < n; ++i) {
    string s;
    cin >> s;
    ++mp[s];
  }
  for (int i = 0; i < 4; ++i) cout << st[i] << " x " << mp[st[i]] << endl;
  return 0;
}