#include <bits/stdc++.h>
using namespace std;
unsigned long long int freq[10000001];
int main() {
  string s1;
  cin >> s1;
  unsigned long long int n;
  cin >> n;
  unsigned long long int flag1, flag2;
  flag1 = flag2 = 0;
  unsigned long long int flag = 0;
  while (n--) {
    string s2;
    cin >> s2;
    if (s2 == s1) flag = 1;
    if (s2[1] == s1[0]) flag1 = 1;
    if (s2[0] == s1[1]) flag2 = 1;
  }
  if (flag || (flag1 && flag2))
    cout << "YES\n";
  else
    cout << "NO\n";
  return 0;
}
