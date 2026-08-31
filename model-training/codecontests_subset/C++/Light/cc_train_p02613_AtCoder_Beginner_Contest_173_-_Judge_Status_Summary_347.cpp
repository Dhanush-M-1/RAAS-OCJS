#include<bits/stdc++.h>
using namespace std;
int main() {
  map<string, int> m;
  vector<string> v{"AC", "WA", "TLE", "RE"};
  int N; cin >> N;
  while (N--) {
    string s; cin >> s; m[s]++;
  }
  for (auto s : v) {
    cout << s << " x " << m[s] << endl;
  }
}
  
    