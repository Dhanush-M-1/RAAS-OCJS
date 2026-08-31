#include <bits/stdc++.h>
using namespace std;
void io() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  cout.precision(15);
}
string str[104];
int main(int argc, char* argv[]) {
  io();
  string s;
  cin >> s;
  int n;
  cin >> n;
  for (int i = 1; i <= n; i++) {
    cin >> str[i];
  }
  for (int i = 1; i <= n; i++) {
    if (str[i] == s) {
      cout << "YES\n";
      return 0;
    }
    for (int j = 1; j <= n; j++) {
      string ss = "";
      ss.push_back(str[i][1]);
      ss.push_back(str[j][0]);
      if (ss == s) {
        cout << "YES\n";
        return 0;
      }
    }
  }
  cout << "NO\n";
  return 0;
}
