#include <bits/stdc++.h>
using namespace std;
long long int MOD = 100000007;
long long int MX = 1000000000;
long long int n;
pair<long long int, long long int> a[200200];
map<long long int, long long int> sor;
map<long long int, long long int> val;
long long int tree[600005];
long long int lazy[600005];
long long int tree1[600005];
long long int lazy1[600005];
void construct(long long int low, long long int high, long long int pos) {
  if (low == high) {
    tree[pos] = 0;
    return;
  }
  long long int mid = (low + high) / 2;
  construct(low, mid, 2 * pos + 1);
  construct(mid + 1, high, 2 * pos + 2);
  tree[pos] = tree[2 * pos + 1] + tree[2 * pos + 2];
}
long long int MRQ(long long int ql, long long int qh, long long int low,
                  long long int high, long long int pos) {
  if (lazy[pos] != 0) {
    tree[pos] += lazy[pos] * (high - low + 1);
    if (low != high) {
      lazy[2 * pos + 1] += lazy[pos];
      lazy[2 * pos + 2] += lazy[pos];
    }
    lazy[pos] = 0;
  }
  if (low > qh || high < ql) return 0;
  if (ql <= low && qh >= high) return tree[pos];
  long long int mid = (low + high) / 2;
  return MRQ(ql, qh, low, mid, 2 * pos + 1) +
         MRQ(ql, qh, mid + 1, high, 2 * pos + 2);
}
void update(long long int ql, long long int qh, long long int val,
            long long int low, long long int high, long long int pos) {
  if (lazy[pos] != 0) {
    tree[pos] += lazy[pos] * (high - low + 1);
    if (low != high) {
      lazy[2 * pos + 1] += lazy[pos];
      lazy[2 * pos + 2] += lazy[pos];
    }
    lazy[pos] = 0;
  }
  if (low > qh || high < ql) return;
  if (ql <= low && qh >= high) {
    tree[pos] += val * (high - low + 1);
    if (low != high) {
      lazy[2 * pos + 1] += val;
      lazy[2 * pos + 2] += val;
    }
    return;
  }
  long long int mid = (low + high) / 2;
  update(ql, qh, val, low, mid, 2 * pos + 1);
  update(ql, qh, val, mid + 1, high, 2 * pos + 2);
  tree[pos] = tree[2 * pos + 1] + tree[2 * pos + 2];
}
void construct1(long long int low, long long int high, long long int pos) {
  if (low == high) {
    tree1[pos] = 0;
    return;
  }
  long long int mid = (low + high) / 2;
  construct1(low, mid, 2 * pos + 1);
  construct1(mid + 1, high, 2 * pos + 2);
  tree1[pos] = tree1[2 * pos + 1] + tree1[2 * pos + 2];
}
long long int MRQ1(long long int ql, long long int qh, long long int low,
                   long long int high, long long int pos) {
  if (lazy1[pos] != 0) {
    tree1[pos] += lazy1[pos] * (high - low + 1);
    if (low != high) {
      lazy1[2 * pos + 1] += lazy1[pos];
      lazy1[2 * pos + 2] += lazy1[pos];
    }
    lazy1[pos] = 0;
  }
  if (low > qh || high < ql) return 0;
  if (ql <= low && qh >= high) return tree1[pos];
  long long int mid = (low + high) / 2;
  return MRQ1(ql, qh, low, mid, 2 * pos + 1) +
         MRQ1(ql, qh, mid + 1, high, 2 * pos + 2);
}
void update1(long long int ql, long long int qh, long long int val,
             long long int low, long long int high, long long int pos) {
  if (lazy1[pos] != 0) {
    tree1[pos] += lazy1[pos] * (high - low + 1);
    if (low != high) {
      lazy1[2 * pos + 1] += lazy1[pos];
      lazy1[2 * pos + 2] += lazy1[pos];
    }
    lazy1[pos] = 0;
  }
  if (low > qh || high < ql) return;
  if (ql <= low && qh >= high) {
    tree1[pos] += val * (high - low + 1);
    if (low != high) {
      lazy1[2 * pos + 1] += val;
      lazy1[2 * pos + 2] += val;
    }
    return;
  }
  long long int mid = (low + high) / 2;
  update1(ql, qh, val, low, mid, 2 * pos + 1);
  update1(ql, qh, val, mid + 1, high, 2 * pos + 2);
  tree1[pos] = tree1[2 * pos + 1] + tree1[2 * pos + 2];
}
int main() {
  ios::sync_with_stdio(false), cin.tie(NULL), cout.tie(NULL);
  cin >> n;
  for (int i = 1; i <= n; i++) cin >> a[i].first;
  for (int i = 1; i <= n; i++) cin >> a[i].second;
  for (int i = n; i >= 1; i--) {
    sor[a[i].second]++;
  }
  map<long long int, long long int>::iterator itr;
  int cnt = 0;
  for (itr = sor.begin(); itr != sor.end(); itr++) {
    cnt++;
    val[itr->first] = cnt;
  }
  for (int i = 1; i <= n; i++) a[i].second = val[a[i].second];
  sort(a + 1, a + n + 1);
  construct(0, n, 0);
  construct1(0, n, 0);
  long long int res = 0;
  for (int i = n; i >= 1; i--) {
    res += MRQ(a[i].second, n, 0, n, 0) -
           MRQ1(a[i].second, n, 0, n, 0) * a[i].first;
    update1(a[i].second, a[i].second, 1, 0, n, 0);
    update(a[i].second, a[i].second, a[i].first, 0, n, 0);
  }
  cout << res << endl;
  return 0;
}
