#include <bits/stdc++.h>
using namespace std;
struct node {
  int64_t data, lazy;
  int pos;
};
node st[200001 * 4];
int64_t input[200001];
int anw[200001];
void output(int root, int L, int R) {
  if (L == R) {
    return;
  }
  int mid = (L + R) >> 1;
  output(root << 1, L, mid);
  output(root << 1 | 1, mid + 1, R);
}
void Init(int root, int L, int R) {
  st[root].lazy = 0;
  if (L == R) {
    st[root].data = input[L];
    st[root].pos = L;
    return;
  }
  int mid = (L + R) >> 1;
  Init(root << 1, L, mid);
  Init(root << 1 | 1, mid + 1, R);
  int lpos = root << 1, rpos = root << 1 | 1;
  st[root].data = min(st[lpos].data, st[rpos].data);
  if (st[root].data == st[rpos].data) {
    st[root].pos = st[rpos].pos;
  } else {
    st[root].pos = st[lpos].pos;
  }
}
void Update(int root, int l, int r, int L, int R, int64_t val) {
  if (l == L && r == R) {
    st[root].lazy += val;
    st[root].data += val;
    return;
  }
  int mid = (L + R) >> 1;
  if (st[root].lazy != 0) {
    Update(root << 1, L, mid, L, mid, st[root].lazy);
    Update(root << 1 | 1, mid + 1, R, mid + 1, R, st[root].lazy);
    st[root].lazy = 0;
  }
  if (r <= mid) {
    Update(root << 1, l, r, L, mid, val);
  } else if (mid < l) {
    Update(root << 1 | 1, l, r, mid + 1, R, val);
  } else {
    Update(root << 1, l, mid, L, mid, val);
    Update(root << 1 | 1, mid + 1, r, mid + 1, R, val);
  }
  int lpos = root << 1, rpos = root << 1 | 1;
  st[root].data = min(st[lpos].data, st[rpos].data);
  if (st[root].data == st[rpos].data) {
    st[root].pos = st[rpos].pos;
  } else {
    st[root].pos = st[lpos].pos;
  }
}
int main() {
  ios_base::sync_with_stdio(false);
  int n;
  cin >> n;
  for (int i = 1; i <= n; i++) {
    cin >> input[i];
  }
  Init(1, 1, n);
  int64_t MAX = int64_t(n) * int64_t(n) * int64_t(100);
  if (n == 2) {
    output(1, 1, n);
  }
  for (int i = 1; i <= n; i++) {
    int pos = st[1].pos;
    anw[pos] = i;
    Update(1, pos, pos, 1, n, MAX);
    Update(1, pos, n, 1, n, int64_t(i * -1));
    if (n == 2) {
      output(1, 1, n);
    }
  }
  for (int i = 1; i <= n; i++) {
    cout << anw[i] << " ";
  }
  return 0;
}
