#include <bits/stdc++.h>
int size = 256 * 1024;
int Count(std::vector<int>& tree, int l, int r) {
  l += size;
  r += size;
  int ans = 0;
  while (l <= r) {
    if (l % 2) {
      ans += tree[l];
      ++l;
    }
    if (r % 2 == 0) {
      ans += tree[r];
      --r;
    }
    if (l > r) break;
    r >>= 1;
    l >>= 1;
  }
  return ans;
}
void Add(std::vector<int>& tree, int ind) {
  ind += size;
  while (ind) {
    ++tree[ind];
    ind >>= 1;
  }
}
int main() {
  int64_t own = 0;
  int n;
  std::cin >> n;
  std::vector<int> array(n);
  std::vector<int> where(n);
  std::vector<int> add(n);
  for (int i = 0; i < n; ++i) {
    std::cin >> array[i];
    --array[i];
    where[array[i]] = i;
  }
  {
    std::vector<int> tree(size * 2, 0);
    for (int i = 0; i < n; ++i) {
      add[i] = Count(tree, where[i], n - 1);
      Add(tree, where[i]);
    }
  }
  std::cout << 0 << ' ';
  std::set<int> pos;
  pos.insert(where[0]);
  int median = where[0];
  int64_t dist = 0;
  std::vector<int> tree(size * 2, 0);
  Add(tree, where[0]);
  for (int i = 1; i < n; ++i) {
    own += add[i];
    if (where[i] >= median) {
      dist -= Count(tree, where[i], n - 1);
    } else {
      dist -= Count(tree, 0, where[i]);
    }
    pos.insert(where[i]);
    if (where[i] > median && (i % 2 == 0)) {
      median = *pos.upper_bound(median);
    } else if (where[i] < median && (i % 2 == 1)) {
      int n_median = *(--pos.lower_bound(median));
      dist += (median - n_median - 1);
      median = n_median;
    }
    if (where[i] > median) {
      dist += (where[i] - median - Count(tree, median, where[i] - 1));
    } else {
      dist += (median - where[i] - Count(tree, where[i] + 1, median));
    }
    std::cout << own + dist << ' ';
    Add(tree, where[i]);
  }
  return 0;
}
