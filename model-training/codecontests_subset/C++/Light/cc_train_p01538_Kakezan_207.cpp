#include <bits/stdc++.h>
using namespace std;

int q, r, ten, ma, cnt;

int main() {
  cin >> q;
  for(int a = 0; a < q; ++a) {
    map<int, bool> mp;
    cin >> r;
    cnt = 0;
    while(r >= 10) {
      ma = 0;
      ten = 10;
      while(r / ten > 0) {
        if(ma < (r / ten) * (r % ten)) ma = (r / ten) * (r % ten);
        ten *= 10;
      }
      if(mp.find(ma) != mp.end()) {
        cnt = -1;
        break;
      }
      mp[ma] = 1;
      r = ma;
      ++cnt;
    }
    cout << cnt << endl;
  }
  return 0;
}
