#include <bits/stdc++.h>
#pragma comment(linker, "/STACK:256000000")
using namespace std;
const double PI = acos(-1.0);
const int INF = 1000000000;
const int MOD = 1000000007;
bool check(vector<int> ar, const vector<vector<int> >& operations) {
  for (int i = 0; i < operations.size(); ++i) {
    int t = operations[i][0];
    if (t == 1) {
      int l = operations[i][1], r = operations[i][2], d = operations[i][3];
      for (int z = l; z <= r; ++z) {
        ar[z] += d;
      }
    } else {
      int l = operations[i][1], r = operations[i][2], m = operations[i][3];
      int cur = -INF - 1;
      for (int z = l; z <= r; ++z) {
        cur = max(ar[z], cur);
      }
      if (cur != m) return 0;
    }
  }
  return 1;
}
vector<int> get(int a, int b, int c, int d) {
  vector<int> current;
  current.push_back(a);
  current.push_back(b);
  current.push_back(c);
  current.push_back(d);
  return current;
}
void random_test(int& n, int m, vector<vector<int> >& operations) {
  vector<int> ar(n, 0);
  for (int i = 0; i < ar.size(); ++i) {
    ar[i] = rand();
  }
  operations.clear();
  for (int i = 0; i < m; ++i) {
    int t = rand() % 2 + 1;
    if (t == 1) {
      int l = rand() % n, r = rand() % n, d = rand();
      if (l > r) swap(l, r);
      for (int z = l; z <= r; ++z) {
        ar[z] += d;
      }
      operations.push_back(get(t, l, r, d));
    } else {
      int l = rand() % n, r = rand() % n;
      int m = -INF;
      if (l > r) swap(l, r);
      for (int z = l; z <= r; ++z) {
        m = max(ar[z], m);
      }
      operations.push_back(get(t, l, r, m));
    }
  }
}
bool my(int n, const vector<vector<int> >& operations) {
  vector<int> a(n, 2 * INF);
  vector<int> coef(n, 0);
  for (int i = 0; i < operations.size(); ++i) {
    int t = operations[i][0];
    if (t == 1) {
      int l = operations[i][1], r = operations[i][2], d = operations[i][3];
      for (int z = l; z <= r; ++z) {
        coef[z] += d;
      }
    } else {
      int l = operations[i][1], r = operations[i][2], m = operations[i][3];
      bool ok = 1;
      for (int z = l; z <= r; ++z) {
        a[z] = min(a[z], m - coef[z]);
      }
    }
  }
  for (int i = 0; i < a.size(); ++i) {
    a[i] = min(a[i], INF);
    if (a[i] < -INF) {
      cout << "NO" << endl;
      return 0;
    }
  }
  if (!check(a, operations)) {
    cout << "NO" << endl;
    return 0;
  }
  cout << "YES" << endl;
  for (int i = 0; i < a.size(); ++i) {
    printf((i == 0) + " %d", a[i]);
  }
  cout << endl;
  return 1;
}
int main() {
  int _start = clock();
  int n, m;
  cin >> n >> m;
  vector<vector<int> > operations;
  for (int i = 0; i < m; ++i) {
    int a, b, c, d;
    scanf("%d%d%d%d", &a, &b, &c, &d);
    --b;
    --c;
    operations.push_back(get(a, b, c, d));
  }
  my(n, operations);
  return 0;
}
