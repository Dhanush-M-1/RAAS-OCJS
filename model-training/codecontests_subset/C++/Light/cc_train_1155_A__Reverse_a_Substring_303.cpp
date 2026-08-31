#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  cin >> n;
  string s;
  cin >> s;
  string t = s;
  sort(t.begin(), t.end());
  if (t == s) {
    return 0 * puts("NO");
  }
  puts("YES");
  for (int i = 0; i < s.size() - 1; i++) {
    if (s[i] > s[i + 1]) {
      swap(s[i], s[i + 1]);
      cout << i + 1 << " " << i + 2 << endl;
      return 0;
    }
  }
  return 0;
}
