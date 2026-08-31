#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  long long n;
  cin >> n;
  string s;
  cin >> s;
  long long l, r;
  long long f = 0;
  for (long long i = 1; i < n; i++) {
    if (s[i] < s[i - 1]) {
      l = i;
      r = i + 1;
      f = 1;
      break;
    }
  }
  if (f == 0) {
    cout << "NO"
         << "\n";
  } else {
    cout << "YES\n";
    cout << l << " " << r << "\n";
  }
  return 0;
}
