#include <bits/stdc++.h>
using namespace std;

int main() {
  int n;
  cin >> n;
  map<string, int> m;
  string s;
  for (int i = 0; i < n; i++) {
    cin >> s;
    m[s] += 1;
  }

  vector<string> v = {"AC", "WA", "TLE", "RE"};
  for (auto i : v) {
    cout << i << " x " << m[i] << endl;
  }

  return 0;
}
