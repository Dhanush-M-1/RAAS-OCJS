#include <bits/stdc++.h>
using namespace std;
const int maxn = 1e5 + 10;
inline int read() {
  int x = 0, f = 1;
  char ch = getchar();
  while (!isdigit(ch)) {
    if (ch == '-') f = -1;
    ch = getchar();
  }
  while (isdigit(ch)) {
    x = x * 10 + ch - 48;
    ch = getchar();
  }
  return x * f;
}
priority_queue<int, vector<int>, greater<int>> v, v1, v2;
int main() {
  int n = read(), k = read();
  for (int i = 0; i < n; i++) {
    int t = read(), a = read(), b = read();
    if (a && b) {
      v.push(t);
    } else if (a) {
      v1.push(t);
    } else if (b) {
      v2.push(t);
    }
  }
  long long sum = 0;
  if (v.size() + min(v1.size(), v2.size()) >= k) {
    for (int i = 0; i < k; i++) {
      if (v.size() && v1.size() && v2.size()) {
        if (v.top() < v1.top() + v2.top()) {
          sum += v.top();
          v.pop();
        } else {
          sum += v1.top() + v2.top();
          v1.pop();
          v2.pop();
        }
      } else if (v.size()) {
        sum += v.top();
        v.pop();
      } else if (v1.size() && v2.size()) {
        sum += v1.top() + v2.top();
        v1.pop();
        v2.pop();
      }
    }
    printf("%lld\n", sum);
  } else {
    printf("-1\n");
  }
  return 0;
}
