#include <bits/stdc++.h>
using namespace std;
int main() {
  ios::sync_with_stdio(false);
  string s;
  long long a[1005];
  long long count = 0;
  cin >> s;
  for (long long i = 0; i < s.size(); i += 2) {
    a[count++] = s[i] - '0';
  }
  sort(a, a + count);
  for (long long i = 0; i < count; i++) {
    cout << a[i];
    if (i != count - 1) {
      cout << "+";
    }
  }
  cout << endl;
}
