#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  string str1, str2, ans1, ans2;
  cin >> str1 >> str2;
  ans1 = str1;
  ans2 = str2;
  cout << ans1 << " " << ans2 << endl;
  cin >> n;
  while (n--) {
    cin >> str1 >> str2;
    if (str1 == ans1) {
      ans1 = str2;
    } else
      ans2 = str2;
    cout << ans1 << " " << ans2 << endl;
  }
  return 0;
}
