#include <bits/stdc++.h>
using namespace std;
int main() {
  long long n;
  cin >> n;
  string s;
  cin >> s;
  for (int i = 0; i < s.size() - 1; i++) {
    if (s[i + 1] < s[i]) {
      cout << "YES" << endl;
      cout << i + 1 << " " << i + 1 + 1 << endl;
      exit(0);
    }
  }
  cout << "NO" << endl;
}
