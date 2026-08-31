#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  string s1, s2, s3, s4;
  cin >> s1 >> s2;
  cout << s1 << " " << s2 << '\n';
  long long int n;
  cin >> n;
  while (n--) {
    cin >> s3 >> s4;
    if (s3 == s1) {
      cout << s4 << " " << s2 << '\n';
      s1 = s4;
    } else {
      cout << s1 << " " << s4 << '\n';
      s2 = s4;
    }
  }
  return 0;
}
