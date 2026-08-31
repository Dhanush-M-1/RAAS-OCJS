#include <bits/stdc++.h>
using namespace std;
int main(int argc, char **argv) {
  int n;
  cin >> n;
  string s;
  cin >> s;
  int in = std::count(s.begin(), s.end(), 'I');
  int ans = 0;
  if (in <= 1) {
    int all = std::count(s.begin(), s.end(), 'A');
    if (in == 0)
      ans = all;
    else
      ans = 1;
  }
  cout << ans;
  return 0;
}
