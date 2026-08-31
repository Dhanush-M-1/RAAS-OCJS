#include <bits/stdc++.h>
using namespace std;
string s;
int sz, cnt, ans;
int main() {
  cin >> sz;
  cin >> s;
  int a8 = (int)s.find("8");
  if (a8 == -1 || sz < 11) {
    cout << "0";
    return 0;
  }
  sort(s.begin(), s.end());
  for (int i = s.size() - 1; i >= 0; i--) {
    if (s[i] == '8') {
      while (s[i] == '8') {
        cnt++;
        i--;
      }
      break;
    }
  }
  while (sz >= 11 && cnt) {
    cnt--;
    sz -= 11;
    ans++;
  }
  cout << ans;
}
