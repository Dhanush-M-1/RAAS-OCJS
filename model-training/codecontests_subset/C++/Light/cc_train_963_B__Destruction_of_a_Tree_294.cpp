#include <bits/stdc++.h>
using namespace std;
const int SIZE = 200001;
struct tree {
  int father;
  vector<int> sons;
  bool deleted;
  int siz;
};
tree tr[SIZE];
void write(int x) {
  int y;
  for (int i = 0; i < tr[x].sons.size(); i++) {
    y = tr[x].sons[i];
    if (!tr[y].deleted && y != tr[x].father) {
      printf("%d\n", y);
      tr[y].deleted = true;
      write(y);
    }
  }
}
void alg() {
  int x, y;
  queue<int> q;
  stack<int> Q;
  q.push(1);
  Q.push(1);
  while (!q.empty()) {
    x = q.front();
    for (int i = 0; i < tr[x].sons.size(); i++) {
      y = tr[x].sons[i];
      if (tr[x].father != y) {
        tr[y].father = x;
        q.push(y);
        Q.push(y);
      }
    }
    q.pop();
  }
  while (!Q.empty()) {
    x = Q.top();
    if ((tr[x].siz & 1) == 0) {
      printf("%d\n", x);
      tr[x].deleted = true;
      tr[tr[x].father].siz--;
      write(x);
    }
    Q.pop();
  }
}
int main() {
  int n, a;
  scanf("%d", &n);
  for (int i = 1; i <= n; i++) {
    scanf("%d", &a);
    if (a != 0) {
      tr[i].sons.push_back(a);
      tr[a].sons.push_back(i);
    }
  }
  for (int i = 1; i <= n; i++) tr[i].siz = tr[i].sons.size();
  if ((n & 1) == 0)
    printf("NO");
  else {
    printf("YES\n");
    alg();
  }
  return 0;
}
