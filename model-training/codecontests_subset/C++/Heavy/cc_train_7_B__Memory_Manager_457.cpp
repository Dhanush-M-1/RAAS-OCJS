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
int n, m, x, mem[105], block = 1;
map<int, int> mp;
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
      int idx = 0, tmp = 0;
      for (int i = 0; i < m; i++) {
        if (mem[i] == 0)
          tmp++;
        else
          tmp = 0;
        if (tmp == x) {
          f = 1;
          idx = i - x + 1;
          break;
        }
      }
      if (f) {
        mp[block] = x;
        for (int i = 0; i < x; i++, idx++) {
          mem[idx] = block;
        }
        cout << block << '\n';
        block++;
      } else
        cout << "NULL" << '\n';
    } else if (s == "erase") {
      cin >> x;
      if (mp.count(x)) {
        int idx = 0, aa = mp[x];
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
      vector<int> t;
      for (int i = 0; i < m; i++) {
        if (mem[i] != 0) {
          t.push_back(mem[i]);
          mem[i] = 0;
        }
      }
      for (int i = 0; i < int(t.size()); i++) {
        mem[i] = t[i];
      }
    }
  }
  return 0;
}
