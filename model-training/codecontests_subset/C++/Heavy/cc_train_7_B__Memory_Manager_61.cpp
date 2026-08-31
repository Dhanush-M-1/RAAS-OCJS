#include <bits/stdc++.h>
using namespace std;
void swap(int &a, int &b) {
  int temp;
  temp = a;
  a = b;
  b = temp;
  return;
}
int main() {
  int i, j, k;
  int N, M, T;
  int SIZE;
  string op;
  int reqsize;
  int reqid;
  int id = 1;
  int SP = 1;
  int mem[101];
  memset(mem, 0, sizeof(mem));
  int remain = 0;
  bool got = 0;
  map<int, pair<int, int> > MAP;
  map<int, pair<int, int> >::iterator it;
  int total_erase = 0;
  scanf("%d %d", &N, &SIZE);
  for (T = 0; T < N; T++) {
    remain = SIZE;
    cin >> op;
    got = 0;
    if (op.compare("alloc") == 0) {
      cin >> reqsize;
      for (i = 0; i < SIZE - reqsize + 1; i++) {
        for (j = i; j < reqsize + i; j++)
          if (mem[j] != 0) break;
        if (j == reqsize + i) {
          got = 1;
          for (j = i; j < reqsize + i; j++) mem[j] = id;
          MAP[id++] = make_pair(i, reqsize);
          break;
        }
      }
      if (!got) {
        printf("NULL\n");
      } else {
        printf("%d\n", id - 1);
      }
    } else if (op.compare("erase") == 0) {
      cin >> reqid;
      bool no = 1;
      for (i = 0; i < SIZE; i++)
        if (reqid == mem[i]) {
          no = 0;
          int temp = mem[i];
          for (j = i; mem[j] == temp; j++) mem[j] = 0;
          break;
        }
      if (no || reqid == 0) printf("ILLEGAL_ERASE_ARGUMENT\n");
    } else {
      int front;
      for (i = 0; i < SIZE; i++) {
        if (mem[i] == 0) {
          for (j = i; j < SIZE; j++)
            if (mem[j]) {
              swap(mem[i], mem[j]);
              break;
            }
        }
      }
    }
  }
  return 0;
}
