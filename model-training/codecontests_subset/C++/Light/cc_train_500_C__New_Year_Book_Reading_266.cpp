#include <bits/stdc++.h>
using namespace std;
int a[2000];
int w[2000];
int b[2000];
int mark[2000] = {0};
int book[2000];
int sp = 0;
int main() {
  int i, j, t, n, m;
  deque<int> dq;
  int sum = 0;
  cin >> n >> m;
  for (i = 1; i <= n; ++i) cin >> w[i];
  for (i = 0; i < m; ++i) {
    cin >> b[i];
    if (mark[b[i]] == 0) {
      dq.push_back(b[i]);
      mark[b[i]] = 1;
      for (int i = sp; i > 0; --i) {
        book[i] = book[i - 1];
        sum += w[book[i]];
      }
      book[0] = b[i];
      sp++;
    } else {
      for (j = 0; j < sp; ++j)
        if (book[j] == b[i]) break;
      for (int i = j; i > 0; --i) {
        book[i] = book[i - 1];
        sum += w[book[i]];
      }
      book[0] = b[i];
    }
  }
  cout << sum;
}
