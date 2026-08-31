#include <bits/stdc++.h>
using namespace std;
long long const modul = 1;
long long mod_sum(long long x, long long y) { return (x + y) % modul; }
long long mod_sub(long long x, long long y) {
  if (x > y) {
    return (x - y) % modul;
  } else {
    return (modul + x - y) % modul;
  }
}
long long mod_mpl(long long x, long long y) { return (x * y) % modul; }
void set_precise(int n) {
  cout << fixed;
  cout << setprecision(n);
}
int const N = 200000;
class Tree {
 private:
  long long tree[N * 4];
  int start;
  int size;
  void rebuild(int id) {
    if (id < 1) {
      return;
    }
    tree[id] = tree[id * 2] + tree[id * 2 + 1];
    rebuild(id / 2);
  };
  long long count_sum(int cur, int left, int right, int cur_l, int cur_r) {
    int mid = (cur_l + cur_r) / 2;
    if ((left == cur_l) && (right == cur_r)) {
      return tree[cur];
    }
    if (right <= mid) {
      return count_sum(cur * 2, left, right, cur_l, mid);
    } else if (left >= mid + 1) {
      return count_sum(cur * 2 + 1, left, right, mid + 1, cur_r);
    } else {
      return count_sum(cur * 2, left, mid, cur_l, mid) +
             count_sum(cur * 2 + 1, mid + 1, right, mid + 1, cur_r);
    }
  };

 public:
  Tree() {
    size = 0;
    start = 0;
  };
  void initialize(int n) {
    int cur = 1;
    int sum = 0;
    while (cur < n) {
      sum += cur;
      cur *= 2;
    }
    start = sum + 1;
    size = cur;
    for (int i = 1; i < start + cur; ++i) {
      tree[i] = 0;
    }
  }
  Tree(int n) {
    int cur = 1;
    int sum = 0;
    while (cur < n) {
      sum += cur;
      cur *= 2;
    }
    start = sum + 1;
    size = cur;
    for (int i = 1; i < start + cur; ++i) {
      tree[i] = 0;
    }
  };
  void update(int pos, long long q, long long no_more) {
    long long cur = tree[start + pos];
    cur += q;
    if (cur > no_more) {
      cur = no_more;
    }
    tree[start + pos] = cur;
    rebuild((start + pos) / 2);
  };
  long long get_sum(int left, int right) {
    if (left > right) {
      return 0;
    }
    return count_sum(1, left, right, 0, size - 1);
  }
};
Tree max_a;
Tree max_b;
int main() {
  int n, k;
  long long a, b;
  int q;
  cin >> n >> k >> a >> b >> q;
  max_a.initialize(n);
  max_b.initialize(n);
  for (int i = 0; i < q; ++i) {
    int type;
    cin >> type;
    if (type == 1) {
      int day;
      long long x;
      cin >> day >> x;
      --day;
      max_a.update(day, x, a);
      max_b.update(day, x, b);
    } else {
      int p;
      cin >> p;
      --p;
      long long ans = 0;
      ans += max_b.get_sum(0, p - 1);
      ans += max_a.get_sum(p + k, n - 1);
      cout << ans << endl;
    }
  }
  return 0;
}
