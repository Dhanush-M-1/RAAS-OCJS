#include <bits/stdc++.h>
using namespace std;
struct node {
  int i, l;
} tree[101000];
int main() {
  int n;
  cin >> n;
  for (int i = 0; i < n; i++) {
    cin >> tree[i].i >> tree[i].l;
  }
  if (n == 1 || n == 2)
    cout << n << endl;
  else {
    int flag = 2;
    for (int i = 1; i < n - 1; i++) {
      if (tree[i].i - tree[i].l > tree[i - 1].i) {
        flag++;
      } else if (tree[i].i + tree[i].l < tree[i + 1].i) {
        flag++;
        tree[i].i += tree[i].l;
      }
    }
    cout << flag << endl;
  }
}
