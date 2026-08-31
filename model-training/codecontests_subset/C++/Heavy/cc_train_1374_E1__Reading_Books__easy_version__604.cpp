#include <bits/stdc++.h>
using namespace std;
long long time(vector<int> l, int il, vector<int> b, int ib, vector<int> r,
               int ir, int k) {
  long long ans = 0;
  int left = k, right = k;
  int index_both = 0;
  int index_right = 0;
  int index_left = 0;
  while (left != 0 && right != 0) {
    if (index_both == ib) {
      if (index_right == ir || index_left == il) {
        return -1;
      } else {
        ans += l[index_left];
        ans += r[index_right];
        index_left++;
        index_right++;
        left--;
        right--;
      }
    } else {
      if (index_right == ir || index_left == il) {
        ans += b[index_both];
        index_both++;
        left--;
        right--;
      } else {
        long long b1 = b[index_both];
        long long t1 = l[index_left] + r[index_right];
        if (b1 <= t1) {
          ans += b1;
          index_both++;
          left--;
          right--;
        } else {
          ans += t1;
          index_left++;
          index_right++;
          left--;
          right--;
        }
      }
    }
  }
  while (left > 0) {
    if (index_both == ib) {
      if (index_left == il)
        return -1;
      else {
        ans += l[index_left];
        index_left++;
        left--;
      }
    } else {
      if (index_left == il) {
        ans += b[index_both];
        index_both++;
        left--;
      } else {
        long long b1 = b[index_both];
        long long l1 = l[index_left];
        if (b1 <= l1) {
          ans += b1;
          index_both++;
          left--;
        } else {
          ans += l1;
          index_left++;
          left--;
        }
      }
    }
  }
  while (right > 0) {
    if (index_both == ib) {
      if (index_right == ir)
        return -1;
      else {
        ans += r[index_right];
        index_right++;
        right--;
      }
    } else {
      if (index_right == ir) {
        ans += b[index_both];
        index_both++;
        right--;
      } else {
        long long b1 = b[index_both];
        long long r1 = r[index_right];
        if (b1 <= r1) {
          ans += b1;
          index_both++;
          right--;
        } else {
          ans += r1;
          index_right++;
          right--;
        }
      }
    }
  }
  return ans;
}
int main() {
  int n, k;
  cin >> n >> k;
  vector<int> l(n);
  vector<int> r(n);
  vector<int> b(n);
  int ib = 0, il = 0, ir = 0;
  int t, ai, bi;
  for (int i = 0; i < n; i++) {
    cin >> t >> ai >> bi;
    if (ai == 1 && bi == 1) {
      b[ib] = t;
      ib++;
    } else if (ai == 1) {
      l[il] = t;
      il++;
    } else if (bi == 1) {
      r[ir] = t;
      ir++;
    }
  }
  vector<int>::iterator it = l.begin();
  advance(it, il);
  sort(l.begin(), it);
  it = r.begin();
  advance(it, ir);
  sort(r.begin(), it);
  it = b.begin();
  advance(it, ib);
  sort(b.begin(), it);
  cout << time(l, il, b, ib, r, ir, k) << '\n';
  return 0;
}
