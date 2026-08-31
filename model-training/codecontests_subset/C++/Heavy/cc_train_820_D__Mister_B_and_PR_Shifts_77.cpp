#include <bits/stdc++.h>
using namespace std;
const int maxn = 1e6 + 10;
int p[maxn], n;
struct Node {
  int i, v;
  Node(int pi = 0, int pv = 0) {
    i = pi;
    v = pv;
  }
  bool operator<(Node a) const { return v < a.v || (v == a.v && i < a.i); }
};
priority_queue<int, vector<int>, greater<int> > q;
int pointer;
int s1size;
long long cur, bestv, bestk;
int main() {
  scanf("%d", &n);
  bestk = cur = 0;
  s1size = 0;
  for (int i = 1; i <= n; i++) {
    scanf("%d", p + i);
    cur += abs(p[i] - i);
    if (p[i] <= i)
      s1size++;
    else
      q.push(p[i] - i);
  }
  bestv = cur;
  pointer = n;
  for (int k = 1; k < n; k++) {
    s1size--;
    cur += p[pointer] - 1LL - (n - p[pointer]);
    cur += s1size - 0LL - q.size();
    q.push(k + p[pointer] - 1);
    if (!--pointer) pointer = n;
    for (int d = q.top(); q.size() && d == k; d = q.top()) {
      q.pop();
      s1size++;
    }
    if (cur < bestv) {
      bestk = k;
      bestv = cur;
    }
  }
  printf("%I64d %d\n", bestv, bestk);
}
