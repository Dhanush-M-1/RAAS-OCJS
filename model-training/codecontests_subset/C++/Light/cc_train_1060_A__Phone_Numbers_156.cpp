#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  cin >> n;
  string str;
  cin >> str;
  int temp = 0;
  for (int i = 0; i < n; i++) {
    if (str[i] == '8') temp++;
  }
  int ans = min(n / 11, temp);
  cout << ans;
}
