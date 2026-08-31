#include <bits/stdc++.h>
using namespace std;
int main() {
  long long int n, i;
  string s;
  cin >> n >> s;
  for (i = 1; i < n; i++) {
    if (s[i] < s[i - 1]) {
      puts("YES");
      cout << i << " " << i + 1 << endl;
      return 0;
    }
  }
  puts("NO");
}
