#include <bits/stdc++.h>
using namespace std;
int n;
string f(int a) {
  string ans = "";
  while (a > 0) {
    char x = (a % n) + '0';
    ans += x;
    a /= n;
  }
  reverse(ans.begin(), ans.end());
  return ans;
}
int main() {
  cin >> n;
  for (int i = 1; i < n; i++) {
    for (int j = 1; j < n; j++) cout << f(i * j) << " ";
    cout << endl;
  }
  return 0;
}
