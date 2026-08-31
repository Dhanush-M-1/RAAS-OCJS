#include <bits/stdc++.h>
using namespace std;
int main() {
  string x;
  cin >> x;
  int n, i, j;
  cin >> n;
  string s[n], c;
  string p;
  for (int i = 0; i < n; i++) {
    cin >> s[i];
  }
  for (i = 0; i < n; i++)
    for (j = 0; j < n; j++) p += s[i] + s[j];
  if (p.find(x) != std::string::npos) {
    {
      cout << "YES";
      return 0;
    }
  }
  cout << "NO";
}
