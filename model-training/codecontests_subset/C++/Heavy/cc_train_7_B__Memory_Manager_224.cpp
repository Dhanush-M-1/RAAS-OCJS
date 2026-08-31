#include <bits/stdc++.h>
using namespace std;
using LL = long long;
using ULL = unsigned long long;
using VI = vector<int>;
using VL = vector<LL>;
using PII = pair<int, int>;
using PLL = pair<LL, LL>;
void dout() { cerr << endl; }
template <typename Head, typename... Tail>
void dout(Head H, Tail... T) {
  cerr << H << ' ';
  dout(T...);
}
int main() {
  ios::sync_with_stdio(false);
  cin.tie(nullptr);
  int n, m;
  cin >> n >> m;
  VI was(m);
  vector<PII> p(m + n);
  int cur = 0;
  set<int> st;
  set<PII> setik;
  for (int i = 0; i < n; ++i) {
    string second;
    cin >> second;
    if (second == "alloc") {
      int x;
      cin >> x;
      bool ok = false;
      for (int j = 0; j < m; ++j) {
        if (j + x - 1 >= m) {
          break;
        }
        bool check = true;
        for (int it = j; it < j + x; ++it) {
          if (was[it]) {
            check = false;
            break;
          }
        }
        if (check) {
          ok = true;
          p[cur++] = make_pair(j, x);
          st.insert(cur);
          setik.emplace(j, cur);
          cout << cur << "\n";
          for (int it = j; it < j + x; ++it) {
            was[it] = 1;
          }
          break;
        }
      }
      if (!ok) {
        cout << "NULL\n";
      }
    }
    if (second == "erase") {
      int k;
      cin >> k;
      if (!st.count(k)) {
        cout << "ILLEGAL_ERASE_ARGUMENT \n";
        continue;
      }
      st.erase(k);
      auto iter = setik.find(make_pair(p[k - 1].first, k));
      assert(iter != setik.end());
      setik.erase(iter);
      --k;
      auto [j, x] = p[k];
      for (int it = j; it < j + x; ++it) {
        was[it] = 0;
      }
    }
    if (second == "defragment") {
      int last = 0, sim = 0;
      vector<PII> kek;
      for (auto [j, k] : setik) {
        p[k - 1].first = last;
        kek.emplace_back(last, k);
        last += p[k - 1].second;
      }
      setik.clear();
      for (auto p : kek) {
        setik.insert(p);
      }
      was.assign(m, 0);
      for (int it = 0; it < last; ++it) {
        was[it] = 1;
      }
    }
  }
  return 0;
}
