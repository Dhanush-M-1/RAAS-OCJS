#include <bits/stdc++.h>
using namespace std;
int mem_size, next_block_ind{1};
int super_mem[128];
inline void exec_stupid_alloc() {
  int param;
  cin >> param;
  int end_ind, fmem_size{0};
  for (end_ind = 0; end_ind < mem_size; ++end_ind) {
    if (super_mem[end_ind] == 0) {
      fmem_size++;
      if (fmem_size == param) break;
    } else {
      fmem_size = 0;
    }
  }
  if (fmem_size == param) {
    int id = next_block_ind++;
    for (int i = end_ind - param + 1; i <= end_ind; ++i) {
      super_mem[i] = id;
    }
    cout << id << endl;
  } else {
    cout << "NULL" << endl;
  }
}
inline void exec_stupid_erase() {
  int param;
  cin >> param;
  if (param == 0) {
    cout << "ILLEGAL_ERASE_ARGUMENT" << endl;
    return;
  }
  bool not_found = true;
  for (int i = 0; i < mem_size; ++i) {
    if (super_mem[i] == param) {
      not_found = false;
      super_mem[i] = 0;
    }
  }
  if (not_found) {
    cout << "ILLEGAL_ERASE_ARGUMENT" << endl;
  }
}
inline void exec_stupid_defragment() {
  int j{0};
  for (int i = 0; i < mem_size; ++i) {
    if (super_mem[i] != 0) {
      super_mem[j] = super_mem[i];
      if (i != j) super_mem[i] = 0;
      j++;
    }
  }
}
int main() {
  int n;
  cin >> n >> mem_size;
  for (int i = 0; i < mem_size; ++i) super_mem[i] = 0;
  for (int i = 0; i < n; ++i) {
    string com;
    cin >> com;
    if (com == "alloc") {
      exec_stupid_alloc();
    } else if (com == "erase") {
      exec_stupid_erase();
    } else {
      exec_stupid_defragment();
    }
  }
  return 0;
}
