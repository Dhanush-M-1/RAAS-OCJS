#include <bits/stdc++.h>
using namespace std;
const int MOD = (int)1e9 + 7;
const int N = (int)1e5;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  int n;
  cin >> n;
  multiset<int> st, st1, st2;
  map<int, int> mp, mp1;
  for (int i = 0; i < n; i++) {
    int x;
    cin >> x;
    mp[x]++;
  }
  for (int i = 0; i < n - 1; i++) {
    int x;
    cin >> x;
    mp[x]--;
    if (mp[x] == 0) {
      mp.erase(x);
    }
    mp1[x]++;
  }
  cout << mp.begin()->first << "\n";
  for (int i = 0; i < n - 2; i++) {
    int x;
    cin >> x;
    mp1[x]--;
    if (mp1[x] == 0) {
      mp1.erase(x);
    }
  }
  cout << mp1.begin()->first << "\n";
  return 0;
}
