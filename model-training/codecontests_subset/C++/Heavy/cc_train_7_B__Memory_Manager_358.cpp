#include <bits/stdc++.h>
using namespace std;
const long long N = 105;
long long mem[N];
int main() {
  ios_base::sync_with_stdio(0), cin.tie(0), cout.tie(0);
  long long t, m;
  cin >> t >> m;
  long long id = 1;
  while (t--) {
    string tp;
    cin >> tp;
    if (tp == "alloc") {
      long long sz;
      cin >> sz;
      bool f = 0;
      for (long long i = 0; i < m && i + sz - 1 < m; i++) {
        bool good = 1;
        for (long long j = i; j < i + sz; j++) good &= mem[j] == 0;
        if (good) {
          for (long long j = i; j < i + sz; j++) mem[j] = id;
          cout << id++ << '\n';
          f = 1;
          break;
        }
      }
      if (!f) cout << "NULL\n";
    } else if (tp == "erase") {
      long long v;
      cin >> v;
      bool f = 0;
      for (long long i = 0; i < m; i++)
        if (mem[i] == v) mem[i] = 0, f = 1;
      if (!f || v == 0) cout << "ILLEGAL_ERASE_ARGUMENT\n";
    } else if (tp == "defragment") {
      vector<long long> v;
      for (long long i = 0; i < m; i++)
        if (mem[i] != 0) v.push_back(mem[i]);
      memset(mem, 0, sizeof mem);
      for (long long i = 0; i < v.size(); i++) mem[i] = v[i];
    }
  }
  return 0;
}
