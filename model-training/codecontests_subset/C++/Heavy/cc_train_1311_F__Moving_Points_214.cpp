#include <bits/stdc++.h>
using namespace std;
long long int ans = 0;
void merger(vector<pair<long long int, long long int> > &v, long long int l,
            long long int mid, long long int r) {
  long long int n1 = mid - l + 1, n2 = r - mid;
  pair<long long int, long long int> larr[n1], rarr[n2];
  long long int lsum[n1], rsum[n2];
  for (long long int i = 0; i < n1; i++) larr[i] = v[l + i];
  for (long long int i = n1 - 1; i >= 0; i--) {
    if (i == n1 - 1)
      lsum[i] = larr[i].first;
    else
      lsum[i] = lsum[i + 1] + larr[i].first;
  }
  for (long long int i = 0; i < n2; i++) rarr[i] = v[mid + i + 1];
  for (long long int i = n2 - 1; i >= 0; i--) {
    if (i == n2 - 1)
      rsum[i] = rarr[i].first;
    else
      rsum[i] = rsum[i + 1] + rarr[i].first;
  }
  long long int i = 0, j = 0, k = l;
  while (i < n1 && j < n2) {
    if (larr[i].second <= rarr[j].second) {
      v[k] = larr[i];
      ans += rsum[j];
      ans -= ((n2 - j) * (larr[i].first));
      i++;
    } else {
      v[k] = rarr[j++];
    }
    k++;
  }
  while (i < n1) v[k++] = larr[i++];
  while (j < n2) v[k++] = rarr[j++];
}
void msort(vector<pair<long long int, long long int> > &v, long long int l,
           long long int r) {
  if (l < r) {
    long long int mid = l + (r - l) / 2;
    msort(v, l, mid);
    msort(v, mid + 1, r);
    merger(v, l, mid, r);
  }
}
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  long long int n;
  cin >> n;
  vector<pair<long long int, long long int> > v;
  long long int a[n], b[n];
  for (long long int i = 0; i < n; i++) cin >> a[i];
  for (long long int i = 0; i < n; i++) cin >> b[i];
  for (long long int i = 0; i < n; i++) v.push_back(make_pair(a[i], b[i]));
  sort(v.begin(), v.end());
  msort(v, 0, n - 1);
  cout << ans;
}
