#include <bits/stdc++.h>
using namespace std;
pair<long long, long long> ara[200005];
map<long long, long long> mark;
long long seg[4 * 300005], seg2[4 * 300005];
long long query(long long qlo, long long qhi, long long lo, long long hi,
                long long pos) {
  if (qlo > hi || qhi < lo || qlo > qhi) return 0;
  if (qlo <= lo && qhi >= hi) return seg[pos];
  long long mid = (lo + hi) / 2;
  return query(qlo, qhi, lo, mid, 2 * pos) +
         query(qlo, qhi, mid + 1, hi, 2 * pos + 1);
}
void update(long long i, long long val, long long lo, long long hi,
            long long pos) {
  if (lo > i || hi < i) return;
  if (lo == i && i == hi) {
    seg[pos] += val;
    return;
  }
  long long mid = (lo + hi) / 2;
  update(i, val, lo, mid, 2 * pos);
  update(i, val, mid + 1, hi, 2 * pos + 1);
  seg[pos] = seg[2 * pos] + seg[2 * pos + 1];
}
long long query2(long long qlo, long long qhi, long long lo, long long hi,
                 long long pos) {
  if (qlo > hi || qhi < lo || qlo > qhi) return 0;
  if (qlo <= lo && qhi >= hi) return seg2[pos];
  long long mid = (lo + hi) / 2;
  return query2(qlo, qhi, lo, mid, 2 * pos) +
         query2(qlo, qhi, mid + 1, hi, 2 * pos + 1);
}
void update2(long long i, long long val, long long lo, long long hi,
             long long pos) {
  if (lo > i || hi < i) return;
  if (lo == i && i == hi) {
    seg2[pos] += val;
    return;
  }
  long long mid = (lo + hi) / 2;
  update2(i, val, lo, mid, 2 * pos);
  update2(i, val, mid + 1, hi, 2 * pos + 1);
  seg2[pos] = seg2[2 * pos] + seg2[2 * pos + 1];
}
vector<long long> vec;
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  long long n;
  cin >> n;
  long long i, j, k;
  for (i = 1; i <= n; i++) {
    cin >> ara[i].second;
    vec.push_back(ara[i].second);
  }
  sort(vec.begin(), vec.end());
  for (i = 0; i < n; i++) {
    mark[vec[i]] = i + 1;
  }
  for (i = 1; i <= n; i++) {
    cin >> ara[i].first;
  }
  sort(ara + 1, ara + n + 1);
  long long fin = 0;
  for (i = n; i >= 1; i--) {
    long long cur = ara[i].second;
    long long tmp = mark[cur];
    long long ans = query(tmp + 1, n, 1, n, 1);
    fin += ans;
    ans = query2(tmp + 1, n, 1, n, 1);
    fin -= (ans * cur);
    update(tmp, cur, 1, n, 1);
    update2(tmp, 1, 1, n, 1);
  }
  cout << fin << endl;
  return 0;
}
