#include <bits/stdc++.h>
using namespace std;

int n;

void solve(string s, char c) {
  if (s.size() == n) {
    cout << s << endl;
    return;
  }
  for (char i = 'a'; i <= c; i++) solve(s + i, (i == c ? c + 1 : c));
}

int main() {
  cin >> n;
  solve("", 'a');
  return 0;
}
