#include <bits/stdc++.h>
using namespace std;
long long int mod = 1e9 + 7;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  long long int n;
  cin >> n;
  string s;
  cin >> s;
  long long int a = 0;
  long long int b = 0;
  long long int c = 0;
  for (long long int i = 0; i < s.size(); ++i) {
    if (s[i] == 'A') {
      a++;
    }
    if (s[i] == 'F') {
      b++;
    }
    if (s[i] == 'I') {
      c++;
    }
  }
  if (c == 0) {
    cout << a << "\n";
    ;
    return 0;
  }
  if (c == 1) {
    cout << 1 << "\n";
    ;
    return 0;
  }
  cout << 0 << "\n";
  ;
}
