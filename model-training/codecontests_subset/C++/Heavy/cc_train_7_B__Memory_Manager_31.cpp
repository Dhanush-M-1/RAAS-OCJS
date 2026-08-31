#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  int n, m;
  cin >> n >> m;
  set<pair<pair<int, int>, int> > mem;
  int last_id = 0;
  for (int i = 0; i < n; i++) {
    string op;
    cin >> op;
    if (op[0] == 'd') {
      set<pair<pair<int, int>, int> > mem2;
      int prv = 0;
      while (((int)(mem).size())) {
        auto cur = *mem.begin();
        mem.erase(mem.begin());
        int diff = cur.first.first - prv;
        cur.first.first -= diff;
        cur.first.second -= diff;
        mem2.insert(cur);
        prv = cur.first.second;
      }
      mem.swap(mem2);
    } else if (op == "erase") {
      int id;
      cin >> id;
      bool found = false;
      for (auto memb : mem)
        if (memb.second == id) {
          mem.erase(memb);
          found = true;
          break;
        }
      if (!found) cout << "ILLEGAL_ERASE_ARGUMENT" << '\n';
    } else {
      int len;
      cin >> len;
      auto it = mem.begin();
      bool found = false;
      int prv = 0;
      while (!found and it != mem.end()) {
        if (prv + len <= it->first.first) {
          last_id++;
          mem.insert(make_pair(make_pair(prv, prv + len), last_id));
          cout << last_id << '\n';
          found = true;
        } else
          prv = it->first.second;
        it++;
      }
      if (!found and prv + len <= m) {
        last_id++;
        mem.insert(make_pair(make_pair(prv, prv + len), last_id));
        cout << last_id << '\n';
        found = true;
      }
      if (!found) cout << "NULL\n";
    }
  }
  return 0;
}
