#include <bits/stdc++.h>
using namespace std;
int i, j, m, n, block_size, a[200005], k;
int temp[3][100005], pre[3][100005], smallest[319];
long long sum[319][319], f[200005], dp[200005], inf, mod;
int tag[319];
void update(int l, int r, int c) {
  int block1, block2, ind1, ind2;
  block1 = (l - 1) / block_size;
  block2 = (r - 1) / block_size;
  ind1 = (l - 1) % block_size;
  ind2 = (r - 1) % block_size;
  int i, j;
  for (i = block1 + 1; i <= block2 - 1; i++) {
    tag[i] += c;
    smallest[i] += c;
  }
  long long x[319];
  if (block1 == block2) {
    for (i = l; i <= r; i++) {
      f[i] += c;
    }
    smallest[block1] = inf;
    for (i = block1 * block_size; i <= (block1 + 1) * block_size - 1; i++) {
      f[i + 1] += tag[block1];
      if (f[i + 1] < smallest[block1]) smallest[block1] = f[i + 1];
    }
    for (i = 0; i <= block_size - 1; i++) {
      x[i] = 0;
    }
    for (i = block1 * block_size; i <= (block1 + 1) * block_size - 1; i++) {
      x[f[i + 1] - smallest[block1]] =
          (x[f[i + 1] - smallest[block1]] + dp[i]) % mod;
    }
    sum[block1][0] = x[0];
    for (i = 1; i <= block_size - 1; i++) {
      sum[block1][i] = (sum[block1][i - 1] + x[i]) % mod;
    }
    tag[block1] = 0;
    return;
  }
  for (i = ind1; i <= block_size - 1; i++) {
    f[block1 * block_size + i + 1] += c;
  }
  smallest[block1] = inf;
  for (i = block1 * block_size; i <= (block1 + 1) * block_size - 1; i++) {
    f[i + 1] += tag[block1];
    if (f[i + 1] < smallest[block1]) smallest[block1] = f[i + 1];
  }
  for (i = 0; i <= block_size - 1; i++) {
    x[i] = 0;
  }
  for (i = block1 * block_size; i <= (block1 + 1) * block_size - 1; i++) {
    x[f[i + 1] - smallest[block1]] =
        (x[f[i + 1] - smallest[block1]] + dp[i]) % mod;
  }
  sum[block1][0] = x[0];
  for (i = 1; i <= block_size - 1; i++) {
    sum[block1][i] = (sum[block1][i - 1] + x[i]) % mod;
  }
  tag[block1] = 0;
  for (i = 0; i <= ind2; i++) {
    f[block2 * block_size + i + 1] += c;
  }
  smallest[block2] = inf;
  for (i = block2 * block_size; i <= (block2 + 1) * block_size - 1; i++) {
    f[i + 1] += tag[block2];
    if (f[i + 1] < smallest[block2]) smallest[block2] = f[i + 1];
  }
  for (i = 0; i <= block_size - 1; i++) {
    x[i] = 0;
  }
  for (i = block2 * block_size; i <= (block2 + 1) * block_size - 1; i++) {
    x[f[i + 1] - smallest[block2]] =
        (x[f[i + 1] - smallest[block2]] + dp[i]) % mod;
  }
  sum[block2][0] = x[0];
  for (i = 1; i <= block_size - 1; i++) {
    sum[block2][i] = (sum[block2][i - 1] + x[i]) % mod;
  }
  tag[block2] = 0;
}
int main() {
  mod = 998244353;
  inf = 1000000000;
  scanf("%d%d", &n, &k);
  block_size = int(sqrt(n) + 0.000001);
  for (i = 1; i <= n; i++) {
    scanf("%d", &a[i]);
  }
  for (i = 1; i <= n; i++) {
    if (temp[1][a[i]]) {
      pre[1][i] = temp[1][a[i]];
      if (temp[2][a[i]]) {
        pre[2][i] = temp[2][a[i]];
      }
      temp[2][a[i]] = temp[1][a[i]];
      temp[1][a[i]] = i;
    } else {
      temp[1][a[i]] = i;
    }
  }
  dp[0] = 1;
  for (i = 1; i <= n; i++) {
    update(pre[1][i] + 1, i, 1);
    if (pre[2][i] + 1 <= pre[1][i]) {
      update(pre[2][i] + 1, pre[1][i], -1);
    }
    int block, ind;
    block = (i - 1) / block_size;
    ind = (i - 1) % block_size;
    for (j = 0; j <= block; j++) {
      if (smallest[j] <= k) {
        if (smallest[j] + block_size - 1 > k) {
          dp[i] = (dp[i] + sum[j][k - smallest[j]]) % mod;
        } else {
          dp[i] = (dp[i] + sum[j][block_size - 1]) % mod;
        }
      }
    }
  }
  printf("%lld\n", dp[n]);
  return 0;
}
