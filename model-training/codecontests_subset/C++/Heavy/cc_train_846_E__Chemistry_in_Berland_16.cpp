#include <bits/stdc++.h>
using namespace std;
long long n;
vector<long long> arr, brr, need, excess;
vector<pair<long long, long long> > adj;
bool ovr = false;
void compute(long long s) {
  if (excess[s] >= need[s]) {
    excess[s] = excess[s] - need[s];
    need[s] = 0;
  } else {
    need[s] = need[s] - excess[s];
    excess[s] = 0;
  }
  if (s != 0) {
    long long next = adj[s].first;
    long long mul = adj[s].second;
    long long temp = need[s] * mul;
    if (temp < 0) {
      ovr = true;
    }
    need[next] += temp;
    if (need[next] < 0) ovr = true;
    excess[next] += excess[s];
  }
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  ;
  cin >> n;
  arr.resize(n);
  brr.resize(n);
  need.resize(n);
  excess.resize(n);
  adj.resize(n);
  for (int i = 0; i < n; i++) cin >> brr[i];
  for (int i = 0; i < n; i++) cin >> arr[i];
  for (int i = 1; i < n; i++) {
    long long x, k;
    cin >> x >> k;
    adj[i] = {x - 1, k};
  }
  for (long long i = 0; i < n; i++) {
    need[i] = max(arr[i] - brr[i], 0LL);
    excess[i] = max(brr[i] - arr[i], 0LL);
  }
  for (long long i = n - 1; i >= 0; i--) {
    compute(i);
  }
  if (need[0] == 0 && ovr == false)
    cout << "YES" << endl;
  else
    cout << "NO" << endl;
  return 0;
}
