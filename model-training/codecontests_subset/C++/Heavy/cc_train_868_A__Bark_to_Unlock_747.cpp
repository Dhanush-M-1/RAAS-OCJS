#include <bits/stdc++.h>
using namespace std;
using INT = long long;
const int NN = 111;
string tar;
string s[NN];
int n;
void dfs(int len) {
  if (!len) {
    for (int i = 1; i <= n; i++) {
      for (int j = 0; j < s[i].length(); j++) {
        int f = 1;
        for (int k = j; k < s[i].length(); k++) {
          if (k - j == tar.length()) {
            puts("YES");
            exit(0);
          }
          if (tar[k - j] != s[i][k]) {
            f = 0;
            break;
          }
        }
        if (f) dfs(s[i].length() - j);
      }
    }
    return;
  }
  for (int i = 1; i <= n; i++) {
    int j = 0;
    for (; j < s[i].length(); j++) {
      if (tar[len + j] != s[i][j]) break;
    }
    if (len + j == tar.length()) {
      puts("YES");
      exit(0);
    }
    if (j == s[i].length()) dfs(len + j);
  }
}
int main() {
  cin >> tar;
  cin >> n;
  for (int i = 1; i <= n; i++) cin >> s[i];
  dfs(0);
  puts("NO");
}
