#include <bits/stdc++.h>
using namespace std;
int blkbase[(350 + 5)][(350 + 5)];
int blkpsum[(350 + 5)][(350 + 5)];
int f[100005];
int n, k;
int a[100005];
int previ[100005];
int previval[100005];
int blk[100005];
int blkbegin[100005];
int blkend[1000005];
int cur[100005];
int cur_offset[(350 + 5)];
int cur_cnt[(350 + 5)];
int cur_total = 0;
int blkcnt;
bool cmp(int A, int B) { return cur[A] < cur[B]; }
void rebuild(int block) {
  for (int i = blkbegin[block], j = 1; j <= 350; i++, j++) {
    blkbase[block][j] = i;
  }
  sort(blkbase[block] + 1, blkbase[block] + 350 + 1, cmp);
  int r = 0;
  for (int i = 1; i <= 350; i++) {
    blkpsum[block][i] = blkpsum[block][i - 1] + f[blkbase[block][i] - 1];
    if (blkpsum[block][i] >= 998244353) blkpsum[block][i] -= 998244353;
    if (cur[blkbase[block][i]] <= k) r = i;
  }
  cur_total -= cur_cnt[block];
  cur_total += blkpsum[block][r];
  cur_cnt[block] = blkpsum[block][r];
  cur_total %= 998244353;
  cur_total += 998244353;
  cur_total %= 998244353;
}
void update(int l, int r, int change) {
  for (int i = blk[l] + 1; i < blk[r]; i++) {
    cur_offset[i] += change;
    int L = 0, R = 350;
    while (L < R) {
      int mid = (L + R) / 2 + 1;
      if (cur[blkbase[i][mid]] + cur_offset[i] <= k) {
        L = mid;
      } else {
        R = mid - 1;
      }
    }
    cur_total -= cur_cnt[i];
    cur_total += blkpsum[i][R];
    cur_cnt[i] = blkpsum[i][R];
    cur_total %= 998244353;
    cur_total += 998244353;
    cur_total %= 998244353;
  }
  for (int i = blkbegin[blk[l]]; i <= blkend[blk[l]]; i++) {
    cur[i] += cur_offset[blk[l]];
  }
  cur_offset[blk[l]] = 0;
  for (int i = l; i <= blkend[blk[l]] && i <= r; i++) {
    cur[i] += change;
  }
  for (int j = 1; j <= n; j++) {
  }
  rebuild(blk[l]);
  if (blk[l] != blk[r]) {
    for (int i = blkbegin[blk[r]]; i <= blkend[blk[r]]; i++) {
      cur[i] += cur_offset[blk[r]];
    }
    cur_offset[blk[r]] = 0;
    for (int i = blkbegin[blk[r]]; i <= r; i++) {
      cur[i] += change;
    }
    rebuild(blk[r]);
  }
}
int main() {
  cur[0] = -10000000;
  scanf("%d%d", &n, &k);
  for (int i = 1; i <= n; i++) {
    scanf("%d", a + i);
    previ[i] = previval[a[i]];
    previval[a[i]] = i;
  }
  for (int i = 1; i <= 100000; i++) blk[i] = (i - 1) / 350 + 1;
  for (int i = 1; i <= 350; i++) {
    blkbegin[i] = (i - 1) * 350 + 1;
    blkend[i] = blkbegin[i] + 350 - 1;
    for (int j = (i - 1) * 350 + 1, x = 1; x <= 350; j++, x++) {
      blkbase[i][x] = j;
    }
  }
  f[0] = 1;
  rebuild(1);
  for (int i = 1; i <= n; i++) {
    update(previ[i] + 1, i, 1);
    if (previ[i]) update(previ[previ[i]] + 1, previ[i], -1);
    f[i] = cur_total;
    for (int j = 0; j < 350; j++) {
      cur[blkbegin[blk[i + 1]] + j] += cur_offset[blk[i + 1]];
    }
    cur_offset[blk[i + 1]] = 0;
    for (int j = 1; j <= n; j++) {
    }
    rebuild(blk[i + 1]);
  }
  printf("%d", f[n]);
  return 0;
}
