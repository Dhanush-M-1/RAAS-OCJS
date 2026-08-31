#include <bits/stdc++.h>
using namespace std;
int n, ans;
string s;
int main() {
  scanf("%d", &n);
  cin >> s;
  for (int i = 0; i < s.size(); ++i)
    if (s[i] == '8') {
      ++ans;
    }
  if (s.size() / 11 < ans) {
    ans = s.size() / 11;
  }
  printf("%d", ans);
  return 0;
}
