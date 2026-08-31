#include <bits/stdc++.h>
using namespace std;
map<char, int> mp;
int main() {
  bool f = 1;
  int k, l;
  char ch[10000];
  scanf("%d%s", &k, ch);
  string s = ch, ans = "";
  l = s.size();
  for (int i = 0; i < l; i++) mp[s[i]]++;
  for (auto x : mp) {
    if (x.second % k != 0) f = 0;
    for (int i = 0; i < x.second / k; i++) ans += x.first;
  }
  if (!f)
    printf("-1");
  else
    for (int i = 0; i < k; i++) printf("%s", ans.c_str());
  printf("\n");
  return 0;
}
