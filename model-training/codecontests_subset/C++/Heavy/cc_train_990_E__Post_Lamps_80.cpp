#include <bits/stdc++.h>
using namespace std;
class Solution {
 public:
  long long minCost(int n, vector<int>& blocks, vector<int>& prices) {
    int m = prices.size();
    vector<int> pre(n, 0);
    iota(pre.begin(), pre.end(), 0);
    if (!blocks.empty() && blocks[0] == 0) {
      return -1;
    }
    for (int i = 0, j = 0; i < n && j < blocks.size(); ++i) {
      if (i == blocks[j]) {
        pre[i] = pre[i - 1];
        ++j;
      }
    }
    int minL = 0;
    for (int i = 0; i < blocks.size(); ++i) {
      int cnt = 1;
      while (i + 1 < blocks.size() && blocks[i + 1] == blocks[i] + 1) {
        ++i;
        ++cnt;
      }
      minL = max(minL, cnt);
    }
    long long res = LLONG_MAX;
    int minPrice = INT_MAX;
    for (int l = m; l > minL; --l) {
      if (minPrice < prices[l - 1]) {
        continue;
      }
      minPrice = prices[l - 1];
      int cnt = 0;
      int p = 0;
      while (p < n) {
        p += l;
        ++cnt;
        if (p < n && pre[p] != p) {
          p = pre[p];
        }
      }
      res = min(res, 1LL * cnt * prices[l - 1]);
    }
    return res == LLONG_MAX ? -1 : res;
  }
};
int main(int argc, char** argv) {
  int n, m, k;
  scanf("%d%d%d", &n, &m, &k);
  vector<int> blocks;
  blocks.reserve(m);
  for (int i = 0, b = 0; i < m; ++i) {
    scanf("%d", &b);
    blocks.push_back(b);
  }
  vector<int> prices;
  prices.reserve(k);
  for (int i = 0, p = 0; i < k; ++i) {
    scanf("%d", &p);
    prices.push_back(p);
  }
  Solution sol;
  printf("%s\n", to_string(sol.minCost(n, blocks, prices)).c_str());
  return 0;
}
