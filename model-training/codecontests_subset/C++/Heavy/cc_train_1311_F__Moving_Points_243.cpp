#include <bits/stdc++.h>
using namespace std;
const int mx = 200005;
long long bit[mx][2];
int arr[mx];
int speed[mx];
vector<pair<int, int> > vec;
void update(int idx, int val) {
  for (int i = idx; i < mx; i += (i & -i)) {
    bit[i][0] += 1LL * val;
    bit[i][1]++;
  }
}
pair<long long, long long> query(int idx) {
  pair<long long, long long> ans = make_pair(0, 0);
  for (int i = idx; i > 0; i -= (i & -i)) {
    ans.first += bit[i][0];
    ans.second += bit[i][1];
  }
  return ans;
}
int main() {
  map<int, int> mpp;
  int n, i, j, k, x, v;
  scanf("%d", &n);
  for (i = 1; i <= n; i++) {
    scanf("%d", arr + i);
  }
  for (i = 1; i <= n; i++) {
    scanf("%d", speed + i);
    vec.push_back(make_pair(speed[i], 0));
  }
  sort(vec.begin(), vec.end());
  for (i = 0; i < n; i++) {
    mpp[vec[i].first] = i + 1;
  }
  vec.clear();
  for (i = 1; i <= n; i++) {
    vec.push_back(make_pair(arr[i], mpp[speed[i]]));
  }
  sort(vec.begin(), vec.end());
  pair<long long, long long> temp;
  long long ans = 0, now;
  for (i = 0; i < n; i++) {
    temp = query(vec[i].second);
    now = 1LL * temp.second * vec[i].first - temp.first;
    ans += now;
    update(vec[i].second, vec[i].first);
  }
  printf("%lld\n", ans);
}
