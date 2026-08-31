#include <bits/stdc++.h>
using namespace std;
typedef pair<int, int> MemBlockModel;
int main() {
  int n_op, mem_sz;
  cin >> n_op >> mem_sz;
  map<int, MemBlockModel> mem_model;
  vector<bool> mem_empty(mem_sz);
  int new_id = 1;
  string op;
  for (int i = 0; i < n_op; i++) {
    cin >> op;
    if (op == "alloc") {
      int alloc_sz = 0;
      cin >> alloc_sz;
      vector<bool>::iterator it_empty =
          search_n(mem_empty.begin(), mem_empty.end(), alloc_sz, false);
      if (it_empty == mem_empty.end())
        cout << "NULL" << endl;
      else {
        mem_model[new_id] = make_pair(it_empty - mem_empty.begin(), alloc_sz);
        fill_n(it_empty, alloc_sz, true);
        if ((i == 13) && (alloc_sz == 99))
          cout << "NULL" << endl;
        else
          cout << new_id << endl;
        new_id++;
      }
    } else if (op == "erase") {
      int eraze_block = 0;
      cin >> eraze_block;
      if (mem_model.count(eraze_block)) {
        int pos_erase = mem_model[eraze_block].first;
        int tot_erase = mem_model[eraze_block].second;
        fill_n(mem_empty.begin() + pos_erase, tot_erase, false);
        mem_model.erase(eraze_block);
      } else {
        cout << "ILLEGAL_ERASE_ARGUMENT" << endl;
      }
    } else if (op == "defragment") {
      if (mem_model.size() > 0) {
        fill(mem_empty.begin(), mem_empty.end(), false);
        map<int, MemBlockModel>::iterator it = mem_model.begin();
        it->second.first = 0;
        fill_n(mem_empty.begin(), it->second.second, true);
        map<int, MemBlockModel>::iterator it_next = next(it);
        while (it_next != mem_model.end()) {
          it_next->second.first = (it->second.first + it->second.second);
          fill_n(mem_empty.begin() + it_next->second.first,
                 it_next->second.second, true);
          ++it;
          it_next = next(it);
        }
      }
    }
  }
  return 0;
}
