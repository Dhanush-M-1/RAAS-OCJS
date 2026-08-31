#include <bits/stdc++.h>
using namespace std;
string s;
vector<int> a;
int main() {
  cin >> s;
  for (int i = 0; i < s.size(); i += 2) a.push_back(s[i] - '0');
  sort(a.begin(), a.end());
  for (int i = (0); i < (a.size()); ++i) {
    if (i) printf("+");
    printf("%d", a[i]);
  }
  printf("\n");
  return 0;
}
