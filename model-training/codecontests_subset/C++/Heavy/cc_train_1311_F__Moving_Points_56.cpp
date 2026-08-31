#include <bits/stdc++.h>
using namespace std;
long long int get(vector<long long int> &arr, long long int ind,
                  long long int n) {
  long long int ans = 0;
  for (; ind > 0; ind -= (ind & (-ind))) ans += arr[ind];
  return ans;
}
void upd(vector<long long int> &arr, long long int ind, long long int x,
         long long int n) {
  for (; ind <= n; ind += (ind & (-ind))) arr[ind] += x;
}
int main() {
  long long int n;
  cin >> n;
  pair<long long int, long long int> arr[n];
  for (long long int i = 0; i < n; i++) cin >> arr[i].first;
  for (long long int i = 0; i < n; i++) cin >> arr[i].second;
  vector<int> vec(n);
  for (long long int i = 0; i < n; i++) vec.push_back(arr[i].second);
  sort(vec.begin(), vec.end());
  vec.resize(unique(vec.begin(), vec.end()) - vec.begin());
  vector<long long int> cnt(vec.size() + 1), cs(vec.size() + 1);
  sort(arr, arr + n);
  long long int ans = 0;
  long long int n1 = vec.size();
  for (long long int i = 0; i < n; i++) {
    long long int pos =
        lower_bound(vec.begin(), vec.end(), arr[i].second) - vec.begin();
    ans += get(cnt, pos + 1, n1) * arr[i].first - get(cs, pos + 1, n1);
    upd(cnt, pos + 1, 1, n1);
    upd(cs, pos + 1, arr[i].first, n1);
  }
  cout << ans << endl;
  return 0;
}
