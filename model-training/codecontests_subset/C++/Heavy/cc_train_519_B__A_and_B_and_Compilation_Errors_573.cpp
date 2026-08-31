#include <bits/stdc++.h>
using namespace std;
const int MAX = 133337;
struct hashNode {
  int numVal;
  int numCnt;
  int test;
  hashNode() : numVal(0), numCnt(0) {}
};
hashNode hashTable[MAX];
void insert(int x) {
  int pos = x % MAX;
  int i = 1;
  while (hashTable[pos].numVal != 0 && hashTable[pos].numVal != x) {
    pos += (i << 1) - 1;
    if (pos > MAX) pos -= MAX;
    i++;
  }
  if (hashTable[pos].numVal == 0) {
    hashTable[pos].numVal = x;
    hashTable[pos].numCnt = 1;
  } else
    hashTable[pos].numCnt++;
}
void check(int x) {
  int pos = x % MAX;
  int i = 1;
  while (hashTable[pos].numVal != 0 && hashTable[pos].numVal != x) {
    pos += (i << 1) - 1;
    if (pos > MAX) pos -= MAX;
    i++;
  }
  hashTable[pos].test--;
}
int main() {
  int n, i, j, a;
  scanf("%d", &n);
  for (i = 1; i <= n; i++) {
    scanf("%d", &a);
    insert(a);
  }
  for (i = 0; i <= MAX - 1; i++) hashTable[i].test = hashTable[i].numCnt;
  for (i = 1; i <= n - 1; i++) {
    scanf("%d", &a);
    check(a);
  }
  for (i = 0; i <= MAX - 1; i++) {
    if (hashTable[i].test) {
      cout << hashTable[i].numVal << ' ';
      hashTable[i].numCnt--;
    }
  }
  for (i = 0; i <= MAX - 1; i++) hashTable[i].test = hashTable[i].numCnt;
  for (i = 1; i <= n - 2; i++) {
    scanf("%d", &a);
    check(a);
  }
  for (i = 0; i <= MAX - 1; i++) {
    if (hashTable[i].test) {
      cout << hashTable[i].numVal << ' ';
      hashTable[i].numCnt--;
    }
  }
  return 0;
}
