#include <bits/stdc++.h>
using namespace std;
int main() {
  int k;
  cin >> k;
  string str;
  cin >> str;
  vector<int> freq(26);
  for (auto x : str) freq[x - 'a']++;
  string fin = "";
  for (int i = 0; i < 26; ++i) {
    if (freq[i] % k != 0) {
      cout << -1 << "\n";
      return 0;
    } else if (freq[i] != 0)
      fin += string(freq[i] / k, i + 'a');
  }
  for (int i = 0; i < k; ++i) cout << fin;
  cout << "\n";
}
