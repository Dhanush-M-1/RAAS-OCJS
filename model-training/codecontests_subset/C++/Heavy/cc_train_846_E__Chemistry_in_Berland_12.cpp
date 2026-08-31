#include <bits/stdc++.h>
using namespace std;
int n;
long long a[100000], b[100000];
vector<pair<int, long long>> connections[100000];
pair<long long, long long> needed(int node) {
  long long temp = a[node] - b[node];
  long long temp2 = temp / 1000000007;
  temp %= 1000000007;
  for (const pair<int, int> edge : connections[node]) {
    pair<long long, long long> curr = needed(edge.first);
    if (curr.first > 0 || curr.first == 0 && curr.second >= 0) {
      curr.first *= edge.second;
      curr.second *= edge.second;
    }
    temp += curr.second;
    temp2 += temp / 1000000007;
    temp %= 1000000007;
    temp2 += curr.first;
  }
  return make_pair(temp2, temp);
}
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cin >> n;
  for (int i = 0; i < (n); i++) cin >> b[i];
  for (int i = 0; i < (n); i++) cin >> a[i];
  for (int i = 0; i < (n - 1); i++) {
    int x;
    long long k;
    cin >> x >> k;
    connections[--x].push_back(make_pair(i + 1, k));
  }
  pair<long long, long long> res = needed(0);
  if (res.first <= 0 && res.second <= 0)
    cout << "YES\n";
  else
    cout << "NO\n";
  return 0;
}
