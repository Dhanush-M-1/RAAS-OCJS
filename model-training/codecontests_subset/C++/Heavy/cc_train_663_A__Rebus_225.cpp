#include <bits/stdc++.h>
const int INF_INT = 0x3f3f3f3f;
const long long INF_LL = 0x7f7f7f7f;
const int MOD = 1e9 + 7;
const double eps = 1e-10;
const double pi = acos(-1);
using namespace std;
int n;
int main(int argc, char const *argv[]) {
  string s, t;
  int pos = 0;
  int neg = 0;
  queue<char> q;
  while (1) {
    cin >> s >> t;
    if (t == "=")
      break;
    else if (t == "+")
      pos++;
    else if (t == "-")
      neg++;
    q.push(t[0]);
  }
  scanf("%d", &n);
  if (!pos && !neg) {
    printf("Possible\n");
    printf("%d = %d\n", n, n);
    return 0;
  }
  if (pos - n * neg > n || n * (pos + 1) - neg < n) {
    printf("Impossible\n");
    return 0;
  } else {
    puts("Possible");
    if (pos == neg) {
      printf("%d", n);
      while (q.size()) {
        printf(" %c 1", q.front());
        q.pop();
      }
      printf(" = %d\n", n);
    } else if (pos > neg) {
      int tmp = abs(pos - neg);
      queue<int> qq;
      for (int i = 1; i <= neg; i++) {
        if (tmp >= n - 1)
          qq.push(n), tmp -= n - 1;
        else
          qq.push(1 + tmp), tmp = 0;
      }
      printf("%d", n - tmp);
      while (q.size()) {
        char c = q.front();
        q.pop();
        if (c == '-')
          printf(" - %d", qq.front()), qq.pop();
        else
          printf(" + 1");
      }
      printf(" = %d\n", n);
    } else if (pos < neg) {
      printf("%d", n);
      int tmp = abs(pos - neg);
      queue<int> qq;
      for (int i = 1; i <= pos; i++) {
        if (tmp >= n - 1)
          qq.push(n), tmp -= n - 1;
        else
          qq.push(1 + tmp), tmp = 0;
      }
      while (q.size()) {
        char c = q.front();
        q.pop();
        if (c == '+')
          printf(" + %d", qq.front()), qq.pop();
        else
          printf(" - 1");
      }
      printf(" = %d\n", n);
    }
  }
  return 0;
}
