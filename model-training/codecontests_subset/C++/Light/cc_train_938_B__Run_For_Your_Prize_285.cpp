#include <bits/stdc++.h>
using namespace std;
const int N = 1e6 + 10;
const int M = 1e6 / 2;
int n, x, m, tmp, ans, k, t;
int a[N], b[N], h[N];
bool mark[N];
void read_input() {
  cin >> n;
  for (int i = 0; i < n; i++) {
    cin >> a[i];
    mark[a[i]] = true;
  }
  for (int i = 1; i < M; i++) {
    if (mark[M + i] || mark[M - i + 1]) {
      tmp = i;
      cout << M - tmp;
      return;
    }
  }
}
int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  read_input();
  return 0;
}
