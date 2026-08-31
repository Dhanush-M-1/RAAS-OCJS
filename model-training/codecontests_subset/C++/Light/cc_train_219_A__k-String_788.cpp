#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  string s;
  while (cin >> n >> s) {
    int mc[30];
    memset(mc, 0, sizeof mc);
    for (int i = 0; i < s.size(); i++) mc[s[i] - 'a']++;
    bool can = true;
    int len = s.size();
    for (int i = 0; i < s.size(); i++) can &= (mc[s[i] - 'a'] % n == 0);
    if (!can)
      printf("-1\n");
    else {
      string aux;
      for (int i = 0; i < 30; i++)
        if (mc[i])
          for (int j = 0; j < mc[i] / n; j++) aux += (i + 'a');
      for (int i = 0; i < n; i++) cout << aux;
      cout << endl;
    }
  }
  return 0;
}
