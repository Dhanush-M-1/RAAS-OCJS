#include <bits/stdc++.h>
using namespace std;
vector<int> s1;
vector<int> s2;
int a, b;
int print(vector<int> s) {
  int n = s.size();
  for (int i = 0; i < n; i++) cout << s[i] << " ";
  cout << endl;
  return 0;
}
int make1(int d, int ai) {
  s1[d] = min(b, s1[d] + ai);
  d = (d - 1) / 2;
  while (d > 0) {
    s1[d] = s1[d * 2 + 1] + s1[d * 2 + 2];
    d = (d - 1) / 2;
  }
  s2[d] = s2[d * 2 + 1] + s2[d * 2 + 2];
  return 0;
}
int make2(int d, int ai) {
  s2[d] = min(a, s2[d] + ai);
  d = (d - 1) / 2;
  while (d > 0) {
    s2[d] = s2[d * 2 + 1] + s2[d * 2 + 2];
    d = (d - 1) / 2;
  }
  s2[d] = s2[d * 2 + 1] + s2[d * 2 + 2];
  return 0;
}
int get1(int v, int vl, int vr, int l, int r) {
  if (r < l) return 0;
  if (vr < l || vl > r) return 0;
  if (vl >= l && vr <= r) return s1[v];
  int vm = (vl + vr) / 2;
  if (vm < l) return get1(v * 2 + 2, vm + 1, vr, l, r);
  if (vm > r) return get1(v * 2 + 1, vl, vm, l, r);
  if (vm >= l && vr <= r) return s1[v * 2 + 2] + get1(v * 2 + 1, vl, vm, l, r);
  if (vm >= l && vr > r)
    return get1(v * 2 + 2, vm + 1, vr, l, r) + get1(v * 2 + 1, vl, vm, l, r);
  if (vm <= r && vl >= l)
    return s1[v * 2 + 1] + get1(v * 2 + 1, vm + 1, vr, l, r);
  if (vm <= r && vl < l)
    return get1(v * 2 + 2, vm + 1, vr, l, r) + get1(v * 2 + 1, vl, vm, l, r);
}
int get2(int v, int vl, int vr, int l, int r) {
  if (vr < l || vl > r) return 0;
  if (vl >= l && vr <= r) return s2[v];
  int vm = (vl + vr) / 2;
  if (vm < l) return get2(v * 2 + 2, vm + 1, vr, l, r);
  if (vm > r) return get2(v * 2 + 1, vl, vm, l, r);
  if (vm >= l && vr <= r) return s2[v * 2 + 2] + get2(v * 2 + 1, vl, vm, l, r);
  if (vm >= l && vr > r)
    return get2(v * 2 + 2, vm + 1, vr, l, r) + get2(v * 2 + 1, vl, vm, l, r);
  if (vm <= r && vl >= l)
    return s2[v * 2 + 1] + get2(v * 2 + 1, vm + 1, vr, l, r);
  if (vm <= r && vl < l)
    return get2(v * 2 + 2, vm + 1, vr, l, r) + get2(v * 2 + 1, vl, vm, l, r);
}
int main() {
  int n, k, q;
  cin >> n >> k >> a >> b >> q;
  int x = 1;
  while (x < n) x *= 2;
  x *= 2;
  s1.resize(x - 1);
  s2.resize(x - 1);
  for (int i = 0; i < x - 1; i++) {
    s1[i] = 0;
    s2[i] = 0;
  }
  for (int i = 0; i < q; i++) {
    int y;
    cin >> y;
    if (y == 1) {
      int d, ai;
      cin >> d;
      cin >> ai;
      make1(x / 2 - 2 + d, ai);
      make2(x / 2 - 2 + d, ai);
    } else {
      int p;
      cin >> p;
      get2(0, 0, x / 2 - 1, p + k - 1, x / 2 - 1);
      cout << get1(0, 0, x / 2 - 1, 0, p - 2) +
                  get2(0, 0, x / 2 - 1, p + k - 1, x / 2 - 1)
           << endl;
    }
  }
  return 0;
}
