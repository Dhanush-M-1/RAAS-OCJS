#include <bits/stdc++.h>
using namespace std;
struct DS {
  int n;
  vector<int> s;
  vector<int> count;
  DS(int n) : n(n), s(n, -1), count(n, 0) {}
  int find(int i) { return s[i] < 0 ? i : (s[i] = find(s[i])); }
  int counted(int i) { return count[find(i)]; }
  void mark(int i, int x) { count[find(i)] += x; }
  int onion(int a, int b) {
    a = find(a);
    b = find(b);
    if (a == b) {
      return 0;
    }
    if (s[a] == s[b]) s[a]--;
    if (s[a] <= s[b]) {
      s[b] = a;
      count[a] += count[b];
    } else {
      s[a] = b;
      count[b] += count[a];
    }
    return 1;
  }
};
int main() {
  int n, k;
  cin >> n >> k;
  vector<int> l(n);
  string L;
  cin >> L;
  for (int i = 0; i < n; i++) {
    l[i] = L[i] - '0';
  }
  vector<vector<int> > s(n);
  for (int i = 0; i < k; i++) {
    int c;
    cin >> c;
    while (c--) {
      int l;
      cin >> l;
      l--;
      s[l].push_back(i);
    }
  }
  DS ds(2 * k + 1);
  for (int i = 0; i < k; i++) ds.mark(i, 1);
  int sum = 0;
  vector<int> contrib(2 * k + 1, 0);
  auto reset = [&](int i) {
    sum -= contrib[ds.find(i)];
    contrib[ds.find(i)] = 0;
  };
  auto set = [&](int i, int k) {
    contrib[ds.find(i)] = k;
    sum += contrib[ds.find(i)];
  };
  for (int i = 0; i < n; i++) {
    if (false) {
      cout << i << ":";
      for (int p : s[i]) cout << " " << p;
      cout << endl;
    }
    if (s[i].size() == 0) {
    } else if (s[i].size() == 1) {
      reset(2 * k);
      reset(s[i][0] + k);
      reset(s[i][0]);
      if (l[i] == 1) {
        ds.onion(2 * k, s[i][0] + k);
      } else {
        ds.onion(2 * k, s[i][0]);
      }
      set(2 * k, ds.counted(2 * k));
    } else {
      reset(s[i][0]);
      reset(s[i][1]);
      reset(s[i][0] + k);
      reset(s[i][1] + k);
      if (l[i] == 1) {
        ds.onion(s[i][0], s[i][1]);
        ds.onion(s[i][0] + k, s[i][1] + k);
      } else {
        ds.onion(s[i][0] + k, s[i][1]);
        ds.onion(s[i][0], s[i][1] + k);
      }
      int A = ds.find(s[i][0]);
      int B = ds.find(s[i][0] + k);
      if (A == ds.find(2 * k)) {
        set(A, ds.counted(A));
      } else if (B == ds.find(2 * k)) {
        set(B, ds.counted(B));
      } else if (ds.counted(A) < ds.counted(B)) {
        set(A, ds.counted(A));
      } else {
        set(B, ds.counted(B));
      }
    }
    cout << sum << endl;
  }
  return 0;
}
