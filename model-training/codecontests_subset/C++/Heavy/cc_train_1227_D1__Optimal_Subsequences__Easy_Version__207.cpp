#include <bits/stdc++.h>
using namespace std;
int32_t main() {
  std::ios::sync_with_stdio(false);
  std::cin.tie(NULL);
  std::cout.tie(NULL);
  long long t = 1;
  while (t--) {
    long long n;
    cin >> n;
    vector<long long> ar(n), br(n);
    for (long long i = 0; i < n; i++) {
      cin >> ar[i];
      br[i] = ar[i];
    }
    sort(br.begin(), br.end(), greater<long long>());
    long long m;
    cin >> m;
    while (m--) {
      long long k, pos;
      cin >> k >> pos;
      vector<long long> seq, arr;
      arr = ar;
      for (long long i = 0; i < k; i++) {
        for (long long j = 0; j < n; j++) {
          if (arr[j] == br[i]) {
            seq.push_back(j);
            arr[j] = -1;
            break;
          }
        }
      }
      sort(seq.begin(), seq.end());
      cout << ar[seq[pos - 1]] << "\n";
    }
  }
  return 0;
}
