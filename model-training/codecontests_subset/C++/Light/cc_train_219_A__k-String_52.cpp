#include <bits/stdc++.h>
using namespace std;
int main() {
  map<char, int> m;
  int k, n;
  string str, result = "";
  cin >> k;
  cin >> str;
  n = str.size();
  for (int i = 0; i < n; i++) m[str[i]]++;
  for (auto it = m.begin(); it != m.end(); it++) {
    if (it->second % k != 0) {
      cout << -1 << endl;
      return 0;
    }
    int x = it->second / k;
    while (x--) {
      result += it->first;
    }
  }
  for (int i = 0; i < k; i++) {
    cout << result;
  }
  cout << endl;
}
