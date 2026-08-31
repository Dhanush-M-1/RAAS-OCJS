#include <bits/stdc++.h>
using namespace std;
int main(int argc, char const *argv[]) {
  long long n, m;
  cin >> n >> m;
  long long arr[n + 1];
  bool in_suffix[n + 1];
  for (int i = 1; i <= n; ++i) {
    cin >> arr[i];
    in_suffix[i] = false;
  }
  vector<long long> swap[n + 1];
  for (int i = 0; i < m; i++) {
    long long u, v;
    cin >> u >> v;
    swap[u].push_back(v);
  }
  vector<long long> suffix;
  suffix.reserve(n);
  suffix.push_back(arr[n]);
  in_suffix[arr[n]] = true;
  int count = 0;
  for (int i = n - 1; i > 0; i--) {
    int cnt2 = 0;
    for (int j = 0; j < swap[arr[i]].size(); j++) {
      if (in_suffix[swap[arr[i]][j]] == true) {
        cnt2++;
      }
    }
    if (cnt2 == suffix.size()) {
      count++;
    } else {
      in_suffix[arr[i]] = true;
      suffix.push_back(arr[i]);
    }
  }
  cout << count << endl;
  return 0;
}
