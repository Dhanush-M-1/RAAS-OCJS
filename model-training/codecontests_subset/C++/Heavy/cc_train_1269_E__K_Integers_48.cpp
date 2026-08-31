#include <bits/stdc++.h>
using namespace std;
const int N = 2e5 + 5;
long long bit[N] = {};
int idx[N] = {};
int n;
priority_queue<int> A;
priority_queue<int, vector<int>, greater<int>> B;
long long sum(int x) {
  int ret = 0;
  while (x) {
    ret += bit[x];
    x -= (x & -x);
  }
  return ret;
}
void add(int x, int val) {
  while (x <= n) {
    bit[x] += val;
    x += (x & -x);
  }
}
int main() {
  cin >> n;
  long long x;
  for (int i = 1; i <= n; i++) {
    cin >> x;
    idx[x] = i;
  }
  long long now = 0, d = 0, t;
  x = idx[1];
  for (int i = 1; i <= n; i++) {
    B.emplace(idx[i]);
    A.emplace(B.top());
    B.pop();
    while (A.size() > ((i + 1) >> 1)) {
      B.emplace(A.top());
      A.pop();
    }
    while (A.size() < B.size()) {
      A.emplace(B.top());
      B.pop();
    }
    long long f = A.top(),
              p = (long long)(i / 2) * (i / 2 + 1) - (i / 2) * ((i & 1) == 0),
              t = (long long)A.size() - (f >= x);
    now += abs(idx[i] - x) + (f - x) * (t + t - i);
    x = f;
    add(idx[i], 1);
    d += i - sum(idx[i]);
    cout << now - p + d << " \n"[i == n];
  }
  return 0;
}
