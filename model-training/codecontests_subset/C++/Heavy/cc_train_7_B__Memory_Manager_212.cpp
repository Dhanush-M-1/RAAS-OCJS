#include <bits/stdc++.h>
using namespace std;
int g_identify = 1;
char g_mem[100];
int op_num = 0;
int mem_sum = 0;
void print() {
  for (int i = 0; i < mem_sum; i++) {
    cout << (int)g_mem[i] << " ";
  }
  cout << endl;
}
void add() {
  int len = -1;
  cin >> len;
  bool flag = false;
  int index = 0;
  int i = 0;
  for (; i < mem_sum - len + 1; i++) {
    int j = i;
    for (; j < i + len; j++) {
      if (g_mem[j] != 0) {
        flag = false;
        break;
      }
    }
    if (j == i + len) {
      flag = true;
      index = g_identify++;
      for (int k = i; k < i + len; k++) {
        g_mem[k] = index;
      }
      break;
    }
  }
  if (flag)
    cout << index << endl;
  else
    cout << "NULL" << endl;
  return;
}
void erase() {
  int index = -1;
  cin >> index;
  bool flag = false;
  if (index == 0) {
    cout << "ILLEGAL_ERASE_ARGUMENT" << endl;
    return;
  }
  for (int i = 0; i < mem_sum; i++) {
    if (g_mem[i] == index) {
      g_mem[i] = 0;
      flag = true;
    }
  }
  if (flag == false) cout << "ILLEGAL_ERASE_ARGUMENT" << endl;
}
void defragment() {
  int i = 0;
  int j = 0;
  int k = 0;
  for (k = 0; k != mem_sum; k++) {
    if (g_mem[k] == 0) {
      i = k;
      break;
    }
  }
  if (k == mem_sum) return;
  for (j = i + 1; j < mem_sum; j++) {
    if (g_mem[j] != 0) {
      g_mem[i] = g_mem[j];
      g_mem[j] = 0;
      i++;
    }
  }
}
int main() {
  memset(g_mem, 0, 100);
  cin >> op_num >> mem_sum;
  string str;
  for (int i = 0; i < op_num; i++) {
    cin >> str;
    if (str == "alloc")
      add();
    else if (str == "erase")
      erase();
    else if (str == "defragment")
      defragment();
  }
}
