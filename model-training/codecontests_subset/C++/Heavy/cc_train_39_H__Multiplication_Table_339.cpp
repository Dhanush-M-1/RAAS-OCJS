#include <bits/stdc++.h>
#pragma comment(linker, "/stack:200000000")
#pragma GCC optimize("Ofast")
#pragma GCC target("sse,sse2,sse3,ssse3,sse4,popcnt,abm,mmx,avx,tune=native")
using namespace std;
void getNum(long long int x, long long int k, vector<long long int>& ans) {
  while (x > 0) {
    ans.push_back(x % k);
    x /= k;
  }
  reverse(ans.begin(), ans.end());
}
signed main() {
  long long int k;
  cin >> k;
  for (long long int i = 1; i < k; i++) {
    for (long long int j = 1; j < k; j++) {
      long long int num = i * j;
      vector<long long int> ans;
      getNum(num, k, ans);
      for (auto el : ans) cout << el;
      cout << " ";
    }
    cout << endl;
  }
  return 0;
}
