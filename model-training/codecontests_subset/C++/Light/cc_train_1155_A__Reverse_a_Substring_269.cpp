#include <bits/stdc++.h>
using namespace std;
int n;
int vect[20005];
int main() {
  cin >> n;
  string s;
  cin >> s;
  for (int i = 0; i < n - 1; i++)
    if (s[i] > s[i + 1]) {
      cout << "YES"
           << "\n";
      cout << i + 1 << " " << i + 2;
      return 0;
    }
  cout << "NO";
  return 0;
}
