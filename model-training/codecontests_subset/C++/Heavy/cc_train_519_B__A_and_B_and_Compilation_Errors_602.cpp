#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  ;
  long long n;
  cin >> n;
  vector<long long> V(n, 0), V1(n - 1, 0), V2(n - 2, 0);
  for (long long i = 0; i < n; i++) {
    cin >> V[i];
  }
  sort(V.begin(), V.end());
  for (long long i = 0; i < n - 1; i++) {
    cin >> V1[i];
  }
  sort(V1.begin(), V1.end());
  for (long long i = 0; i < n - 2; i++) {
    cin >> V2[i];
  }
  sort(V2.begin(), V2.end());
  for (long long i = 0; i < n; i++) {
    if (V[i] != V1[i]) {
      cout << V[i] << endl;
      break;
    }
  }
  for (long long i = 0; i < n; i++) {
    if (V1[i] != V2[i]) {
      cout << V1[i] << endl;
      break;
    }
  }
  return 0;
}
