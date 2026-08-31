#include <bits/stdc++.h>
using namespace std;
struct node {
  int offset;
  int len;
  int id;
};
bool operator<(node a, node b) { return a.offset < b.offset; };
vector<node> data;
int main() {
  int n, m;
  while (scanf("%d%d", &n, &m) != EOF) {
    data.clear();
    node gao;
    gao.offset = 0;
    gao.len = 0;
    gao.id = -1;
    data.push_back(gao);
    gao.offset = m;
    gao.len = 0;
    data.push_back(gao);
    int cnt = 1;
    for (int i = 0; i < n; i++) {
      char buf[100];
      int op;
      scanf("%s", buf);
      if (buf[0] == 'a') {
        bool succ = false;
        scanf("%d", &op);
        for (int j = 0; j < data.size() - 1; j++) {
          int start = data[j].offset + data[j].len;
          if (data[j + 1].offset - start >= op) {
            node newnode;
            newnode.offset = start;
            newnode.id = cnt;
            newnode.len = op;
            data.insert(data.begin() + j + 1, newnode);
            succ = true;
            printf("%d\n", cnt++);
            break;
          }
        }
        if (!succ) printf("NULL\n");
      } else if (buf[0] == 'e') {
        scanf("%d", &op);
        if (op <= 0) {
          puts("ILLEGAL_ERASE_ARGUMENT");
          continue;
        }
        bool succ = false;
        for (int j = 0; j < data.size(); j++) {
          if (data[j].id == op) {
            succ = true;
            data.erase(data.begin() + j);
            break;
          }
        }
        if (!succ) puts("ILLEGAL_ERASE_ARGUMENT");
      } else {
        for (int j = 1; j < data.size() - 1; j++) {
          data[j].offset = data[j - 1].offset + data[j - 1].len;
        }
      }
    }
  }
}
