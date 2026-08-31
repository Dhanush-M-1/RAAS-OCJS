#include <bits/stdc++.h>
const long long maxn = 200000 + 10;
class BIT {
 private:
  long long n;
  long long bit[maxn];

 public:
  BIT(long long size) {
    n = size;
    std::fill(bit, bit + maxn, 0);
  }
  void add(long long x, long long v) {
    while (x <= this->n) {
      bit[x] += v;
      x += ((x) & (-x));
    }
  }
  long long query(long long x) {
    long long ans = 0;
    while (x) {
      ans += bit[x];
      x -= ((x) & (-x));
    }
    return ans;
  }
  long long find_k(long long k) {
    long long bits = 0;
    long long n = this->n;
    while (n) {
      n >>= 1;
      bits++;
    }
    long long mask = 0;
    long long cnt = 0;
    for (long long i = bits; i >= 0; i--) {
      mask += 1 << i;
      if (mask > this->n || cnt + bit[mask] >= k)
        mask -= (1 << i);
      else
        cnt += bit[mask];
    }
    return mask + 1;
  }
};
long long n, pos[maxn];
struct TreeNode {
  long long zeros, preadd, sufadd;
  long long presum, sufsum;
};
TreeNode seg[1111111];
void build_tree(long long node, long long L, long long R) {
  seg[node].zeros = R - L + 1;
  if (L == R) return;
  long long M = L + (R - L) / 2;
  build_tree(node << 1, L, M);
  build_tree(node << 1 | 1, M + 1, R);
}
void push_down(long long node, long long L, long long R) {
  long long lch = node << 1;
  long long rch = node << 1 | 1;
  if (seg[node].preadd) {
    seg[lch].preadd += seg[node].preadd;
    seg[rch].preadd += seg[node].preadd;
    seg[lch].presum += seg[lch].zeros * 1LL * seg[node].preadd;
    seg[rch].presum += seg[rch].zeros * 1LL * seg[node].preadd;
    seg[node].preadd = 0;
  }
  if (seg[node].sufadd) {
    seg[lch].sufadd += seg[node].sufadd;
    seg[rch].sufadd += seg[node].sufadd;
    seg[lch].sufsum += seg[lch].zeros * 1LL * seg[node].sufadd;
    seg[rch].sufsum += seg[rch].zeros * 1LL * seg[node].sufadd;
    seg[node].sufadd = 0;
  }
}
long long qL, qR;
void add(long long node, long long L, long long R, long long type) {
  if (qL <= L && R <= qR) {
    if (type == 0) {
      seg[node].preadd += 1;
      seg[node].presum += (long long)seg[node].zeros;
    } else {
      seg[node].sufadd += 1;
      seg[node].sufsum += (long long)seg[node].zeros;
    }
    return;
  }
  push_down(node, L, R);
  long long M = L + (R - L) / 2;
  if (qL <= M) add(node << 1, L, M, type);
  if (qR > M) add(node << 1 | 1, M + 1, R, type);
  long long lch = node << 1;
  long long rch = node << 1 | 1;
  seg[node].zeros = seg[lch].zeros + seg[rch].zeros;
  seg[node].presum = seg[lch].presum + seg[rch].presum;
  seg[node].sufsum = seg[lch].sufsum + seg[rch].sufsum;
}
void erase(long long node, long long L, long long R, long long p) {
  if (L == R) {
    memset(seg + node, 0, sizeof(TreeNode));
    return;
  }
  long long M = L + (R - L) / 2;
  long long lch = node << 1;
  long long rch = node << 1 | 1;
  push_down(node, L, R);
  if (p <= M)
    erase(lch, L, M, p);
  else
    erase(rch, M + 1, R, p);
  seg[node].zeros = seg[lch].zeros + seg[rch].zeros;
  seg[node].presum = seg[lch].presum + seg[rch].presum;
  seg[node].sufsum = seg[lch].sufsum + seg[rch].sufsum;
}
long long query(long long node, long long L, long long R, long long type) {
  if (qL <= L && R <= qR) {
    if (type == 0)
      return seg[node].presum;
    else
      return seg[node].sufsum;
  }
  push_down(node, L, R);
  long long ans = 0;
  long long M = L + (R - L) / 2;
  if (qL <= M) ans += query(node << 1, L, M, type);
  if (qR > M) ans += query(node << 1 | 1, M + 1, R, type);
  return ans;
}
int main() {
  scanf("%lld", &n);
  BIT bit(n);
  for (long long i = 1; i <= n; i++) {
    long long a;
    scanf("%lld", &a);
    pos[a] = i;
  }
  build_tree(1, 1, n);
  long long inversion = 0;
  for (long long i = 1; i <= n; i++) {
    const long long &p = pos[i];
    inversion += i - 1 - bit.query(p);
    bit.add(p, 1);
    qL = p + 1;
    qR = n;
    if (qL <= qR) add(1, 1, n, 0);
    qL = 1;
    qR = p - 1;
    if (qL <= qR) add(1, 1, n, 1);
    erase(1, 1, n, p);
    long long sum = 0;
    long long median = bit.find_k((i + 1) / 2);
    qL = 1;
    qR = median - 1;
    if (qL <= qR) {
      sum += query(1, 1, n, 0);
    }
    qL = median + 1;
    qR = n;
    if (qL <= qR) {
      sum += query(1, 1, n, 1);
    }
    long long ans = inversion + sum;
    printf("%lld ", ans);
  }
  printf("\n");
  return 0;
}
