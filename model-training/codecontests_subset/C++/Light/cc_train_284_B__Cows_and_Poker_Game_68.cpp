#include <bits/stdc++.h>
using namespace std;
const int N = 200004;
int main() {
  int n;
  char s[N];
  map<char, int> mp;
  scanf("%d%s", &n, s);
  for (int i = 0; i < n; i++) mp[s[i]]++;
  if (mp.count('I') > 0) {
    if (mp['I'] >= 2)
      puts("0");
    else
      puts("1");
  } else
    cout << count(s, s + n, 'A');
  return 0;
}
