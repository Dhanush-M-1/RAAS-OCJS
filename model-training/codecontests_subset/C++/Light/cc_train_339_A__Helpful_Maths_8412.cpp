#include <bits/stdc++.h>
using namespace std;
int main() {
  string s;
  cin >> s;
  vector<int> n;
  for (size_t i = 0; i < s.size(); i += 2) {
    n.push_back((int)(s[i]) - 48);
  }
  for (size_t i = 0; i < n.size() - 1; i++) {
    for (size_t j = 0; j < n.size() - i - 1; j++) {
      if (n[j] > n[j + 1]) {
        int temp = n[j];
        n[j] = n[j + 1];
        n[j + 1] = temp;
      }
    }
  }
  cout << n[0];
  for (size_t i = 1; i < n.size(); i++) {
    cout << "+" << n[i];
  }
  return 0;
}
