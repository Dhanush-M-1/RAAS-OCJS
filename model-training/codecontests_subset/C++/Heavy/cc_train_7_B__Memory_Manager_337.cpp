#include <bits/stdc++.h>
using namespace std;
long long int mem[101] = {0};
long long int numbering = 0;
long long int t;
long long int n;
long long int length(long long int value, long long int index) {
  long long int l;
  for (l = 0; l + index < n && mem[index + l] == value; l++)
    ;
  return l;
}
long long int Alloc(long long int size) {
  for (long long int i = 0; i < n; i++)
    if (mem[i] == 0) {
      long long int cnt = length(0, i);
      if (cnt >= size) {
        numbering++;
        for (long long int j = i; j < i + size && j < n; j++)
          mem[j] = numbering;
        return numbering;
      } else
        i += cnt;
    }
  return -1;
}
long long int erase(long long int name) {
  if (name <= 0) return -1;
  long long int ILL = true;
  for (long long int i = 0; i < n; i++)
    if (mem[i] == name) {
      mem[i] = 0;
      ILL = false;
    }
  if (ILL) return -1;
  return 1;
}
int main() {
  cin >> t >> n;
  for (long long int c = 0; c < t; c++) {
    char cmd[10];
    cin >> cmd;
    if (!strcmp(cmd, "defragment")) {
      int temp[101] = {0};
      int s = 0;
      for (int i = 0; i < n; i++) {
        if (mem[i] != 0) temp[s++] = mem[i];
      }
      for (int i = 0; i < n; i++) mem[i] = temp[i];
    } else {
      long long int temp;
      cin >> temp;
      if (!strcmp(cmd, "alloc")) {
        long long int res = Alloc(temp);
        if (res < 0)
          cout << "NULL" << endl;
        else
          cout << res << endl;
      } else if (!strcmp(cmd, "erase")) {
        long long int res = erase(temp);
        if (res < 0) cout << "ILLEGAL_ERASE_ARGUMENT" << endl;
      }
    }
  }
  return 0;
}
