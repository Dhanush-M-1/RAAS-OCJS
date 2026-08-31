#include <bits/stdc++.h>
using namespace std;
double const pi = 3.1415926536;
void FAST() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
}
void TXT() {
  freopen("input.txt", "r", stdin);
  freopen("output.txt", "w", stdout);
}
int main() {
  FAST();
  string s;
  cin >> s;
  int n;
  cin >> n;
  for (int i = 0; i < s.size(); i++) {
    if (s[i] >= 'A' && s[i] <= 'Z') s[i] += 32;
    if (s[i] - n < 'a') {
      if (s[i] >= 'a' && s[i] <= 'z') s[i] -= 32;
    }
  }
  cout << s;
  return 0;
}
