#include <bits/stdc++.h>
using namespace std;
long long int fp(long long int n, long long int p) {
  if (p == 0) return 1;
  if (p == 1) return n;
  long long int res = fp(n, p / 2);
  res = ((res) * (res));
  if (p % 2) res = (res * n);
  return res;
}
int n, m, x, mem[105], block = 0;
map<int, pair<int, int>> mp;
int main() {
  ios::sync_with_stdio(0);
  ios_base::sync_with_stdio(0);
  cin.tie(0), cout.tie(0);
  ;
  string s;
  cin >> n >> m;
  for (int i = 0; i < n; i++) {
    cin >> s;
    if (s == "alloc") {
      cin >> x;
      bool f = 0;
      int idx = 0;
      for (int i = 0; i < m; i++) {
        if (mem[i] == 0) {
          int j = 0;
          for (; j < x && i < m; i++) {
            if (mem[i] == 0)
              j++;
            else
              break;
          }
          if (j == x) {
            f = 1;
            idx = i - x;
            break;
          }
        }
      }
      if (f) {
        block++;
        cout << block << '\n';
        mp[block] = {idx, x};
        for (int i = 0; i < x; i++) {
          mem[idx] = block;
          idx++;
        }
      } else {
        cout << "NULL" << '\n';
      }
    } else if (s == "erase") {
      cin >> x;
      if (mp.count(x)) {
        int idx = 0, aa = mp[x].second;
        for (int i = 0; i < m; i++) {
          if (mem[i] == x) {
            idx = i;
            break;
          }
        }
        for (int i = 0; i < aa; i++) {
          mem[idx] = 0;
          idx++;
        }
        mp.erase(x);
      } else {
        cout << "ILLEGAL_ERASE_ARGUMENT" << '\n';
      }
    } else {
      for (int i = 0, j = 0; i < m; i++) {
        if (mem[i]) {
          mem[j] = mem[i];
          if (i != j) mem[i] = 0;
          j++;
        }
      }
    }
  }
  return 0;
}
