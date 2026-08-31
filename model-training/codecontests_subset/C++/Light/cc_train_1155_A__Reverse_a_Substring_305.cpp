#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(false);
  long long n, k, c = 0;
  cin >> n;
  string s;
  cin >> s;
  for (long long i = 0; i < s.length() - 1; i++) {
    if (s[i + 1] < s[i]) {
      k = i;
      c = 1;
      break;
    }
  }
  if (c == 0)
    cout << "NO";
  else {
    cout << "YES" << endl;
    cout << k + 1 << " " << k + 2;
  }
  return 0;
}
