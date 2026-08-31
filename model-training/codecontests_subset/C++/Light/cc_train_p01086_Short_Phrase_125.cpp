#include <bits/stdc++.h>
using namespace std;

string s;
int n, ans;

int main() {
  int i, j;
  while(1) {
    cin >> n;
    if(n == 0) break;
    vector<int> v;
    for(i = 0; i < n; ++i) {
      cin >> s;
      v.push_back(s.size());
    }
    ans = 0;
    for(i = 0; i < n; ++i) {
      if(ans != 0) break;
      int now = 0, ch = 0;
      for(j = i; j < n; ++j) {
        now += v[j];
        if(now == 5 || now == 12 || now == 17 || now == 24 || now == 31) ++ch;
        if(now > 31) break;
      }
      if(ch == 5) ans = ++i;
    }
    cout << ans << endl;
  }
  return 0;
}
