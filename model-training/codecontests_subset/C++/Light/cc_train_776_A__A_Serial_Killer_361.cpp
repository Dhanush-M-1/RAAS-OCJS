#include <bits/stdc++.h>
using namespace std;
int n;
string s1, s2;
int main() {
  cin.sync_with_stdio(false);
  cin >> s1 >> s2;
  cin >> n;
  cout << s1 << " " << s2 << endl;
  for (int i = (int)(0); i < (int)(n); i++) {
    string k, a;
    cin >> k >> a;
    if (s1 == k) {
      s1 = a;
    } else {
      s2 = a;
    }
    cout << s1 << " " << s2 << endl;
  }
  return 0;
}
