#include <bits/stdc++.h>
using namespace std;
int main() {
  string s1, s2;
  char temp;
  int n;
  s2 = "";
  cin >> n;
  cin >> s1;
  s2 = s1;
  for (int i = 0; i < n - 1; ++i) {
    if (s2[i] > s2[i + 1]) {
      cout << "YES" << endl << i + 1 << " " << i + 2;
      return 0;
    }
  }
  cout << "NO";
}
