#include <bits/stdc++.h>
using namespace std;
int main() {
  long long n;
  cin >> n;
  long long ar[n];
  long long br[n];
  for (auto x = 0; x < n; x++) {
    cin >> ar[x];
    br[x] = ar[x];
  }
  sort(br, br + n);
  long long m;
  cin >> m;
  while (m--) {
    long long pos, k;
    set<long long> s;
    cin >> k >> pos;
    long long bound = br[n - k];
    vector<long long> q;
    for (int x = 0; x < n; x++) {
      if (bound <= ar[x]) {
        q.push_back(ar[x]);
      }
    }
    long long sub = q.size() - k;
    for (int x = q.size() - 1; x >= 0 && sub != 0; x--) {
      if (bound == q[x]) {
        q[x] = -1;
        sub--;
      }
      if (sub == 0) {
        break;
      }
    }
    for (int x = 0; x < q.size(); x++) {
      if (q[x] == -1) {
        continue;
      }
      pos--;
      if (pos == 0) cout << q[x] << endl;
    }
  }
}
