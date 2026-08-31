#include <bits/stdc++.h>
using namespace std;
int main() {
  int count = 0;
  int n;
  string s;
  cin >> n;
  cin >> s;
  for (int i = 0; i < n; ++i)
    if (s[i] == '8') ++count;
  printf("%d\n", min(n / 11, count));
}
