#include <bits/stdc++.h>
using namespace std;
long long int max(long long int a, long long int b) {
  if (a > b)
    return a;
  else
    return b;
}
long long int min(long long int a, long long int b) {
  if (a < b)
    return a;
  else
    return b;
}
const int dx[4] = {-1, 1, 0, 0};
const int dy[4] = {0, 0, -1, 1};
int XX[] = {-1, -1, -1, 0, 0, 1, 1, 1};
int YY[] = {-1, 0, 1, -1, 1, -1, 0, 1};
long long int fen1[200005] = {0};
long long int maxi = 200003;
void update1(long long int ind, long long int val) {
  for (long long int i = ind; i <= maxi; i += i & -i) fen1[i] += val;
}
long long int sum1(long long int ind) {
  long long int s = 0;
  for (long long int i = ind; i; i -= i & -i) s += fen1[i];
  return s;
}
long long int fen2[200005] = {0};
void update2(long long int ind, long long int val) {
  for (long long int i = ind; i <= maxi; i += i & -i) fen2[i] += val;
}
long long int sum2(long long int ind) {
  long long int s = 0;
  for (long long int i = ind; i; i -= i & -i) s += fen2[i];
  return s;
}
void convert(long long int arr[], long long int n) {
  long long int temp[n];
  memcpy(temp, arr, n * sizeof(long long int));
  sort(temp, temp + n);
  unordered_map<long long int, long long int> umap;
  long long int val = 1;
  for (long long int i = 0; i < n; i++) umap[temp[i]] = val++;
  for (long long int i = 0; i < n; i++) arr[i] = umap[arr[i]];
}
int main() {
  ios_base::sync_with_stdio(false), cin.tie(NULL), cout.tie(NULL);
  long long int i, j, n, k, x, v;
  cin >> n;
  long long int arr1[n];
  for (i = 0; i < n; i++) {
    cin >> arr1[i];
  }
  long long int arr2[n];
  for (i = 0; i < n; i++) {
    cin >> arr2[i];
  }
  convert(arr2, n);
  vector<pair<long long int, long long int> > vec;
  for (i = 0; i < n; i++) {
    vec.push_back(make_pair(arr1[i], arr2[i]));
  }
  sort(vec.begin(), vec.end());
  long long int ans = 0;
  for (i = 0; i < vec.size(); i++) {
    x = vec[i].first;
    v = vec[i].second;
    update1(v, 1);
    update2(v, x);
  }
  for (i = vec.size() - 1; i >= 0; i--) {
    x = vec[i].first;
    v = vec[i].second;
    update1(v, -1);
    update2(v, -x);
    long long int z = sum2(v);
    long long int count = sum1(v);
    ans += (x * count - z);
  }
  cout << ans;
}
