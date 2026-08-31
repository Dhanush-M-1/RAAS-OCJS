#include <bits/stdc++.h>
using namespace std;
string s;
int n;
bool b = true;
int i = 0;
int ans;
int main() {
  cin >> n;
  cin >> s;
  while (b && i < n - 1) {
    if (int(s[i]) > int(s[i + 1])) {
      b = false;
      ans = i + 1;
    }
    i++;
  }
  if (!b) {
    cout << "YES" << endl;
    cout << ans << " " << ans + 1;
  } else {
    cout << "NO";
  }
  return 0;
}
