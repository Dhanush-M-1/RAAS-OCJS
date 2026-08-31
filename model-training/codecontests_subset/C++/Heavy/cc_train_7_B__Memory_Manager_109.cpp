#include <bits/stdc++.h>
using namespace std;
int vmem[101];
int NM;
int cid;
string FRAG = "defragment";
string ALLOC = "alloc";
string ERASE = "erase";
int alloc(int space) {
  int first = -1, i;
  for (i = 0; i < NM; i++) {
    if (vmem[i] == -1) continue;
    if (i - first - 1 < space) {
      first = i;
      continue;
    } else {
      ++cid;
      for (int j = first + 1; j < first + 1 + space; j++) vmem[j] = cid;
      return cid;
    }
  }
  if (i - first - 1 >= space) {
    ++cid;
    for (int j = first + 1; j < first + 1 + space; j++) vmem[j] = cid;
    return cid;
  }
  return -1;
}
int erase(int id) {
  for (int i = 0; i < NM; i++) {
    if (vmem[i] == id) {
      while (i < NM && vmem[i] == id) {
        vmem[i] = -1;
        i++;
      }
      return id;
    }
  }
  return -1;
}
void defragment() {
  int vmem2[101];
  memset(vmem2, -1, sizeof(vmem2));
  int p = 0;
  for (int i = 0; i < NM; i++) {
    if (vmem[i] != -1) {
      vmem2[p++] = vmem[i];
    }
  }
  for (int i = 0; i < NM; i++) vmem[i] = vmem2[i];
  return;
}
int main() {
  cid = 0;
  int T;
  cin >> T >> NM;
  memset(vmem, -1, sizeof(vmem));
  while (T--) {
    string com = "";
    int num;
    cin >> com;
    if (com == FRAG) {
      defragment();
    } else {
      cin >> num;
      if (com == ALLOC) {
        int ret = alloc(num);
        if (ret == -1)
          cout << "NULL" << endl;
        else
          cout << ret << endl;
      } else {
        int ret = erase(num);
        if (ret == -1) cout << "ILLEGAL_ERASE_ARGUMENT" << endl;
      }
    }
  }
  return 0;
}
