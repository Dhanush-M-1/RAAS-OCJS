#include <bits/stdc++.h>
std::mt19937 rng(
    (int)std::chrono::steady_clock::now().time_since_epoch().count());
const int ms = 110000;
const int bs = 1000;
const int MOD = 998244353;
void add(int &a, int b) { a = a + b < MOD ? a + b : a + b - MOD; }
int *pivot;
bool comp(int x1, int x2) { return pivot[x1] < pivot[x2]; }
int tmp[2][bs];
struct Bucket {
  Bucket() { dirty = size = 0; }
  void push_back(int x) {
    p[size] = size;
    lazy[size] = 0;
    dp[size] = x;
    values[size++] = 0;
  }
  void clean() {
    for (int i = size - 2; i >= 0; i--) {
      add(lazy[i], lazy[i + 1]);
    }
    for (int i = 0; i < size; i++) {
      add(dp[p[i]], lazy[i]);
      lazy[i] = 0;
    }
    if (dirty) {
      for (int i = 0; i < size; i++) {
        values[i] += dirty;
      }
      dirty = 0;
    }
  }
  void sort() {
    clean();
    pivot = values;
    std::sort(p, p + size, comp);
  }
  int getID(int x) {
    if (x < values[p[0]] + dirty) {
      return -1;
    }
    int l = 0, r = size - 1;
    while (l != r) {
      int mid = (l + r + 1) / 2;
      if (values[p[mid]] + dirty <= x) {
        l = mid;
      } else {
        r = mid - 1;
      }
    }
    return l;
  }
  void upd(int x, int l, int r, int val) {
    if (l == 0 && r == size) {
      int id = getID(x);
      if (id != -1) {
        add(lazy[id], val);
      }
    } else {
      for (int i = l; i < r; i++) {
        if (values[i] + dirty <= x) {
          add(dp[i], val);
        } else {
        }
      }
    }
  }
  void upd2(int l, int r, int val) {
    if (l == 0 && r == size) {
      dirty += val;
    } else {
      for (int i = l; i < r; i++) {
        values[i] += val;
      }
      clean();
      pivot = values;
      int s0 = 0, s1 = 0;
      for (int i = 0; i < size; i++) {
        if (l <= p[i] && p[i] < r) {
          tmp[0][s0++] = p[i];
        } else {
          tmp[1][s1++] = p[i];
        }
      }
      std::merge(tmp[0], tmp[0] + s0, tmp[1], tmp[1] + s1, p, comp);
    }
  }
  int values[bs], p[bs], lazy[bs], dp[bs];
  int dirty;
  int size;
};
Bucket b[ms / bs + 2];
std::vector<int> pos[ms];
int a[ms];
int pt[ms];
int main() {
  std::ios_base::sync_with_stdio(false);
  std::cin.tie(NULL);
  int n, k;
  std::cin >> n >> k;
  for (int i = 1; i <= n; i++) {
    pos[i].push_back(-1);
  }
  for (int i = 0; i < n; i++) {
    std::cin >> a[i];
    pos[a[i]].push_back(i);
    b[i / bs].push_back(i == 0 ? 1 : 0);
  }
  b[n / bs].push_back(0);
  for (int i = 1; i <= n; i++) {
    pos[i].push_back(n);
    pos[i].push_back(n);
  }
  auto upd2 = [&](int l, int r, int val) {
    if (l >= r) return;
    int bl = l / bs, br = (r - 1) / bs;
    if (bl == br) {
      b[bl].upd2(l - bl * bs, r - bl * bs, val);
      return;
    }
    b[bl].upd2(l - bl * bs, bs, val);
    for (int i = bl + 1; i < br; i++) {
      b[i].upd2(0, bs, val);
    }
    b[br].upd2(0, r - br * bs, val);
  };
  auto upd = [&](int l, int r, int val) {
    if (l >= r) return;
    int bl = l / bs, br = (r - 1) / bs;
    if (bl == br) {
      b[bl].upd(k, l - bl * bs, r - bl * bs, val);
      return;
    }
    b[bl].upd(k, l - bl * bs, bs, val);
    for (int i = bl + 1; i < br; i++) {
      b[i].upd(k, 0, bs, val);
    }
    b[br].upd(k, 0, r - br * bs, val);
  };
  for (int i = 1; i <= n; i++) {
    upd2(pos[i][1] + 1, pos[i][2] + 1, 1);
  }
  for (int i = 0; i < n; i++) {
    b[i / bs].clean();
    int dp = b[i / bs].dp[i % bs];
    upd(i + 1, n + 1, dp);
    {
      int v = a[i];
      upd2(pos[v][pt[v] + 1] + 1, pos[v][pt[v] + 2] + 1, -1);
      pt[v]++;
      upd2(pos[v][pt[v] + 1] + 1, pos[v][pt[v] + 2] + 1, 1);
    }
  }
  b[n / bs].clean();
  std::cout << b[n / bs].dp[n % bs] << '\n';
}
