#include <bits/stdc++.h>
using namespace std;
int n;
string s;
int num[10];
int main() {
  cin >> n;
  cin >> s;
  int c = 0;
  for (int i = 0; i < n; i++) {
    num[s[i] - '0']++;
    if (s[i] != '8') c++;
  }
  int ans = 0;
  while (num[8] >= 0) {
    ans = max(ans, min(num[8], c / 10));
    num[8]--;
    c++;
  }
  cout << ans << endl;
  return 0;
}
