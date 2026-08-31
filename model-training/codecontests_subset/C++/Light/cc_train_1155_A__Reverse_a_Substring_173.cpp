#include <bits/stdc++.h>
using namespace std;
int main() {
  long long n;
  string s;
  cin >> n >> s;
  long long i, j;
  char k = 000;
  for (i = 0; i < n; i++) {
    if (s[i] < k) {
      cout << "YES\n";
      cout << j + 1 << " " << i + 1;
      return 0;
    }
    k = max(s[i], k);
    if (s[i] == k) j = i;
  }
  cout << "NO";
}
