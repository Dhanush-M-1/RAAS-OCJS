#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(false), cin.tie(0), cout.tie(0);
  int k;
  cin >> k;
  string s;
  cin >> s;
  unordered_map<char, int> freq;
  for (int i = 0; i < s.size(); i++) {
    freq[s[i]]++;
  }
  int flag = 0;
  for (auto x : freq) {
    if (x.second % k != 0) {
      flag = 1;
      break;
    }
  }
  if (flag == 1) {
    cout << -1;
    return 0;
  } else {
    int hehe = 0;
    while (hehe < s.size()) {
      for (auto x : freq) {
        for (int i = 0; i < x.second / k; i++) {
          cout << x.first;
          hehe++;
        }
      }
    }
    return 0;
  }
}
