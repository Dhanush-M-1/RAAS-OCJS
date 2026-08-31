#include <bits/stdc++.h>
using namespace std;
struct Node {
  bool byl;
  bool ref;
  int prev;
};
Node nodes[1100];
vector<int> delky;
bool cansize[3300];
int main() {
  int N, X;
  scanf("%d%d", &N, &X);
  --X;
  int ixoff;
  for (int i = 0; i < N; ++i) {
    scanf("%d", &nodes[i].prev);
    nodes[i].prev--;
    nodes[nodes[i].prev].ref = true;
  }
  for (int i = 0; i < N; ++i) {
    if (!nodes[i].ref) {
      int curr = i;
      int len = 1;
      bool isix = false;
      if (curr == X) {
        isix = true;
        ixoff = 0;
      }
      while (nodes[curr].prev != -1) {
        curr = nodes[curr].prev;
        len++;
        if (isix) ixoff++;
        if (curr == X) {
          isix = true;
          ixoff = 0;
        }
      }
      if (!isix) {
        delky.push_back(len);
      }
    }
  }
  cansize[0] = 1;
  for (int i = 0; i < delky.size(); ++i) {
    for (int j = N + 1 - delky[i]; j >= 0; --j) {
      if (cansize[j]) {
        cansize[j + delky[i]] = true;
      }
    }
  }
  for (int i = 0; i < N; ++i) {
    if (cansize[i]) {
      printf("%d\n", i + ixoff + 1);
    }
  }
  return 0;
}
