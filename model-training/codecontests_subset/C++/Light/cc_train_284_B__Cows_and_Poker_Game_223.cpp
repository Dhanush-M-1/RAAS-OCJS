#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  string s;
  cin >> n >> s;
  int countf = 0, counta = 0, counti = 0, count = 0;
  for (int i = 0; i < n; i++) {
    if (s[i] == 'A') counta++;
    if (s[i] == 'I') counti++;
    if (s[i] == 'F') countf++;
  }
  count = n - countf;
  if (counti > 0) count = count - counta;
  if (counti > 1) count = count - counti;
  cout << count << endl;
  return 0;
}
