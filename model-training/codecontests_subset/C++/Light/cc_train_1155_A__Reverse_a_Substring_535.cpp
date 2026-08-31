#include <bits/stdc++.h>
using namespace std;
int main() {
  iostream::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  int n;
  cin >> n;
  char c;
  char max_char;
  int max_pos = 0;
  cin >> max_char;
  for (int i = 0; i < n - 1; ++i) {
    cin >> c;
    if (c < max_char) {
      cout << "YES"
           << "\n";
      cout << max_pos + 1 << " ";
      cout << i + 2 << "\n";
      return 0;
    } else {
      max_char = c;
      max_pos = i + 1;
    }
  }
  cout << "NO"
       << "\n";
  return 0;
}
