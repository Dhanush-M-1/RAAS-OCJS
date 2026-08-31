#include <bits/stdc++.h>
using namespace std;
const long long mod = 1e9 + 7;
struct hash_pair {
  template <class T1, class T2>
  size_t operator()(const pair<T1, T2> &p) const {
    auto hash1 = hash<T1>{}(p.first);
    auto hash2 = hash<T2>{}(p.second);
    return hash1 ^ hash2;
  }
};
unordered_map<pair<int, int>, int, hash_pair> map_with_pair{};
priority_queue<int, vector<int>, greater<int> > pq_desc;
int n;
long long int maxTreesFell(long long int *x, long long int *h) {
  long long int ans = 1;
  if (n >= 2) ans = 2;
  int i = 1;
  while (i < n - 1) {
    long long int left = x[i] - h[i];
    long long int right = x[i] + h[i];
    if (x[i] > x[i - 1] && left > x[i - 1]) {
      ans++;
    } else if (x[i] > x[i - 1] && right < x[i + 1]) {
      x[i] = right;
      ans++;
    }
    i++;
  }
  return ans;
}
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  cin >> n;
  long long int x[n], h[n];
  for (int i = 0; i < n; i++) cin >> x[i] >> h[i];
  cout << maxTreesFell(x, h) << "\n";
  return 0;
}
