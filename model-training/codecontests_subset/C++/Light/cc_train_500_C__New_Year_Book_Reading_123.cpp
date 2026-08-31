#include <bits/stdc++.h>
using namespace std;
const double kEps = 10e-8;
const int kMax = 1005;
const int kInf = 1 << 30;
int main(int argc, char **argv) {
  int n, m;
  int w[kMax];
  int b[kMax];
  scanf("%d %d", &n, &m);
  for (int i = 1; i <= n; i++) {
    scanf("%d", &w[i]);
  }
  for (int i = 0; i < m; i++) {
    scanf("%d", &b[i]);
  }
  set<int> in;
  int cost = 0;
  int S[kMax];
  int top = 0;
  for (int i = 0; i < m; i++) {
    int book = b[i];
    if (in.find(book) != in.end()) {
      int t;
      for (t = top - 1; t >= 0 && S[t] != book; t--) {
        cost += w[S[t]];
      }
      while (t + 1 < top) {
        S[t] = S[t + 1];
        t++;
      }
      S[top - 1] = book;
    } else {
      in.insert(book);
      for (int t = 0; t < top; t++) {
        cost += w[S[t]];
      }
      S[top++] = book;
    }
  }
  cout << cost << endl;
  return EXIT_SUCCESS;
}
