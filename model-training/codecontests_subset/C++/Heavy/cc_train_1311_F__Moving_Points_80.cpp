#include <bits/stdc++.h>
using namespace std;
int n;
long long BIT[515151];
int BIT2[515151];
map<int, int> hs;
void update(int x, int y) {
  for (int i = x; i <= 5e5; i += (i & (-i))) BIT[i] += y, BIT2[i]++;
}
long long query(int x) {
  long long tmp = 0;
  for (int i = x; i >= 1; i -= (i & (-i))) tmp += BIT[i];
  return tmp;
}
long long query2(int x) {
  int tmp = 0;
  for (int i = x; i >= 1; i -= (i & (-i))) tmp += BIT2[i];
  return tmp;
}
int main() {
  scanf("%d", &n);
  int x[n + 5], v[n + 5];
  for (int i = 0; i < n; i++) {
    scanf("%d", &x[i]);
  }
  vector<int> tmp;
  for (int i = 0; i < n; i++) {
    scanf("%d", &v[i]);
    tmp.push_back(v[i]);
  }
  sort(tmp.begin(), tmp.end());
  int idx = 1;
  for (auto i : tmp) {
    hs[i] = idx;
    idx++;
  }
  for (int i = 0; i < n; i++) {
    v[i] = hs[v[i]];
  }
  vector<pair<int, int> > data;
  for (int i = 0; i < n; i++) {
    data.push_back(make_pair(x[i], v[i]));
  }
  sort(data.begin(), data.end());
  long long ans = 0;
  for (auto i : data) {
    long long cnt1 = query(i.second);
    long long cnt2 = query2(i.second);
    ans += (cnt2 * i.first - cnt1);
    update(i.second, i.first);
  }
  printf("%I64d\n", ans);
}
