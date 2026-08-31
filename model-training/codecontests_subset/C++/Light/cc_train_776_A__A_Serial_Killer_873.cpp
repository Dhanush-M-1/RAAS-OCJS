#include <bits/stdc++.h>
using namespace std;
int main(int argc, char const *argv[]) {
  ios::sync_with_stdio(0), cin.tie(0), cout.tie(0);
  ;
  string s1, s2;
  cin >> s1 >> s2;
  int n;
  cin >> n;
  cout << s1 << " " << s2 << "\n";
  for (int i = 1; i <= n; i++) {
    string a, b;
    cin >> a >> b;
    if (a == s1)
      s1 = b;
    else
      s2 = b;
    cout << s1 << " " << s2 << "\n";
  }
  return 0;
}
