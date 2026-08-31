#include <bits/stdc++.h>
using namespace std;
const int maxn = 2e5 + 10;
int N;
int position[maxn];
long long sum1[maxn << 2], sum2[maxn << 2];
void add(long long* bit, int pos, long long val) {
  while (pos <= N) {
    bit[pos] += val;
    pos += pos & (-pos);
  }
}
long long query(long long* bit, int pos) {
  long long ret = 0;
  while (pos) {
    ret += bit[pos];
    pos -= pos & (-pos);
  }
  return ret;
}
int search(long long* bit, int val) {
  int l = 1, r = N, ret = -1;
  while (l <= r) {
    int mid = (l + r) >> 1;
    if (query(bit, mid) < val) {
      l = mid + 1;
    } else {
      ret = mid;
      r = mid - 1;
    }
  }
  return ret;
}
int main() {
  ios::sync_with_stdio(false);
  cin.tie(nullptr);
  cin >> N;
  for (int i = 1; i <= N; ++i) {
    int p;
    cin >> p;
    position[p] = i;
  }
  long long cnt = 0;
  for (int i = 1; i <= N; ++i) {
    int p = position[i];
    add(sum1, p, 1);
    cnt += i - query(sum1, p);
    add(sum2, p, p);
    long long pos = search(sum1, i / 2 + 1);
    long long sum = 0;
    long long a = i / 2, b = i - a - 1;
    sum += pos * a - a * (a + 1) / 2 - query(sum2, pos - 1);
    sum += (query(sum2, N) - query(sum2, pos)) - b * pos - b * (b + 1) / 2;
    cout << cnt + sum << " ";
  }
  cout << endl;
}
