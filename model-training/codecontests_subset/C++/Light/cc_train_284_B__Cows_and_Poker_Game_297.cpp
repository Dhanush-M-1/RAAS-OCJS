#include <bits/stdc++.h>
using namespace std;
int main() {
  string s;
  int n;
  cin >> n >> s;
  vector<long long> a(3, 0);
  for (int i = 0; i < s.size(); i++) {
    if (s[i] == 'A') a[0]++;
    if (s[i] == 'I') a[1]++;
    if (s[i] == 'F') a[2]++;
  }
  long long count = 0;
  for (int i = 0; i < s.size(); i++) {
    if (s[i] == 'A' && a[1] == 0) count++;
    if (s[i] == 'I' && a[1] == 1) count++;
  }
  cout << count;
  return 0;
}
