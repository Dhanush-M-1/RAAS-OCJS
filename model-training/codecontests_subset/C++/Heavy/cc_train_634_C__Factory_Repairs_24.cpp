#include <bits/stdc++.h>
using namespace std;
int tree1[2LL * 200009], tree2[2LL * 200009];
int n, k, a, b, q;
int sum(int a, int b, int tree[]) {
  a += n;
  b += n;
  int second = 0;
  while (a <= b) {
    if (a % 2 == 1) second += tree[a++];
    if (b % 2 == 0) second += tree[b--];
    a /= 2;
    b /= 2;
  }
  return second;
}
void add(int k, int x, int tree[], int b) {
  k += n;
  tree[k] = min(b, tree[k] + x);
  for (k /= 2; k >= 1; k /= 2) {
    tree[k] = tree[2 * k] + tree[2 * k + 1];
  }
}
void solve() {
  cin >> n >> k >> a >> b >> q;
  while (q--) {
    int t, d, o;
    cin >> t;
    if (t == 1) {
      cin >> d >> o;
      add(d - 1, o, tree1, b);
      add(d - 1, o, tree2, a);
    } else {
      cin >> d;
      long long int x = 0;
      if (d - 2 >= 0) x = sum(0, max(d - 2, 0), tree1);
      long long int y = sum(d - 2 + k + 1, n - 1, tree2);
      cout << (x + y) << '\n';
    }
  }
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  int T;
  T = 1;
  while (T--) {
    solve();
  }
}
