#include <bits/stdc++.h>
using namespace std;
vector<long long> vec;
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  string s1, s2;
  int n;
  cin >> s1 >> s2;
  cin >> n;
  string s3, s4;
  cout << s1 << " " << s2 << endl;
  cin >> s3 >> s4;
  if (s1 == s3)
    s1 = s4;
  else if (s3 == s2)
    s2 = s4;
  cout << s1 << " " << s2 << endl;
  for (int i = 0; i < n - 1; i++) {
    cin >> s3 >> s4;
    if (s1 == s3)
      s1 = s4;
    else if (s3 == s2)
      s2 = s4;
    cout << s1 << " " << s2 << endl;
  }
  return 0;
}
