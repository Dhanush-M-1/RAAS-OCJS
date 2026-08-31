#include <bits/stdc++.h>
using namespace std;
int main() {
  char st[2000];
  gets(st);
  int add, sub, n;
  vector<int> toAdd, toSub;
  add = sub = 0;
  add++;
  for (int i = 0; st[i]; i++) {
    if (st[i] >= '0' && st[i] <= '9') {
      n = atoi(st + i);
      break;
    }
    if (st[i] == '+')
      add++;
    else if (st[i] == '-')
      sub++;
  }
  if (n * add - sub < n)
    puts("Impossible");
  else if (add - sub * n > n)
    puts("Impossible");
  else {
    puts("Possible");
    if (add == sub + 1) {
      printf("%d", n);
      for (int i = 1; st[i]; i++) {
        if (st[i] == '?')
          printf("1");
        else
          printf("%c", st[i]);
      }
      printf("\n");
    } else if (sub >= add) {
      printf("%d", n);
      add--;
      for (int i = 1; st[i]; i++) {
        if (st[i] == '?') {
          if (st[i - 2] == '-')
            printf("1");
          else if (st[i - 2] == '+') {
            printf("%d", sub / add);
            sub -= sub / add;
            add--;
          }
        } else
          printf("%c", st[i]);
      }
      printf("\n");
    } else {
      for (int i = 0; i < add; i++) toAdd.push_back(n * (sub + 1) / add);
      add = (n * (sub + 1)) % add;
      for (int i = 0; i < add; i++) toAdd[i]++;
      int curPos = 1;
      printf("%d", toAdd[0]);
      for (int i = 1; st[i]; i++) {
        if (st[i] == '?') {
          if (st[i - 2] == '-')
            printf("%d", n);
          else if (st[i - 2] == '+') {
            printf("%d", toAdd[curPos++]);
          }
        } else
          putchar(st[i]);
      }
      printf("\n");
    }
  }
  return 0;
}
