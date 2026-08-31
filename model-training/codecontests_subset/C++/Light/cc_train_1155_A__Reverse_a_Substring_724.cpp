#include <bits/stdc++.h>
using namespace std;
int main() {
  string str;
  long long mxchar = 0, n, j;
  cin >> n;
  cin >> str;
  for (long long i = 0; i < str.size(); i++) {
    if (mxchar > str[i] - 'a') {
      cout << "YES\n";
      cout << j + 1 << " " << i + 1 << endl;
      return 0;
    }
    long long tt = str[i] - 'a';
    if (mxchar < tt) mxchar = tt, j = i;
  }
  cout << "NO\n";
  return 0;
}
