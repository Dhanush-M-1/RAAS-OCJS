#include <bits/stdc++.h>
using namespace std;
int main() {
  string s1, s2, s3, s4;
  long long int n;
  cin >> s1 >> s2;
  cin >> n;
  for (long long int i = 0; i < n; i++) {
    cout << s1 << " " << s2 << endl;
    cin >> s3 >> s4;
    if (s1.compare(s3) == 0) {
      s1 = s4;
    } else {
      s2 = s4;
    }
  }
  cout << s1 << " " << s2 << endl;
  return 0;
}
