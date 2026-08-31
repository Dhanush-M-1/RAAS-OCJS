#include <bits/stdc++.h>
using namespace std;
int A[100000], B[100000];
int main(int argc, char **argv) {
  memset(A, -1, sizeof(A));
  int T, M, id = 1;
  cin >> T >> M;
  for (int i = (0); i < (T); ++i) {
    string cmd;
    int n;
    cin >> cmd;
    if (cmd != "defragment") cin >> n;
    if (cmd == "alloc") {
      bool v = 0;
      for (int i = (0); i < (M) && (!v && (i + n - 1 < M)); ++i) {
        v = 1;
        for (int j = (0); j < (n) && (v); ++j) v = A[i + j] == -1;
        if (v) {
          printf("%d\n", id);
          for (int j = (0); j < (n); ++j) A[i + j] = id;
          id++;
        }
      }
      if (!v) puts("NULL");
    }
    if (cmd == "erase") {
      bool v = 0;
      if (n > 0)
        for (int i = (0); i < (M) && (!v); ++i)
          if (A[i] == n) {
            for (int j = (i); j < (M) && (A[j] == n); ++j) A[j] = -1;
            v = 1;
          }
      if (!v) puts("ILLEGAL_ERASE_ARGUMENT");
    }
    if (cmd == "defragment") {
      int c = 0;
      memset(B, -1, sizeof(B));
      for (int i = (0); i < (M); ++i)
        if (A[i] != -1) B[c++] = A[i];
      memcpy(A, B, sizeof(A));
    }
  }
  return 0;
}
