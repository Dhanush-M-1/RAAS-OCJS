#include <bits/stdc++.h>
using namespace std;
const int INF = (0u - 1) / 2;
typedef struct Node {
  Node *prior;
  int data;
  Node *next;
} LNode;
int positions[1005];
int path[1005];
LNode *man[1005];
void reset(int n) {
  for (int i = 0; i <= n; i++) {
    man[i] = new LNode;
    man[i]->data = i;
    man[i]->prior = man[i]->next = NULL;
  }
  for (int i = 0; i < 1005; i++) {
    path[i] = positions[i] = 0;
  }
}
void Delete(int n) {
  for (int i = 0; i <= n; i++) {
    delete man[i];
  }
}
void insert(int e1, int e2) {
  if (e2 == 0) return;
  man[e1]->next = man[e2];
  man[e2]->prior = man[e1];
}
void FindPath(int n, int &sum, int m, int &pOfm) {
  LNode *p;
  int len;
  bool flag = 0;
  for (int i = 1; i <= n; i++) {
    if (man[i]->prior == NULL) {
      p = man[i];
      len = 0;
      while (p != NULL) {
        len++;
        if (p->data == m) {
          flag = 1;
          pOfm = len;
        }
        p->prior = man[0];
        p = p->next;
      }
      if (flag) {
        pOfm = len - pOfm;
      }
      if (!flag) {
        sum++;
        path[sum] = len;
      }
      flag = false;
    }
  }
}
void showPath(int sum) {
  for (int i = 1; i <= sum; i++) cout << path[i] << ' ';
  cout << endl;
}
void ans(int sum, int lenOfp, int n) {
  positions[lenOfp + 1] = true;
  for (int i = 1; i <= sum; i++)
    for (int j = n; j >= 1; j--) {
      if (positions[j]) positions[j + path[i]] = true;
    }
  for (int i = 1; i <= n; i++)
    if (positions[i]) cout << i << endl;
}
int main() {
  int n, m;
  int e1, sum = 0, pOfm = 0;
  while (cin >> n >> m) {
    sum = 0;
    reset(n);
    for (int i = 1; i <= n; i++) {
      cin >> e1;
      insert(i, e1);
    }
    FindPath(n, sum, m, pOfm);
    ans(sum, pOfm, n);
    Delete(n);
  }
}
