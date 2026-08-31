#include <bits/stdc++.h>
using namespace std;
const long long N = 1e5 + 5;
int32_t main() {
  string str;
  cin >> str;
  long long l = str.length();
  long long i;
  vector<long long> v;
  for (i = 0; i < l; i = i + 2) v.push_back(str[i]);
  sort(v.begin(), v.end());
  for (i = 0; i < v.size() - 1; i++) {
    cout << v[i] - 48 << "+";
  }
  cout << v[v.size() - 1] - 48;
  return 0;
}
